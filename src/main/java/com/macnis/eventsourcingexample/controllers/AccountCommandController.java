package com.macnis.eventsourcingexample.controllers;

import com.macnis.eventsourcingexample.dto.commands.AccountCreateDto;
import com.macnis.eventsourcingexample.dto.commands.MoneyCreditDto;
import com.macnis.eventsourcingexample.dto.commands.MoneyDebitDto;
import com.macnis.eventsourcingexample.services.commands.AccountCommandService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/bank-accounts")
@Api(value = "Account Commands", description = "Account Commands Related Endpoints", tags = "Account Commands")
public class AccountCommandController {

    private final AccountCommandService accountCommandService;

    public AccountCommandController(AccountCommandService accountCommandService) {
        this.accountCommandService = accountCommandService;
    }

    @PostMapping
    public CompletableFuture<String> createAccount(@RequestBody AccountCreateDto accountCreateDto){
        return accountCommandService.createAccount(accountCreateDto);
    }

    @PutMapping(value = "/credits/{accountNumber}")
    public CompletableFuture<String> creditMoneyToAccount(@PathVariable(value = "accountNumber") String accountNumber,
                                                          @RequestBody MoneyCreditDto moneyCreditDto){
        return accountCommandService.creditMoneyToAccount(accountNumber, moneyCreditDto);
    }

    @PutMapping(value = "/debits/{accountNumber}")
    public CompletableFuture<String> debitMoneyFromAccount(@PathVariable(value = "accountNumber") String accountNumber,
                                                           @RequestBody MoneyDebitDto moneyDebitDto){
        return accountCommandService.debitMoneyFromAccount(accountNumber, moneyDebitDto);
    }
}
