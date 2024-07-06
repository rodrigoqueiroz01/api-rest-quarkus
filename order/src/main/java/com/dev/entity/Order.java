package com.dev.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_data", schema = "public")
public class Order {

    @Id
    @GeneratedValue
    private Long orderId;

    private Long customerId;

    private String customerName;

    private Long productId;

    private BigDecimal orderValue;

}
