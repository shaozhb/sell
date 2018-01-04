package com.shao.sell.controller;

import com.shao.sell.VO.ProductInfoVO;
import com.shao.sell.VO.ProductVO;
import com.shao.sell.VO.ResultVO;
import com.shao.sell.model.ProductCategory;
import com.shao.sell.model.ProductInfo;
import com.shao.sell.service.CategoryService;
import com.shao.sell.service.ProductService;
import com.shao.sell.utils.ResultVOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhibin.shao on 2018/1/4.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerOrderController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @GetMapping("/list")
    public ResultVO list(){
        //详情list
        List<ProductInfo> productInfoList=productService.findUpAll();
        //类目list
        List<Integer> categoryList=new ArrayList<>();

        for(ProductInfo productInfo:productInfoList){
            categoryList.add(productInfo.getCategoryType());
        }
        List<ProductCategory> productCategoryList=categoryService.findByCategoryTypeIn(categoryList);

        List<ProductVO> productVOList=new ArrayList<>();
        for(ProductCategory productCategory:productCategoryList){
            ProductVO productVO=new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList=new ArrayList<>();
            for(ProductInfo productInfo:productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtils.success(productVOList);
    }




}
