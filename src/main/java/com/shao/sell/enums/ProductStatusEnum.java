package com.shao.sell.enums;


import lombok.Getter;


/**
 * Created by zhibin.shao on 2018/1/4.
 */
@Getter
public enum  ProductStatusEnum implements CodeEnum {

    UP(0, "在架"),
    DOWN(1, "下架")
    ;


    public Integer getCode() {
        return code;
    }

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }



}
