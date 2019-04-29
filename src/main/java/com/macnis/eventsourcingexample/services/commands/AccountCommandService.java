package com.macnis.eventsourcingexample.services.commands;

import com.macnis.eventsourcingexample.dto.commands.AccountCreateDto;
import com.macnis.eventsourcingexample.dto.commands.MoneyCreditDto;
import com.macnis.eventsourcingexample.dto.commands.MoneyDebitDto;

import java.util.concurrent.CompletableFuture;

public interface AccountCommandService {
    public CompletableFuture<String> createAccount(AccountCreateDto accountCreateDto);

    public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDto moneyCreditDto);

    public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDto moneyDebitDto);

}
