package com.tourFranciaSofka.tourFranciaSofka2022.usecases.cyclist;

import com.tourFranciaSofka.tourFranciaSofka2022.mappers.CyclistMapper;
import com.tourFranciaSofka.tourFranciaSofka2022.repository.CyclistRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteCyclistUseCase {
    private CyclistRepository cyclistRepository;
    private CyclistMapper cyclistMapper;

    public DeleteCyclistUseCase(CyclistRepository cyclistRepository, CyclistMapper cyclistMapper) {
        this.cyclistRepository = cyclistRepository;
        this.cyclistMapper = cyclistMapper;
    }

    public Mono<Void> deleteCyclist(String cyclistId) {
        return cyclistRepository.deleteById(cyclistId).doOnError(throwable -> Mono.error(throwable.getCause()));
    }
}
