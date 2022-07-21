package com.tourFranciaSofka.tourFranciaSofka2022.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class TeamDTO {
    private String id;
    @NotBlank
    private String teamName;
    @Size(max = 3, message = "The teamcode must have a maximum of 3 characters")
    private String teamCode;
    @NotNull
    private String country;
    @NotNull
    private List<String> cyclistsIDs;

}
