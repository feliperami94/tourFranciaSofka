package com.tourFranciaSofka.tourFranciaSofka2022.dtos;

import com.tourFranciaSofka.tourFranciaSofka2022.collections.Cyclist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CyclistDTO {
    private String id;
    private String cyclistName;
    private String uniqueNumber;
    private String teamId;
    private String nationality;
}
