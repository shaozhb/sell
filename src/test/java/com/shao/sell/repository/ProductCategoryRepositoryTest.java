package com.shao.sell.repository;

import com.shao.sell.model.ProductCategory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zhibin.shao on 2018/1/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    ProductCategoryRepository repository;
    @Test
    public void testFindByCategoryTypeIn() throws Exception {
        List<Integer> list= Arrays.asList(1,2,3);
        List<ProductCategory> productCategoryList=repository.findByCategoryTypeIn(list);
       Assert.assertNotEquals(0,productCategoryList.size());
    }
}