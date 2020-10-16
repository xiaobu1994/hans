package com.xiaobu.core.template.config;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Dao模板生成的配置
 */
@Data
public class MapperConfig {

    private ContextConfig contextConfig;
    /**
     * mapper路径
     */
    private String mapperPathTemplate;
    /**
     * xml路径
     */
    private String xmlPathTemplate;
    /**
     * 包的路径
     */
    private String packageName;

    /**
     * 导入的包
     */
    private List<String> mapperImplImports;

    public void init() {
        ArrayList<String> imports = new ArrayList<>();
        imports.add("com.xiaobu.common.mapper.MyMapper");
        imports.add("com.xiaobu.entity."+contextConfig.getBizEnBigName());
        imports.add("org.apache.ibatis.annotations.Mapper");
        imports.add("org.apache.ibatis.annotations.Param");
        this.mapperImplImports = imports;
        this.mapperPathTemplate = "\\src\\main\\java\\com\\xiaobu\\" + contextConfig.getModuleName()+ "mapper\\{}Mapper.java";
        this.xmlPathTemplate = "\\src\\main\\java\\com\\xiaobu\\" + contextConfig.getModuleName()+"mapper\\xml\\{}Mapper.xml";
        this.packageName = "com.xiaobu." + contextConfig.getModuleName()+ "mapper";
    }
}
