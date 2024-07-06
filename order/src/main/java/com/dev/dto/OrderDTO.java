package com.dev.dto;

import lombok.*;
import lombok.extern.jackson.Jacksonized;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized
public class OrderDTO {

    private Long customerId;

    private String customerName;

    private Long productId;

    private BigDecimal orderValue;

}
