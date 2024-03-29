package com.example;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.jboss.resteasy.annotations.SseElementType;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/prices")
public class PriceResource {

    @Inject
    @Channel("converted-prices")
    Publisher<Double> publisher;

    @GET
    @Path("/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @SseElementType(MediaType.APPLICATION_JSON) //TYPE OF THE CONTENT THAT I WANT TO SEND
    public Publisher<Double> getPrices(){
       return publisher;
    }
}
