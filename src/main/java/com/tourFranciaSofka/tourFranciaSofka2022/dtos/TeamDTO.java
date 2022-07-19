package com.tourFranciaSofka.tourFranciaSofka2022.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class TeamDTO {
    private String id;
    private String teamName;
    private String teamCode;
    private String country;
    private List<String> cyclistsIDs;

}
