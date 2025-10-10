package com.interviewPrep.Project.NeDetailsDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NetworkElementsDto {
    private int ip;
    private String hostname;
    private String location;
}
