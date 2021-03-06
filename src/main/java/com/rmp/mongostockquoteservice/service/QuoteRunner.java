package com.rmp.mongostockquoteservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Slf4j
@Component
@RequiredArgsConstructor
public class QuoteRunner implements CommandLineRunner {

    private final QuoteGeneratorService quoteGeneratorService;
    private final QuoteHistoryService quoteHistoryService;


    @Override
    public void run(String... args) throws Exception {
        quoteGeneratorService.fetchQuoteStream(Duration.ofMillis(100l))
                             .take(20)
                             .log("Got Quote:")
                             .flatMap(quoteHistoryService::saveQuoteToMongo)
                             .subscribe(savedQuote -> {
                                 log.debug("Saved Quote: " + savedQuote);
                             }, throwable -> {
                                 //handle error
                                 log.error("Error: ",throwable);
                             }, () -> {
                                 log.debug("All done!!!");
                             });
    }
}
