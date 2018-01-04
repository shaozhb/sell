package com.shao.sell.enums;


import lombok.Getter;

/**
 * Created by zhibin.shao on 2018/1/4.
 */
@Getter
public enum OrderStatusEnum {

    NEW(0,"新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消"),
        ;
    private Integer code;
    private String message;
     OrderStatusEnum(){}
     OrderStatusEnum(Integer code,String message){
        this.code=code;
        this.message=message;
    }

}
