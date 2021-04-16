package com.pinto.receitas.shared.datamodel;

import com.pinto.receitas.shared.valueobjects.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor

@Entity
//@Table(name = "ingredientJpas")
public class IngredientJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String ingredient;

    @ManyToOne()
    //@JoinColumn(name = "recipeJpa", nullable = false)
    private RecipeJpa recipeJpa;


    public IngredientJpa(Ingredient ingredient, RecipeJpa recipeJpa) {
        this.ingredient = ingredient.toString();
        this.recipeJpa = recipeJpa;

    }


}
