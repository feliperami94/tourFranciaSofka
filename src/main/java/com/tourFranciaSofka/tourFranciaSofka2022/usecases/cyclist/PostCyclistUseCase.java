package com.tourFranciaSofka.tourFranciaSofka2022.usecases.cyclist;

import com.tourFranciaSofka.tourFranciaSofka2022.mappers.CyclistMapper;
import com.tourFranciaSofka.tourFranciaSofka2022.dtos.CyclistDTO;
import com.tourFranciaSofka.tourFranciaSofka2022.repository.CyclistRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PostCyclistUseCase {
    private final CyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;

    public PostCyclistUseCase(CyclistRepository cyclistRepository, CyclistMapper cyclistMapper){
        this.cyclistRepository = cyclistRepository;
        this.cyclistMapper = cyclistMapper;
    }

    public Mono<CyclistDTO> postCyclist(CyclistDTO cyclistDTO){
        return cyclistRepository.save(cyclistMapper.cyclistDTOToCyclist(cyclistDTO)).map(cyclistMapper::cyclistToCyclistDTO);
    }

}
