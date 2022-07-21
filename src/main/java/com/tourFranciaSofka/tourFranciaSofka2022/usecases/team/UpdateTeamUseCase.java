package com.tourFranciaSofka.tourFranciaSofka2022.usecases.team;

import com.tourFranciaSofka.tourFranciaSofka2022.mappers.TeamMapper;
import com.tourFranciaSofka.tourFranciaSofka2022.dtos.TeamDTO;
import com.tourFranciaSofka.tourFranciaSofka2022.repository.TeamRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UpdateTeamUseCase {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;


    public UpdateTeamUseCase(TeamRepository teamRepository, TeamMapper teamMapper) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }

    public Mono<TeamDTO> updateTeam(TeamDTO teamDTO) {
        return teamRepository.save(teamMapper.teamDTOtoTeam(teamDTO)).map(teamMapper::teamtoTeamDTO);
    }
}
