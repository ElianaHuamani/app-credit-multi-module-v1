package com.mybank.credit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericMongoSpringDataRespository<T, ID> extends MongoRepository<T, ID> {
}
