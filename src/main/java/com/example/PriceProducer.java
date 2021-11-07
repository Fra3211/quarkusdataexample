package com.example;

import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.time.Duration;
import java.util.Random;

/**
 * TEST CLASS TO GENERATE PRODUCER DUMMY DATA
 */
@ApplicationScoped
public class PriceProducer {

    private Random random = new Random();

    @Outgoing("prices")
    public Multi<Long> producePrice(){
        return Multi.createFrom().ticks().every(Duration.ofSeconds(5))
                .map(it -> (long) random.nextInt(4000));
    }
}
