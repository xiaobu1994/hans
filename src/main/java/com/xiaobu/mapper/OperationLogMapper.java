package com.xiaobu.mapper;

import com.xiaobu.common.mapper.MyMapper;
import com.xiaobu.entity.OperationLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
  * 操作日志 Mapper 接口
 * </p>
 */
@Mapper
public interface OperationLogMapper extends MyMapper<OperationLog> {

}