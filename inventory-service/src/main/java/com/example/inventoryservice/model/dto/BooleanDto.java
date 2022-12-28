package com.example.inventoryservice.model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BooleanDto {
    private Boolean isInStuck;
}
