package com.shao.sell.VO;

import lombok.Data;

/**
 * Created by zhibin.shao on 2018/1/4.
 */
@Data
public class ResultVO<T> {

    private Integer code;
    private String msg;
    private T data;
}
