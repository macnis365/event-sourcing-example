package com.macnis.eventsourcingexample.services.commands;

import com.macnis.eventsourcingexample.commands.CreateAccountCommand;
import com.macnis.eventsourcingexample.commands.CreditMoneyCommand;
import com.macnis.eventsourcingexample.commands.DebitMoneyCommand;
import com.macnis.eventsourcingexample.dto.commands.AccountCreateDto;
import com.macnis.eventsourcingexample.dto.commands.MoneyCreditDto;
import com.macnis.eventsourcingexample.dto.commands.MoneyDebitDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class AccountCommandServiceImpl implements AccountCommandService {
    private final CommandGateway commandGateway;

    public AccountCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<String> createAccount(AccountCreateDto accountCreateDto) {
        return commandGateway.send(new CreateAccountCommand(UUID.randomUUID().toString(), accountCreateDto.getStartingBalance(), accountCreateDto.getCurrency()));
    }

    @Override
    public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDto moneyCreditDto) {
        return commandGateway.send(new CreditMoneyCommand(UUID.randomUUID().toString(), moneyCreditDto.getCreditAmount(), moneyCreditDto.getCurrency()));
    }

    @Override
    public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDto moneyDebitDto) {
        return commandGateway.send(new DebitMoneyCommand(UUID.randomUUID().toString(), moneyDebitDto.getDebitAmount(), moneyDebitDto.getCurrency()));
    }
}
