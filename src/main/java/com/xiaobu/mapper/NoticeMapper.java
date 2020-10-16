package com.xiaobu.mapper;

import com.xiaobu.common.mapper.MyMapper;
import com.xiaobu.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
  * 通知表 Mapper 接口
 * </p>
 *
 * @author xiaobu
 * @since 2017-07-11
 */
@Mapper
public interface NoticeMapper extends MyMapper<Notice> {

    List<Map<String, Object>> list(@Param("condition") String condition);

}