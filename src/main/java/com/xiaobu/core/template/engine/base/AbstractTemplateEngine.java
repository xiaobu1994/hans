package com.xiaobu.core.template.engine.base;


import com.xiaobu.core.template.config.*;
import lombok.Data;

/**
 * 模板生成父类
 */
@Data
public class AbstractTemplateEngine {

    protected ContextConfig contextConfig;
    /**
     * 控制器的配置
     */
    protected ControllerConfig controllerConfig;
    /**
     * 页面的控制器
     */
    protected PageConfig pageConfig;
    /**
     * Dao配置
     */
    protected MapperConfig daoConfig;
    /**
     * Service配置
     */
    protected ServiceConfig serviceConfig;


    /**
     * entity配置
     */
    protected EntityConfig entityConfig;

    public void initConfig() {
        if (this.contextConfig == null) {
            this.contextConfig = new ContextConfig();
        }
        if (this.controllerConfig == null) {
            this.controllerConfig = new ControllerConfig();
        }
        if (this.pageConfig == null) {
            this.pageConfig = new PageConfig();
        }
        if (this.daoConfig == null) {
            this.daoConfig = new MapperConfig();
        }
        if (this.serviceConfig == null) {
            this.serviceConfig = new ServiceConfig();
        }
        if (this.entityConfig == null) {
            this.entityConfig = new EntityConfig();
        }

        this.controllerConfig.setContextConfig(this.contextConfig);
        this.controllerConfig.init();

        this.serviceConfig.setContextConfig(this.contextConfig);
        this.serviceConfig.init();

        this.daoConfig.setContextConfig(this.contextConfig);
        this.daoConfig.init();

        this.pageConfig.setContextConfig(this.contextConfig);
        this.pageConfig.init();

        this.entityConfig.setContextConfig(this.contextConfig);
        this.entityConfig.init();
    }

}

