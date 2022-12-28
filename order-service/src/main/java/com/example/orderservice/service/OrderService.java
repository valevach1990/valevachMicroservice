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
    private final WebClient webClient;


    public void createOrder(RequestOrderDto requestOrderDto) {
        Orders orders = mapToOrder(requestOrderDto);
      /*  Boolean result = webClient.get()
                .uri("http://localhost:8081/api/inventory")
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
        if (result) {

        } else {
            throw new IllegalArgumentException("Please try again");
        }*/
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

}
