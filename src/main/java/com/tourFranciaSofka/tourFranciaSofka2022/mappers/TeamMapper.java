package com.tourFranciaSofka.tourFranciaSofka2022.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tourFranciaSofka.tourFranciaSofka2022.collections.Team;
import com.tourFranciaSofka.tourFranciaSofka2022.dtos.TeamDTO;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {

    //Entity to DTO
    public TeamDTO teamtoTeamDTO(Team team){
        return new TeamDTO(
                team.getId(),
                team.getTeamName(),
                team.getTeamCode(),
                team.getCountry(),
                team.getCyclistsIDs()
        );
    }

    //DTO to Entity
    public Team teamDTOtoTeam(TeamDTO teamDTO){
        return new Team(
                teamDTO.getId(),
                teamDTO.getTeamName(),
                teamDTO.getTeamCode(),
                teamDTO.getCountry(),
                teamDTO.getCyclistsIDs()
        );
    }
}
