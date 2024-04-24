package com.example.micro_train.service;

import com.example.micro_train.dto.AccountRequestDTO;
import com.example.micro_train.dto.AccountResponseDTO;
import com.example.micro_train.entity.Account;
import com.example.micro_train.exceptions.AccountNotFoundException;
import com.example.micro_train.mapper.AccountMapper;
import com.example.micro_train.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    public UUID createAccount(AccountRequestDTO accountRequestDTO){
        Account account = accountMapper.toAccount(accountRequestDTO);
        return accountRepository.save(account).getId();
    }

    public AccountResponseDTO getAccountById(UUID id){
        Optional<Account> accountById = accountRepository.findById(id);
        return accountById.map(accountMapper::toResponseDTO)
                .orElseThrow(() -> new AccountNotFoundException("Аккаунт с id: " + id + " не найден"));
    }

    public List<AccountResponseDTO> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .map(accountMapper::toResponseDTO)
                .toList();
    }

    public void deleteAccount(UUID id) {
        accountRepository.deleteById(id);
    }
}
