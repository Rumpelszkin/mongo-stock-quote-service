package com.rmp.mongostockquoteservice.service;

import com.rmp.mongostockquoteservice.domain.QuoteHistory;
import com.rmp.mongostockquoteservice.model.Quote;
import com.rmp.mongostockquoteservice.repositories.QuoteHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class QuoteHistoryServiceImpl implements QuoteHistoryService {

    private final QuoteHistoryRepository repository;

    @Override
    public Mono<QuoteHistory> saveQuoteToMongo(Quote quote) {
        return repository.save(QuoteHistory.builder()
                                           .ticker(quote.getTicker())
                                           .price(quote.getPrice())
                                           .instant(quote.getInstant())
                                           .build());
    }
}
