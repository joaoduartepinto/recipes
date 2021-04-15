package com.pinto.receitas.shared.datamodel;

import com.pinto.receitas.shared.valueobjects.RecipeName;
import com.pinto.receitas.shared.valueobjects.Steps;
import com.pinto.receitas.shared.valueobjects.TimeOfCooking;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
//@Table(name = "recipe_jpa")
public class RecipeJpa {

    @Getter
    @Id
    //@Column(name = "recipeName")
    private String recipeName;
    @Getter
    //@Column(name = "steps")
    private String steps;
    @Getter
    //@Column(name = "timeOfCooking")
    private String timeOfCooking;

    /*
    @OneToMany(mappedBy = "id.ingredientJpa", cascade = CascadeType.ALL)
    private List<IngredientJpa> ingredientJpas;

     */

    public RecipeJpa(RecipeName recipeName, Steps steps, TimeOfCooking timeOfCooking) {
        this.recipeName = recipeName.toString();
        this.steps = steps.toString();
        this.timeOfCooking = timeOfCooking.toString();
    }

    public void setIngredients(List<IngredientJpa> ingredientJpaList) {
    }
}
