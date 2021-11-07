package com.example;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import io.smallrye.reactive.messaging.annotations.Merge;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

/**
 * The incoming data are from prices topic, then the outgoing topic
 * is converted-prices. I want to broadcast them so put
 * broadcast annotation
 */
@ApplicationScoped
public class PriceConverter {

    @Merge
    @Incoming("prices")
    @Outgoing("converted-prices")
    @Broadcast
    public double convert(long price){
        return price * 1.5d;
    }
}
