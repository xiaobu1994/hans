package com.xiaobu.warpper;


import com.xiaobu.common.constant.factory.ConstantFactory;
import com.xiaobu.common.warpper.BaseControllerWarpper;
import com.xiaobu.core.util.ToolUtil;
import com.xiaobu.entity.Dict;

import java.util.List;
import java.util.Map;

/**
 * 字典列表的包装
 *
 * @author xiaobu
 * @date 2017年4月25日 18:10:31
 */
public class DictWarpper extends BaseControllerWarpper {

    public DictWarpper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        StringBuilder detail = new StringBuilder();
        Integer id = (Integer) map.get("id");
        List<Dict> dicts = ConstantFactory.me().findInDict(id);
        if(dicts != null){
            for (Dict dict : dicts) {
                detail.append(dict.getNum()).append(":").append(dict.getName()).append(",");
            }
            map.put("detail", ToolUtil.removeSuffix(detail.toString(),","));
        }
    }

}
