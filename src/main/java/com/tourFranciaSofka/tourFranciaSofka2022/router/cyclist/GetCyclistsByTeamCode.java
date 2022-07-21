package com.tourFranciaSofka.tourFranciaSofka2022.router.cyclist;

import com.tourFranciaSofka.tourFranciaSofka2022.dtos.CyclistDTO;
import com.tourFranciaSofka.tourFranciaSofka2022.usecases.cyclist.GetCyclistsByTeamCodeUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetCyclistsByTeamCode {
    @Bean
    public RouterFunction<ServerResponse> GetCyclistsByTeamCode(GetCyclistsByTeamCodeUseCase getCyclistsByTeamCodeUseCase){
        return route(GET("v1/api/getCyclistsByTeamCode/{teamCode}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getCyclistsByTeamCodeUseCase.getCyclistsByTeamCode(request.pathVariable("teamCode")), CyclistDTO.class)));
    }
}
