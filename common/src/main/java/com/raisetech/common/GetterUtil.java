package com.raisetech.common;

import java.util.Objects;

/**
 * 获取工具类
 *
 * @author 王有政
 */
public class GetterUtil {

    /**
     * 判断对象是否为null
     *
     * @param obj
     * @return
     */
    public static boolean isNull(Object obj) {
        return Objects.isNull(obj);
    }
}
