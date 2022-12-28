package com.example.orderservice.model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BooleanDto {
    private Boolean isInStuck;
}
