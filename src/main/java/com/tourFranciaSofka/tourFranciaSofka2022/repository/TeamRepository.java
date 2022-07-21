package com.tourFranciaSofka.tourFranciaSofka2022.repository;

import com.tourFranciaSofka.tourFranciaSofka2022.collections.Team;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends ReactiveMongoRepository<Team, String> {

}
