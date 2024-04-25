package com.example.micro_train.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AccountResponseDTO {

    private UUID accountId;

    private String name;

    private String email;

    private Integer bill;
}
