package com.xiaobu.mapper;

import com.xiaobu.common.mapper.MyMapper;
import com.xiaobu.common.node.ZTreeNode;
import com.xiaobu.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author xiaobu
 * @since 2017-07-11
 */
@Mapper
public interface DeptMapper extends MyMapper<Dept> {
    /**
     * 获取ztree的节点列表
     *
     */
    List<ZTreeNode> tree();

    List<Map<String, Object>> list(@Param("condition") String condition);
}