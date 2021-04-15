package com.pinto.receitas.interfaceadapters.controllers.controllersImpl;

import com.pinto.receitas.application.appservicesImpl.AddRecipeServiceInter;
import com.pinto.receitas.interfaceadapters.controllers.controllersInter.AddRecpipeControllerInter;
import com.pinto.receitas.shared.dto.RecipeInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddRecipeControllerImplController implements AddRecpipeControllerInter {

    @Autowired
    AddRecipeServiceInter addRecipeService;

    // Para aceitar JSON precisa de ter annotation @ResponseBody e como parametro aceita o DTO,
    // Nome no Postman devem coincidir com os dados no DTO
    @PostMapping("/addRecipe")
    @ResponseBody
    public ResponseEntity<Object> addRecipe(@RequestBody RecipeInputDTO recipeInputDTO) {

        addRecipeService.createRecipe(recipeInputDTO);

        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }
}
