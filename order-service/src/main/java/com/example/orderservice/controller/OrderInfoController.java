package com.example.orderservice.controller;

import com.example.orderservice.model.dto.OrderInfoRequestDto;
import com.example.orderservice.service.OrderInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orderInfo")
public class OrderInfoController {

    private final OrderInfoService orderInfoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderInfoRequestDto orderInfoRequestDto ){
        orderInfoService.createOrderInfo(orderInfoRequestDto);
    }
}
