package com.xiaobu.core.template.config;

import lombok.Data;

/**
 * 页面 模板生成的配置
 */
@Data
public class PageConfig {

    private ContextConfig contextConfig;
    /**
     * 页面路径
     */
    private String pagePathTemplate;
    /**
     * 增加页面路径
     */
    private String pageAddPathTemplate;
    /**
     * 编辑页面路径
     */
    private String pageEditPathTemplate;
    /**
     * js页面路径
     */
    private String pageJsPathTemplate;
    /**
     * 详情js页面路径
     */
    private String pageInfoJsPathTemplate;

    public void init() {
        pagePathTemplate = "\\src\\main\\resources\\WEB-INF\\view\\"  + "{}\\{}.html";
        pageAddPathTemplate = "\\src\\main\\resources\\WEB-INF\\view\\" +  "{}\\{}_add.html";
        pageEditPathTemplate = "\\src\\main\\resources\\WEB-INF\\view\\" + "{}\\{}_edit.html";
        pageJsPathTemplate = "\\src\\main\\resources\\static\\" + "{}\\{}.js";
        pageInfoJsPathTemplate = "\\src\\main\\resources\\static\\" +"{}\\{}_info.js";
    }

}
