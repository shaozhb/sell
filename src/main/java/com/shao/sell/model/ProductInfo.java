package com.shao.sell.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shao.sell.enums.ProductStatusEnum;
import com.shao.sell.utils.EnumUtils;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by zhibin.shao on 2018/1/4.
 */
@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    private Integer productStatus= ProductStatusEnum.UP.getCode();
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;

    @JsonIgnore
    public  ProductStatusEnum getProductStatusEnum(){
        return EnumUtils.getByCode(productStatus,ProductStatusEnum.class);
    }
}
