package com.tourFranciaSofka.tourFranciaSofka2022.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cyclist {
    @Id
    private String id;
    private String cyclistName;
    @Indexed(unique=true)
    private Integer uniqueNumber;
    private String teamCode;
    private String nationality;


}
