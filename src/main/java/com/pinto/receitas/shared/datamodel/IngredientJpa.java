package com.pinto.receitas.shared.datamodel;

import com.pinto.receitas.shared.valueobjects.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor

@Entity
@Table(name = "ingredients")
public class IngredientJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    private String ingredient;

    @ManyToOne
    @JoinColumn(name = "recipe", nullable = false)
    private RecipeJpa recipe;

    public IngredientJpa(Ingredient ingredient, RecipeJpa recipeJpa) {
        this.ingredient = ingredient.toString();
        this.recipe = recipeJpa;
    }


}
