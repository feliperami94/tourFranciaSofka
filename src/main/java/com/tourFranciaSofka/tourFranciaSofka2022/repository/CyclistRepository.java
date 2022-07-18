package com.tourFranciaSofka.tourFranciaSofka2022.repository;

import com.tourFranciaSofka.tourFranciaSofka2022.collections.Cyclist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CyclistRepository extends ReactiveMongoRepository<Cyclist, String> {

}
