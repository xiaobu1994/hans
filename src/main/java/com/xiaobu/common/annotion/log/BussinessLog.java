package com.xiaobu.common.annotion.log;

import java.lang.annotation.*;

/**
 * 标记需要做业务日志的方法
 *
 * @author xiaobu
 * @date 2017-03-31 12:46
 * @Target 注解是标注这个类它可以标注的位置,常用的元素类型(ElementType):
 * @Retention 注解表示的是本注解(标注这个注解的注解保留时期)
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface BussinessLog {

    /**
     * 业务的名称,例如:"修改菜单"
     */
    String value() default "";

    /**
     * 被修改的实体的唯一标识,例如:菜单实体的唯一标识为"id"
     */
    String key() default "id";

    /**
     * 字典(用于查找key的中文名称和字段的中文名称)
     */
    String dict() default "SystemDict";
}
