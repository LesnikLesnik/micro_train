package com.example.micro_train.controller;

import com.example.micro_train.dto.AccountRequestDTO;
import com.example.micro_train.dto.AccountResponseDTO;
import com.example.micro_train.entity.Account;
import com.example.micro_train.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Retention;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/createAccount")
    public UUID createAccount(@RequestBody AccountRequestDTO accountRequestDTO){
        return accountService.createAccount(accountRequestDTO);
    }

    @GetMapping("{id}")
    public AccountResponseDTO getAccount(@PathVariable UUID id){
        return accountService.getAccountById(id);
    }

    @GetMapping("/listAccounts")
    public List<AccountResponseDTO> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAccount(@PathVariable UUID id){
        accountService.deleteAccount(id);
    }

}
