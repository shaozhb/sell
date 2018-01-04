package com.shao.sell.service;

import com.shao.sell.dto.CartDTO;
import com.shao.sell.model.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by zhibin.shao on 2018/1/4.
 */
public interface ProductService {

    ProductInfo findOne(String productId);
    List<ProductInfo> findUpAll();
    Page<ProductInfo> findAll(Pageable pageable);
    ProductInfo save(ProductInfo productInfo);

    ProductInfo onSale(String productId);
    ProductInfo offSale(String productId);

    void increaseStock(List<CartDTO> cartDTOList);
    void decreaseStock(List<CartDTO> cartDTOList);


}
