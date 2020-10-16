package com.xiaobu.core.datascope;

import lombok.Data;

import java.util.List;

/**
 * 数据范围
 */
@Data
public class DataScope {

    /**
     * 限制范围的字段名称
     */
    private String scopeName = "deptid";

    /**
     * 限制范围的
     */
    private List<Integer> deptIds;

    public DataScope(List<Integer> deptIds) {
        this.deptIds = deptIds;
    }

    public DataScope(String scopeName, List<Integer> deptIds) {
        this.scopeName = scopeName;
        this.deptIds = deptIds;
    }

}
