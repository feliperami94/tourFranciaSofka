package com.tourFranciaSofka.tourFranciaSofka2022.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @Id
    private String id;
    private String teamName;
    private String teamCode;
    private String country;
    private List<String> cyclists;
}
