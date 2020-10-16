package com.xiaobu.core.template.config;


import com.xiaobu.core.util.ToolUtil;
import lombok.Data;

/**
 * 全局配置
 */
@Data
public class ContextConfig {
    /**
     * 模板输出的项目目录
     */
    private String projectPath = "E:\\Practise\\SpringBoot\\hans";
    /**
     * 业务名称
     */
    private String bizChName;
    /**
     * 业务英文名称
     */
    private String bizEnName;
    /**
     * 业务英文名称(大写)
     */
    private String bizEnBigName;

    /**
     * 是否生成控制器代码开关
     */
    private Boolean controllerSwitch = true;
    /**
     *  主页
     */
    private Boolean indexPageSwitch = true;
    /**
     *   添加页面
     */
    private Boolean addPageSwitch = true;
    /**
     *  编辑页面
     */
    private Boolean editPageSwitch = true;
    /**
     * js
     */
    private Boolean jsSwitch = true;
    /**
     * 详情页面js
     */
    private Boolean infoJsSwitch = true;
    /**
     * dao
     */
    private Boolean daoSwitch = true;
    /**
     * service
     */
    private Boolean serviceSwitch = true;

    /**
     * entity
     */
    private Boolean entitySwitch = true;
    /**
     * 模块名
     */
    private String moduleName = "";
    public void setBizEnName(String bizEnName) {
        this.bizEnName = bizEnName;
        this.bizEnBigName = ToolUtil.firstLetterToUpper(this.bizEnName);
    }
}
