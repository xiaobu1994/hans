package com.xiaobu.core.template.config;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Service模板生成的配置
 */
@Data
public class ServiceConfig {

    private ContextConfig contextConfig;

    private String servicePathTemplate;

    private String serviceImplPathTemplate;

    private String packageName;

    private List<String> serviceImplImports;

    public void init() {
        ArrayList<String> imports = new ArrayList<>();
        imports.add("org.springframework.stereotype.Service");
        imports.add("com.xiaobu." +  "service.I" + contextConfig.getBizEnBigName() + "Service");
        this.serviceImplImports = imports;
        this.servicePathTemplate = "\\src\\main\\java\\com\\xiaobu\\"+contextConfig.getModuleName() + "service\\I{}Service.java";
        this.serviceImplPathTemplate = "\\src\\main\\java\\com\\xiaobu\\" + contextConfig.getModuleName()+ "service\\impl\\{}ServiceImpl.java";
        this.packageName = "com.xiaobu" +  ".service";
    }
}
