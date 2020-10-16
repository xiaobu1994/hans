package com.xiaobu.controller;

import com.google.code.kaptcha.Constants;
import com.xiaobu.common.controller.BaseController;
import com.xiaobu.common.exception.InvalidKaptchaException;
import com.xiaobu.common.node.MenuNode;
import com.xiaobu.core.log.LogManager;
import com.xiaobu.core.log.factory.LogTaskFactory;
import com.xiaobu.core.shiro.ShiroKit;
import com.xiaobu.core.shiro.ShiroUser;
import com.xiaobu.core.util.ToolUtil;
import com.xiaobu.entity.User;
import com.xiaobu.mapper.MenuMapper;
import com.xiaobu.mapper.UserMapper;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Objects;

import static com.xiaobu.core.support.HttpKit.getIp;


/**
 * 登录控制器
 */
@ApiIgnore
@Controller
public class LoginController extends BaseController {

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    UserMapper userMapper;

    /**
     * 跳转到主页
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        //获取菜单列表
        List<Integer> roleList = Objects.requireNonNull(ShiroKit.getUser()).getRoleList();
        if (roleList == null || roleList.size() == 0) {
            ShiroKit.getSubject().logout();
            model.addAttribute("tips", "该用户没有角色，无法登陆");
            return "/login.html";
        }
        List<MenuNode> menus = menuMapper.getMenusByRoleIds(roleList);
        List<MenuNode> titles = MenuNode.buildTitle(menus);
        model.addAttribute("titles", titles);

        //获取用户头像
        Integer id = ShiroKit.getUser().getId();
        User user = userMapper.selectByPrimaryKey(id);
        String avatar = user.getAvatar();
        model.addAttribute("avatar", avatar);

        return "/index.html";
    }

    /**
     * 跳转到登录页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        if (ShiroKit.isAuthenticated() || ShiroKit.getUser() != null) {
            return REDIRECT + "/";
        } else {
            return "/login.html";
        }
    }

    /**
     * 点击登录执行的动作
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginVali() {
        String username = super.getPara("username").trim();
        String password = super.getPara("password").trim();
        //验证验证码是否正确
        if (ToolUtil.getKaptchaOnOff()) {
            String kaptcha = super.getPara("kaptcha").trim();
            String code = (String) super.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if (ToolUtil.isEmpty(kaptcha) || !kaptcha.equals(code)) {
                throw new InvalidKaptchaException();
            }
        }
        Subject currentUser = ShiroKit.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());
        token.setRememberMe(true);
        // 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
        // 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
        // 所以这一步在调用login(token)方法时,它会走到xxRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
        currentUser.login(token);
        ShiroUser shiroUser = ShiroKit.getUser();
        super.getSession().setAttribute("shiroUser", shiroUser);
        assert shiroUser != null;
        super.getSession().setAttribute("username", shiroUser.getAccount());
        LogManager.me().executeLog(LogTaskFactory.loginLog(shiroUser.getId(), getIp()));
        ShiroKit.getSession().setAttribute("sessionFlag", true);
        return REDIRECT + "/";
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut() {
        LogManager.me().executeLog(LogTaskFactory.exitLog(Objects.requireNonNull(ShiroKit.getUser()).getId(), getIp()));
        ShiroKit.getSubject().logout();
        return REDIRECT + "/login";
    }
}
