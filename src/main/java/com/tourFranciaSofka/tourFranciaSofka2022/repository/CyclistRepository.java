package com.tourFranciaSofka.tourFranciaSofka2022.repository;

import com.tourFranciaSofka.tourFranciaSofka2022.collections.Cyclist;
import com.tourFranciaSofka.tourFranciaSofka2022.dtos.CyclistDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CyclistRepository extends ReactiveMongoRepository<Cyclist, String> {
    Flux<Cyclist> findCyclistsByTeamCode(String teamCode);
}
