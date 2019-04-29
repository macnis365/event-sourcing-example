Event Sourcing


@Aggregate annotation tells Axon that this entity will be managed by Axon. Basically, this is similar to @Entity annotation available with JPA. However, we will be using the Axon recommended annotation.

@AggregateIdentifier annotation is used for the identifying a particular instance of the Aggregate. In other words, this is similar to JPA’s @Id annotation.

@TargetAggregateIdentifier annotation. Basically, this is an Axon specific requirement to identify the aggregate instance. In other words, this annotation is required for Axon to determine the instance of the Aggregate that should handle the command

Modeling the Commands and Events

Axon works on the concept of commands and events.
To elaborate, Commands are user-initiated actions that can change the state of your aggregate.
However, Events are the actual changing of that state.

 @CommandHandler annotation. We have three handler methods because there are three commands we want to handle.

The handler methods use AggregateLifecyle.apply() method to register events.

These events, in turn, are handled by methods annotated with @EventSourcingHandler annotation. Also, it is imperative that all state changes in an event sourced aggregate should be performed in these methods.

Another important point to keep in mind is that the Aggregate Identifier must be set in the first method annotated with @EventSourcingHandler. In other words, this will be the creation Event.