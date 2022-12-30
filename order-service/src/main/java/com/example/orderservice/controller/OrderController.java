package com.example.orderservice.controller;

import com.example.orderservice.model.Orders;
import com.example.orderservice.model.dto.RequestOrderDto;
import com.example.orderservice.service.ClientService;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody RequestOrderDto requestOrderDto) {
        orderService.createOrder(requestOrderDto);
    }

    @GetMapping("{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public Orders showOrder(@PathVariable Long orderId) {
       return orderService.findOrders(orderId);
    }

}
