package com.rmp.mongostockquoteservice.repositories;

import com.rmp.mongostockquoteservice.domain.QuoteHistory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface QuoteHistoryRepository extends ReactiveMongoRepository<QuoteHistory, String> {
}
