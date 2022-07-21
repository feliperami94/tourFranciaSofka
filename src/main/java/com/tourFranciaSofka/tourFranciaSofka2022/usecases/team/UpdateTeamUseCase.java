package com.tourFranciaSofka.tourFranciaSofka2022.usecases.team;

import com.tourFranciaSofka.tourFranciaSofka2022.collections.Team;
import com.tourFranciaSofka.tourFranciaSofka2022.mappers.TeamMapper;
import com.tourFranciaSofka.tourFranciaSofka2022.dtos.TeamDTO;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UpdateTeamUseCase {
    private final TeamMapper teamMapper;

    private final ReactiveMongoTemplate mongoTemplate;

    public UpdateTeamUseCase(TeamMapper teamMapper, ReactiveMongoTemplate mongoTemplate) {
        this.teamMapper = teamMapper;
        this.mongoTemplate = mongoTemplate;
    }


    public Mono<TeamDTO> updateTeam(TeamDTO teamDTO) {
        Query query = new Query().addCriteria(Criteria.where("_id").is(teamDTO.getId()));
        Update update = new Update().set("teamName", teamDTO.getTeamName())
                .set("teamCode", teamDTO.getTeamCode())
                .set("country", teamDTO.getCountry())
                .set("cyclistsIDs", teamDTO.getCyclistsIDs());
        return mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true),Team.class).map(teamMapper::teamtoTeamDTO);
    }
}
