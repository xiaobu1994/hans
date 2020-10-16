package com.xiaobu.core.template.config;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 控制器模板生成的配置
 */
@Data
public class ControllerConfig {

    private ContextConfig contextConfig;
    //文件所在路径
    private String controllerPathTemplate;
    //包名称
    private String packageName;
    //所引入的包
    private List<String> imports;

    public void init() {
        ArrayList<String> imports = new ArrayList<>();
        imports.add("com.xiaobu.common.controller.BaseController");
        imports.add("org.springframework.stereotype.Controller");
        imports.add("org.springframework.web.bind.annotation.RequestMapping");
        imports.add("org.springframework.web.bind.annotation.ResponseBody");
        imports.add("org.springframework.ui.Model");
        imports.add("org.springframework.web.bind.annotation.PathVariable");
        this.imports = imports;
        this.packageName = "com.xiaobu." + contextConfig.getModuleName()+ "controller";
        this.controllerPathTemplate = "\\src\\main\\java\\com\\xiaobu\\" +contextConfig.getModuleName()+ "controller\\{}Controller.java";
    }
}
