package com.example.orderservice.service;

import com.example.orderservice.model.Orders;
import com.example.orderservice.model.dto.RequestOrderDto;
import com.example.orderservice.repository.OrderRepository;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    public void createOrder(RequestOrderDto requestOrderDto) {
        Orders orders = mapToOrder(requestOrderDto);
        orderRepository.save(orders);

    }

    private Orders mapToOrder(@NotNull RequestOrderDto requestOrderDto) {
        return Orders.builder()
                .quantity(requestOrderDto.getQuantity())
                .build();
    }

    public Orders findOrders(Long orderId) {
        return orderRepository.findById(orderId).get();
    }

    public void reserveOrder(Orders orders) {
        Boolean result = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory/a")
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
        if (result) {
            orders.setQuantity(orders.getQuantity() - 1);
            orderRepository.save(orders);
        } else {
            throw new IllegalArgumentException("Please try again");
        }
    }
}
