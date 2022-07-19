package com.tourFranciaSofka.tourFranciaSofka2022.router.cyclist;

import com.tourFranciaSofka.tourFranciaSofka2022.dtos.CyclistDTO;
import com.tourFranciaSofka.tourFranciaSofka2022.usecases.cyclist.GetAllCyclistsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllCyclistRoute {
    @Bean
    public RouterFunction<ServerResponse> getAllCyclists(GetAllCyclistsUseCase getAllCyclistsUseCase){
        return route(GET("v1/api/getAllCyclists"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getAllCyclistsUseCase.getAllCyclists(), CyclistDTO.class)));
    }
}
