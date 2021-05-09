package com.pinto.receitas.datamodel;

import com.pinto.receitas.domain.valueobjects.Steps;
import com.pinto.receitas.domain.valueobjects.TimeOfCooking;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "recipes")
public class RecipeJpa {

    @Getter
    @Id
    @Column(name = "recipeName")
    private RecipeNameJpa recipeName;

    @Getter
    @Column(columnDefinition = "TEXT", name = "steps")
    private String steps;

    @Getter
    @Column(name = "timeOfCooking")
    private String timeOfCooking;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<IngredientJpa> ingredientJpas;

    public RecipeJpa(RecipeNameJpa recipeName, Steps steps, TimeOfCooking timeOfCooking) {
        this.recipeName = recipeName;
        this.steps = steps.toString();
        this.timeOfCooking = timeOfCooking.toString();
        ingredientJpas = new ArrayList<>();
    }
}
