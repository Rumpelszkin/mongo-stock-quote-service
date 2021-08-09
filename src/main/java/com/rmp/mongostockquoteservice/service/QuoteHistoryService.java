package com.rmp.mongostockquoteservice.service;

import com.rmp.mongostockquoteservice.domain.QuoteHistory;
import com.rmp.mongostockquoteservice.model.Quote;
import reactor.core.publisher.Mono;

public interface QuoteHistoryService {
    Mono<QuoteHistory> saveQuoteToMongo(Quote quote);
}
