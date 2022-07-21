package com.tourFranciaSofka.tourFranciaSofka2022.usecases.team;

import com.tourFranciaSofka.tourFranciaSofka2022.dtos.TeamDTO;
import com.tourFranciaSofka.tourFranciaSofka2022.mappers.TeamMapper;
import com.tourFranciaSofka.tourFranciaSofka2022.repository.TeamRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetTeamsByCountryUseCase {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;


    public GetTeamsByCountryUseCase(TeamRepository teamRepository, TeamMapper teamMapper) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }

    public Flux<TeamDTO> getTeamsByCountry(String country) {
        return teamRepository.getTeamsByCountry(country).map(teamMapper::teamtoTeamDTO);
    }

}
