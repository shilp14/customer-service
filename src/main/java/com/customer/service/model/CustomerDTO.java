package com.customer.service.model;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
}
