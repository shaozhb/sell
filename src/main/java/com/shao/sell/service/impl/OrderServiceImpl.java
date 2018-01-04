package com.shao.sell.service.impl;

import com.shao.sell.dto.CartDTO;
import com.shao.sell.dto.OrderDTO;
import com.shao.sell.enums.OrderStatusEnum;
import com.shao.sell.enums.PayStatusEnum;
import com.shao.sell.enums.ResultEnum;
import com.shao.sell.exception.SellException;
import com.shao.sell.model.OrderDetail;
import com.shao.sell.model.OrderMaster;
import com.shao.sell.model.ProductInfo;
import com.shao.sell.repository.OrderDetailRepository;
import com.shao.sell.repository.OrderMasterRepository;
import com.shao.sell.service.OrderService;
import com.shao.sell.service.ProductService;
import com.shao.sell.service.WebSocket;
import com.shao.sell.utils.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhibin.shao on 2018/1/4.
 */
public class OrderServiceImpl implements OrderService {

    @Autowired
    ProductService productService;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    OrderMasterRepository orderMasterRepository;
    @Autowired
    WebSocket webSocket;
    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId= KeyUtils.genUniqueKey();
        BigDecimal orderAmount=new BigDecimal(BigInteger.ZERO);

        //查询商品
        for(OrderDetail orderDetail:orderDTO.getOrderDetailList()){
            ProductInfo productInfo=productService.findOne(orderDetail.getProductId());
            if(productInfo==null){
                throw  new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            //计算订单总价
            orderAmount=productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmount);

            //详情入库
            orderDetail.setDetailId(KeyUtils.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetailRepository.save(orderDetail);

        }
        //写入订单表
        OrderMaster orderMaster=new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMasterRepository.save(orderMaster);


        List<CartDTO> cartDTOList= new ArrayList<>();
        for(OrderDetail orderDetail:orderDTO.getOrderDetailList()){
            cartDTOList.add(new CartDTO(orderDetail.getProductId(),orderDetail.getProductQuantity()));
        }
        productService.decreaseStock(cartDTOList);
        webSocket.sendMessage(orderDTO.getOrderId());
        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(Pageable pageable) {
        return null;
    }
}
