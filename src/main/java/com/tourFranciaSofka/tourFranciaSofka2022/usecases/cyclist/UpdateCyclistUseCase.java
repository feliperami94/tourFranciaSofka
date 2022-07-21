package com.tourFranciaSofka.tourFranciaSofka2022.usecases.cyclist;

import com.tourFranciaSofka.tourFranciaSofka2022.collections.Cyclist;
import com.tourFranciaSofka.tourFranciaSofka2022.dtos.CyclistDTO;
import com.tourFranciaSofka.tourFranciaSofka2022.mappers.CyclistMapper;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UpdateCyclistUseCase {
    private CyclistMapper cyclistMapper;
    private ReactiveMongoTemplate mongoTemplate;

    public UpdateCyclistUseCase(CyclistMapper cyclistMapper, ReactiveMongoTemplate mongoTemplate) {
        this.cyclistMapper = cyclistMapper;
        this.mongoTemplate = mongoTemplate;
    }


    public Mono<CyclistDTO> updateCyclist(CyclistDTO cyclistDTO) {
        Query query = new Query().addCriteria(Criteria.where("_id").is(cyclistDTO.getId()));
        Update update = new Update().set("cyclistName", cyclistDTO.getCyclistName())
                .set("uniqueNumber", cyclistDTO.getUniqueNumber())
                .set("teamCode", cyclistDTO.getTeamCode())
                .set("nationality", cyclistDTO.getNationality());
        return mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true), Cyclist.class).map(cyclistMapper::cyclistToCyclistDTO);
    }
}
