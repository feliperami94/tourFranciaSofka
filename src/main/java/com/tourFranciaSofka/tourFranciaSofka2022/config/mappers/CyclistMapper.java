package com.tourFranciaSofka.tourFranciaSofka2022.config.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tourFranciaSofka.tourFranciaSofka2022.collections.Cyclist;
import com.tourFranciaSofka.tourFranciaSofka2022.dtos.CyclistDTO;
import org.springframework.stereotype.Component;

@Component
public class CyclistMapper {

    //DTO to collection ->Serialize
    public Cyclist cyclistDTOToCyclist(CyclistDTO cyclistDTO){
        return new Cyclist(
                cyclistDTO.getId(),
                cyclistDTO.getUniqueNumber(),
                cyclistDTO.getTeamId(),
                cyclistDTO.getNationality()
        );
    }

    //Collection to DTO -> Deserialize
    public CyclistDTO cyclistToCyclistDTO(Cyclist cyclist){
        return new CyclistDTO(
                cyclist.getId(),
                cyclist.getUniqueNumber(),
                cyclist.getTeamId(),
                cyclist.getNationality()
        );
    }


}
