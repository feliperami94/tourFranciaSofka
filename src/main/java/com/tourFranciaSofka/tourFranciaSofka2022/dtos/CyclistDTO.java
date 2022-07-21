package com.tourFranciaSofka.tourFranciaSofka2022.dtos;

import com.tourFranciaSofka.tourFranciaSofka2022.collections.Cyclist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CyclistDTO {
    private String id;
    @NotBlank
    private String cyclistName;
    @Size(min = 0, max = 999, message = "The unique number code must have a maximum of 3 characters")
    private Integer uniqueNumber;
    @NotBlank
    private String teamCode;
    @NotBlank
    private String nationality;
}
