package com.tourFranciaSofka.tourFranciaSofka2022.router.team;

import com.tourFranciaSofka.tourFranciaSofka2022.dtos.CyclistDTO;
import com.tourFranciaSofka.tourFranciaSofka2022.dtos.TeamDTO;
import com.tourFranciaSofka.tourFranciaSofka2022.usecases.cyclist.GetCyclistsByTeamCodeUseCase;
import com.tourFranciaSofka.tourFranciaSofka2022.usecases.team.GetTeamsByCountryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetTeamsByCountryRoute {
    @Bean
    public RouterFunction<ServerResponse> GetTeamsByCountry(GetTeamsByCountryUseCase getTeamsByCountryUseCase){
        return route(GET("v1/api/getTeamsByCountry/{country}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getTeamsByCountryUseCase.getTeamsByCountry(request.pathVariable("country")), TeamDTO.class)));
    }
}
