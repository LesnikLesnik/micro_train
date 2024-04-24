package com.example.micro_train.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequestDTO {

    private String name;

    private String email;

    private Integer bill;
}
