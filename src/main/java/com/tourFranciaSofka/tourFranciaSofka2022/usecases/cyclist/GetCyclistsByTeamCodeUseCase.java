package com.tourFranciaSofka.tourFranciaSofka2022.usecases.cyclist;

import com.tourFranciaSofka.tourFranciaSofka2022.mappers.CyclistMapper;
import com.tourFranciaSofka.tourFranciaSofka2022.dtos.CyclistDTO;
import com.tourFranciaSofka.tourFranciaSofka2022.repository.CyclistRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetCyclistsByTeamCodeUseCase {
    private final CyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;

    public GetCyclistsByTeamCodeUseCase(CyclistRepository cyclistRepository, CyclistMapper cyclistMapper) {
        this.cyclistRepository = cyclistRepository;
        this.cyclistMapper = cyclistMapper;
    }

    public Flux<CyclistDTO> getCyclistsByTeamCode(String teamCode) {
        return cyclistRepository.findCyclistsByTeamCode(teamCode).map(cyclistMapper::cyclistToCyclistDTO);
    }

}
