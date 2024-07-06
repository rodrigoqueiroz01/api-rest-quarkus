package com.dev.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized
public class CustomerDTO {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private Long age;

}
