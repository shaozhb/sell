package com.shao.sell.utils;

import com.shao.sell.enums.CodeEnum;

/**
 * Created by zhibin.shao on 2018/1/4.
 */
public class EnumUtils {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }

}
