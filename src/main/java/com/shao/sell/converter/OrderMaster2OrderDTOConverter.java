package com.shao.sell.converter;

import com.shao.sell.dto.OrderDTO;
import com.shao.sell.model.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhibin.shao on 2018/1/5.
 */
public class OrderMaster2OrderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO=new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        List<OrderDTO> orderDTOList=new ArrayList<>();
        for(OrderMaster orderMaster:orderMasterList){
            orderDTOList.add(convert(orderMaster));
        }
        return orderDTOList;
    }

}
