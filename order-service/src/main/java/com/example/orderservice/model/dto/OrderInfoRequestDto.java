package com.example.orderservice.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderInfoRequestDto {
    private String info;
    private Long orderId;
}
