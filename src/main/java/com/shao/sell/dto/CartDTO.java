package com.shao.sell.dto;

import lombok.Data;

/**购物车
 * Created by zhibin.shao on 2018/1/4.
 */
@Data
public class CartDTO {
    private  String productId;
    private Integer productQuantity;


    public CartDTO( String productId,Integer productQuantity){
        this.productId=productId;
        this.productQuantity=productQuantity;
    }

}
