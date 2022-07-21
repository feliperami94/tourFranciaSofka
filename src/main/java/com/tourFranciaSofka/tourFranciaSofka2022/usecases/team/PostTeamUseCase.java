package com.tourFranciaSofka.tourFranciaSofka2022.usecases.team;

import com.tourFranciaSofka.tourFranciaSofka2022.mappers.TeamMapper;
import com.tourFranciaSofka.tourFranciaSofka2022.dtos.TeamDTO;
import com.tourFranciaSofka.tourFranciaSofka2022.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@Validated
public class PostTeamUseCase {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public PostTeamUseCase(TeamRepository teamRepository, TeamMapper teamMapper) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }

    public Mono<TeamDTO> postTeam(@Valid TeamDTO teamDTO) {

        return teamRepository.save(teamMapper.teamDTOtoTeam(teamDTO)).map(teamMapper::teamtoTeamDTO);
    }
}
