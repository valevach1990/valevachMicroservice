package com.example.orderservice.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer quantity;
    @OneToOne(cascade = CascadeType.ALL)
    private OrderInfo orderInfo;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
