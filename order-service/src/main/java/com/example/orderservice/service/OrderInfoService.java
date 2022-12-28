package com.example.orderservice.service;

import com.example.orderservice.model.OrderInfo;
import com.example.orderservice.model.Orders;
import com.example.orderservice.model.dto.OrderInfoRequestDto;
import com.example.orderservice.repository.OrderInfoRepository;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderInfoService {

    private final OrderInfoRepository orderInfoRepository;
    private final OrderService orderService;


    public void createOrderInfo(OrderInfoRequestDto orderInfoRequestDto) {
        OrderInfo orderInfo = mapToOrderInfo(orderInfoRequestDto);
        Orders orders = orderService.findOrders(orderInfoRequestDto.getOrderId());
        orders.setOrderInfo(orderInfo);
        orderInfo.setOrders(orders);
        orderInfoRepository.save(orderInfo);
    }

    private OrderInfo mapToOrderInfo(@NotNull OrderInfoRequestDto orderInfoRequestDto) {
        return OrderInfo.builder()
                .info(orderInfoRequestDto.getInfo())
                .build();
    }
}
