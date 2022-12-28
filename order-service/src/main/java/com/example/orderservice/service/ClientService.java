package com.example.orderservice.service;

import com.example.orderservice.model.Client;
import com.example.orderservice.model.dto.RequestClientDto;
import com.example.orderservice.repository.ClientRepository;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;


    public Client createClient(RequestClientDto requestClientDto) {
        return clientRepository.save(mapToClient(requestClientDto));
    }

    private Client mapToClient(@NotNull RequestClientDto requestClientDto) {
        return Client.builder()
                .name(requestClientDto.getName())
                .build();
    }
}
