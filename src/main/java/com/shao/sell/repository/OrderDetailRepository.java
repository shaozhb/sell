package com.shao.sell.repository;

import com.shao.sell.model.OrderDetail;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhibin.shao on 2018/1/4.
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String>{
    List<OrderDetail> findByOrderId(java.lang.String orderId);
}
