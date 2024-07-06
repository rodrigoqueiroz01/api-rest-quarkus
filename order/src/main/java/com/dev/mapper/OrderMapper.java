package com.dev.mapper;

import com.dev.dto.OrderDTO;
import com.dev.entity.Order;

public class OrderMapper {

    public static OrderDTO fromOrderToOrderDTO(Order order) {
        return OrderDTO.builder()
                .customerId(order.getCustomerId())
                .customerName(order.getCustomerName())
                .productId(order.getProductId())
                .orderValue(order.getOrderValue())
                .build();
    }

    public static Order fromOrderDTOToOrder(OrderDTO dto) {
        return Order.builder()
                .customerId(dto.getCustomerId())
                .customerName(dto.getCustomerName())
                .productId(dto.getProductId())
                .orderValue(dto.getOrderValue())
                .build();
    }

}
