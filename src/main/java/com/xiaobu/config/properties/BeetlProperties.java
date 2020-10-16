package com.xiaobu.config.properties;

import com.xiaobu.core.util.ToolUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * beetl配置(如果需要配置别的配置可参照这个形式自己添加)
 */
@Data
@Configuration
@ConfigurationProperties(prefix = BeetlProperties.BEETLCONF_PREFIX)
public class BeetlProperties {

    public static final String BEETLCONF_PREFIX = "beetl";

    private String delimiterStatementStart;

    private String delimiterStatementEnd;

    private String resourceTagroot;

    private String resourceTagsuffix;

    private String resourceAutoCheck;

    @Value("${spring.mvc.view.prefix}")
    private String prefix;

    public Properties getProperties(){
        Properties properties = new Properties();
        if(ToolUtil.isNotEmpty(delimiterStatementStart)){
            if(delimiterStatementStart.startsWith("\\")){
                delimiterStatementStart = delimiterStatementStart.substring(1);
            }
            properties.setProperty("DELIMITER_STATEMENT_START",delimiterStatementStart);
        }
        if(ToolUtil.isNotEmpty(delimiterStatementEnd)){
            properties.setProperty("DELIMITER_STATEMENT_END",delimiterStatementEnd);
        }else{
            properties.setProperty("DELIMITER_STATEMENT_END","null");
        }
        if(ToolUtil.isNotEmpty(resourceTagroot)){
            properties.setProperty("RESOURCE.tagRoot",resourceTagroot);
        }
        if(ToolUtil.isNotEmpty(resourceTagsuffix)){
            properties.setProperty("RESOURCE.tagSuffix",resourceTagsuffix);
        }
        if(ToolUtil.isNotEmpty(resourceAutoCheck)){
            properties.setProperty("RESOURCE.autoCheck",resourceAutoCheck);
        }
        return properties;
    }

    public String getPrefix() {
        return prefix;
    }

}
