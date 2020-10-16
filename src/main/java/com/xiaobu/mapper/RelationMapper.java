package com.xiaobu.mapper;

import com.xiaobu.common.mapper.MyMapper;
import com.xiaobu.entity.Relation;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
  * 角色和菜单关联表 Mapper 接口
 * </p>
 */
@Mapper
public interface RelationMapper extends MyMapper<Relation> {

}