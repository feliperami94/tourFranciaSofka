package com.tourFranciaSofka.tourFranciaSofka2022.router.cyclist;

import com.tourFranciaSofka.tourFranciaSofka2022.usecases.cyclist.DeleteCyclistUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteCyclistRoute {

    @Bean
    public RouterFunction<ServerResponse> deleteCyclist(DeleteCyclistUseCase deleteCyclistUseCase) {
        return route(DELETE("v1/api/deleteCyclist/{cyclistId}"),
                request -> deleteCyclistUseCase.deleteCyclist(request.pathVariable("cyclistId"))
                        .flatMap(unused -> ServerResponse.status(HttpStatus.ACCEPTED).build()));
    }

}
