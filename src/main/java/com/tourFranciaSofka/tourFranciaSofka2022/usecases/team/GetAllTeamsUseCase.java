package com.tourFranciaSofka.tourFranciaSofka2022.usecases.team;

import com.tourFranciaSofka.tourFranciaSofka2022.config.mappers.TeamMapper;
import com.tourFranciaSofka.tourFranciaSofka2022.dtos.TeamDTO;
import com.tourFranciaSofka.tourFranciaSofka2022.repository.TeamRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllTeamsUseCase {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;


    public GetAllTeamsUseCase(TeamRepository teamRepository, TeamMapper teamMapper) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }

    public Flux<TeamDTO> getAllTeams(){
        return teamRepository.findAll().map(teamMapper::teamtoTeamDTO);
    }
}
