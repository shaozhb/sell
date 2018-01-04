package com.shao.sell.exception;

import com.shao.sell.enums.ResultEnum;

/**
 * Created by zhibin.shao on 2018/1/4.
 */
public class SellException extends RuntimeException {


    private Integer code;



    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

    public SellException(Integer code,String message){
        super(message);
        this.code=code;
    }
}
