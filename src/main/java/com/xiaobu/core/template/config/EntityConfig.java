package com.xiaobu.core.template.config;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaobu
 * @version JDK1.8.0_171
 * @date on  2019/1/17 10:09
 * @description V1.0
 */
@Data
public class EntityConfig {

    private ContextConfig contextConfig;

    /**
     * entit文件路径
     */
    private String entityPathTemplate;
    /**
     * 包的路径
     */
    private String packageName;

    /**
     * 导入的包
     */
    private List<String> entityImports;

    public void init() {
        ArrayList<String> imports = new ArrayList<>();
        imports.add("javax.persistence.*");
        imports.add("lombok.Data");
        this.entityImports = imports;
        this.entityPathTemplate = "\\src\\main\\java\\com\\xiaobu\\" + contextConfig.getModuleName()+ "entity\\{}.java";
        this.packageName = "com.xiaobu." + contextConfig.getModuleName()+ "entity";
    }
}
