package com.xiaobu.mapper;

import com.xiaobu.common.mapper.MyMapper;
import com.xiaobu.entity.LoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
  * 登录记录 Mapper 接口
 * </p>
 */
@Mapper
public interface LoginLogMapper extends MyMapper<LoginLog> {

    /**
     * 获取操作日志
     */
    List<Map<String, Object>> getOperationLogs(@Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("logName") String logName, @Param("logType") String logType, @Param("orderByField") String orderByField, @Param("isAsc") boolean isAsc);

    /**
     * 获取登录日志
     */
    List<Map<String, Object>> getLoginLogs(@Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("logName") String logName, @Param("orderByField") String orderByField, @Param("isAsc") boolean isAsc);

}