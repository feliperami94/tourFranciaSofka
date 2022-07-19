package com.tourFranciaSofka.tourFranciaSofka2022.router.team;

import com.tourFranciaSofka.tourFranciaSofka2022.dtos.CyclistDTO;
import com.tourFranciaSofka.tourFranciaSofka2022.dtos.TeamDTO;
import com.tourFranciaSofka.tourFranciaSofka2022.usecases.cyclist.PostCyclistUseCase;
import com.tourFranciaSofka.tourFranciaSofka2022.usecases.team.PostTeamUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PostTeamRoute {
    @Bean
    public RouterFunction<ServerResponse> postTeam(PostTeamUseCase postTeamUseCase) {
        return route(POST("v1/api/postTeam").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TeamDTO.class)
                        .flatMap(postTeamUseCase::postTeam)
                        .flatMap(teamDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(teamDTO)));
    }
}
