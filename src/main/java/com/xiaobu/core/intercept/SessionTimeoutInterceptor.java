package com.xiaobu.core.intercept;

import com.xiaobu.common.controller.BaseController;
import com.xiaobu.core.shiro.ShiroKit;
import com.xiaobu.core.support.HttpKit;
import org.apache.shiro.session.InvalidSessionException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 验证session超时的拦截器
 */
@Aspect
@Component
@ConditionalOnProperty(prefix = "hans", name = "session-open", havingValue = "true")
public class SessionTimeoutInterceptor extends BaseController {

    @Pointcut("execution(* com.xiaobu.*..controller.*.*(..))")
    public void cutService() {
    }

    @Around("cutService()")
    public Object sessionTimeoutValidate(ProceedingJoinPoint point) throws Throwable {

        String servletPath = HttpKit.getRequest().getServletPath();

        if ("/kaptcha".equals(servletPath) || "/login".equals(servletPath) || "/global/sessionError".equals(servletPath)) {
            return point.proceed();
        }else{
            HttpServletRequest request = HttpKit.getRequest();
            if(ShiroKit.getSession().getAttribute("sessionFlag") == null){
                ShiroKit.getSubject().logout();
                throw new InvalidSessionException();
            }else{
                return point.proceed();
            }
        }
    }
}
