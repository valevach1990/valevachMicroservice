package com.example.orderservice.service;

import com.example.orderservice.model.Client;
import com.example.orderservice.model.Orders;
import com.example.orderservice.model.dto.RequestClientDto;
import com.example.orderservice.repository.ClientRepository;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final OrderService orderService;


    public Client createClient(RequestClientDto requestClientDto) {
        return clientRepository.save(mapToClient(requestClientDto));
    }

    private Client mapToClient(@NotNull RequestClientDto requestClientDto) {
        return Client.builder()
                .name(requestClientDto.getName())
                .build();
    }

    public void reserveOrder(Long orderId,Long clientId) {
        Orders orders = orderService.findOrders(orderId);
        Client client = clientRepository.findById(clientId).get();
        orders.setClient(client);
        client.setOrdersList(List.of(orders));
        orderService.reserveOrder(orders);
    }
}
