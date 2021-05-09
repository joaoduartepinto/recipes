package com.pinto.receitas.dto;

import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

public class RecipeHEADOutputDTO extends RepresentationModel {

    @Getter
    private String recipeName;
    @Getter
    private String timeOfCooking;

    public RecipeHEADOutputDTO(String recipeName, String timeOfCooking) {
        this.recipeName = recipeName;
        this.timeOfCooking = timeOfCooking;
    }
}
