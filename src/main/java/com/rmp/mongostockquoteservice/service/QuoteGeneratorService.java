package com.rmp.mongostockquoteservice.service;

import com.rmp.mongostockquoteservice.model.Quote;
import reactor.core.publisher.Flux;

import java.time.Duration;

public interface QuoteGeneratorService {
    Flux<Quote> fetchQuoteStream(Duration period);
}
