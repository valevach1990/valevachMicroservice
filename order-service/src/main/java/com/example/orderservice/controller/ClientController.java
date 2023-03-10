package com.example.orderservice.controller;

import com.example.orderservice.model.dto.RequestClientDto;
import com.example.orderservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createClient(@RequestBody RequestClientDto requestClientDto ){
        clientService.createClient(requestClientDto);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void reserveOrder(@RequestParam Long orderId,@RequestParam Long clientId ){
        clientService.reserveOrder(orderId,clientId);
    }

}
