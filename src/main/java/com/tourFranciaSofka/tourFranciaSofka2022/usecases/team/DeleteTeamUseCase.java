package com.tourFranciaSofka.tourFranciaSofka2022.usecases.team;

import com.tourFranciaSofka.tourFranciaSofka2022.config.mappers.TeamMapper;
import com.tourFranciaSofka.tourFranciaSofka2022.repository.TeamRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteTeamUseCase {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;


    public DeleteTeamUseCase(TeamRepository teamRepository, TeamMapper teamMapper) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }

    public Mono<Void> deleteTeam(String teamID) {
        return teamRepository.deleteById(teamID).doOnError(throwable -> Mono.error(throwable.getCause()));
    }
}
