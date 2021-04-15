package com.pinto.receitas.interfaceadapters.controllers.controllersImpl;

import com.pinto.receitas.application.appservicesImpl.GetRecipeServiceInter;
import com.pinto.receitas.interfaceadapters.controllers.controllersInter.GetRecipeControllerInter;
import com.pinto.receitas.shared.dto.RecipeInputDTO;
import com.pinto.receitas.shared.dto.RecipeOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GetRecipeControllerControllerImpl implements GetRecipeControllerInter {

    @Autowired
    GetRecipeServiceInter getRecipeServiceInter;

    @GetMapping(value = "/getRecipe", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getRecipe(@RequestParam String recipeName) {
        RecipeOutputDTO recipeDTO;

        try {
            recipeDTO = getRecipeServiceInter.getRecipe(recipeName);


            return new ResponseEntity<>(recipeDTO, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}