package com.xiaobu.mapper;

import com.xiaobu.common.mapper.MyMapper;
import com.xiaobu.entity.Dict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
  * 字典表 Mapper 接口
 * </p>
 */
@Mapper
public interface DictMapper extends MyMapper<Dict> {

    /**
     * 根据编码获取词典列表
     *
     * @param code
     * @return
     * @date 2017年2月13日 下午11:11:28
     */
    List<Dict> selectByCode(@Param("code") String code);

    /**
     * 查询字典列表
     *
     * @author xiaobu
     * @Date 2017/4/26 13:04
     */
    List<Map<String, Object>> list(@Param("condition") String conditiion);
}