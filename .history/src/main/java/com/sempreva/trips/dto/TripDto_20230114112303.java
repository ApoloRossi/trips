package com.sempreva.trips.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TripDto {
    
    private Long id;

    private String name;

    private String description;

    private Double value;

    private String dateInit;

    private String dateEnd;

    private int availableVacancies;

    private String city;

    private String state;


}
