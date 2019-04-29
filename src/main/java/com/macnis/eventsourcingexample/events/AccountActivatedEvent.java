package com.macnis.eventsourcingexample.events;

import com.macnis.eventsourcingexample.aggregates.Status;

public class AccountActivatedEvent extends BaseEvent<String>{
    public final Status status;

    public AccountActivatedEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}
