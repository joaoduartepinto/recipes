package com.pinto.receitas.interfaceadapters.controllers.controllersImpl;

import com.pinto.receitas.application.appservicesInter.AddRecipeServiceInter;
import com.pinto.receitas.interfaceadapters.controllers.controllersInter.AddRecpipeControllerInter;
import com.pinto.receitas.shared.dto.RecipeInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class AddRecipeControllerImplController implements AddRecpipeControllerInter {

    @Autowired
    AddRecipeServiceInter addRecipeService;

    // Para aceitar JSON precisa de ter annotation @ResponseBody e como parametro aceita o DTO,
    // Nome no Postman devem coincidir com os dados no DTO
    @PostMapping("/recipes")
    @ResponseBody
    public ResponseEntity<Object> addRecipe(@RequestBody RecipeInputDTO recipeInputDTO) {

        try {

            addRecipeService.createRecipe(recipeInputDTO);
            return new ResponseEntity<>(true, HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
