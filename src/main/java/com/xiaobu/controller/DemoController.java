package com.xiaobu.controller;

import com.xiaobu.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

/**
 * demo模块控制器
 *
 * @author xiaobu
 * @Date 2019-03-27 09:41:46
 */
@ApiIgnore
@Controller
@RequestMapping("/demo")
public class DemoController extends BaseController {

    private String prefix = "/demo/";

    /**
     * 跳转到demo模块首页
     */
    @RequestMapping("")
    public String index() {
        return prefix + "demo.html";
    }

    /**
     * 跳转到添加demo模块
     */
    @RequestMapping("/demo_add")
    public String demoAdd() {
        return prefix + "demo_add.html";
    }

    /**
     * 跳转到修改demo模块
     */
    @RequestMapping("/demo_update/{demoId}")
    public String demoUpdate(@PathVariable Integer demoId, Model model) {
        return prefix + "demo_edit.html";
    }

    /**
     * 获取demo模块列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return null;
    }

    /**
     * 新增demo模块
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() {
        return SUCCESS_TIP;
    }

    /**
     * 删除demo模块
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改demo模块
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return SUCCESS_TIP;
    }

    /**
     * demo模块详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
