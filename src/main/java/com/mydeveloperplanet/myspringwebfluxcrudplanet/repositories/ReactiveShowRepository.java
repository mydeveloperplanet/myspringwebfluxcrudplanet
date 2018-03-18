package com.mydeveloperplanet.myspringwebfluxcrudplanet.repositories;

import com.mydeveloperplanet.myspringwebfluxcrudplanet.domain.Show;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveShowRepository extends ReactiveMongoRepository<Show, String> {

}
