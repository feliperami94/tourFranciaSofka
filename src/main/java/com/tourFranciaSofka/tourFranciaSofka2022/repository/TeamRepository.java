package com.tourFranciaSofka.tourFranciaSofka2022.repository;

import com.tourFranciaSofka.tourFranciaSofka2022.collections.Team;
import com.tourFranciaSofka.tourFranciaSofka2022.dtos.TeamDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TeamRepository extends ReactiveMongoRepository<Team, String> {

    Flux<Team> getTeamsByCountry(String country);
}
