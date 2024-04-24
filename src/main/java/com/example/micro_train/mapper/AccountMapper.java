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

    public abstract AccountResponseDTO toResponseDTO(Account account);


    public abstract Account toAccount(AccountRequestDTO accountRequestDTO);

//    @BeforeMapping
//    UUID generationAccountId(Account account){
//        account.setId(UUID.randomUUID());
//        return account.getId();
//    }
}
