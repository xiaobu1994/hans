package com.xiaobu.core.util;

import java.util.ArrayList;
import java.util.List;

/**
 * sql语句工具类
 */
public class SqlUtil {

    /**
     * @Description 根据集合的大小，输出相应个数"?"
     * @author xiaobu
     */
    public static String parse(List<?> list) {
        StringBuilder str = new StringBuilder();
        if (list != null && list.size() > 0) {
            str.append("?");
            for (int i = 1; i < list.size(); i++) {
                str.append(",?");
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(2);
        System.out.println(parse(arrayList));
    }
}
