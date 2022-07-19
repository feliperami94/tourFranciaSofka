package com.tourFranciaSofka.tourFranciaSofka2022.router.team;

import com.tourFranciaSofka.tourFranciaSofka2022.usecases.cyclist.DeleteCyclistUseCase;
import com.tourFranciaSofka.tourFranciaSofka2022.usecases.team.DeleteTeamUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteTeamRoute {
    @Bean
    public RouterFunction<ServerResponse> deleteTeam(DeleteTeamUseCase deleteTeamUseCase) {
        return route(DELETE("v1/api/deleteTeam/{teamID}"),
                request -> deleteTeamUseCase.deleteTeam(request.pathVariable("teamID"))
                        .flatMap(unused -> ServerResponse.status(HttpStatus.ACCEPTED).build()));
    }
}
