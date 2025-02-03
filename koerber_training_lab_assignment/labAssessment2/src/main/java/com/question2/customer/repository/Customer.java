package com.question2.customer.repository;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private int id;
    private String name,address;
    private Long phoneNumber;
}
