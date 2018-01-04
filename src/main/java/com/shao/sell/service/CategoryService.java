package com.shao.sell.service;

import com.shao.sell.model.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhibin.shao on 2018/1/4.
 */

public interface CategoryService {

    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    ProductCategory save(ProductCategory productCategory);


}
