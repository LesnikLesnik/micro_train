package com.example.micro_train.mapper;

import com.example.micro_train.dto.AccountRequestDTO;
import com.example.micro_train.dto.AccountResponseDTO;
import com.example.micro_train.entity.Account;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper
public interface AccountMapper {

    @Mapping(target = "accountId", source = "id")
    AccountResponseDTO toResponseDTO(Account account);


    @Mapping(target = "id", ignore = true)
    Account toAccount(AccountRequestDTO accountRequestDTO);

}
