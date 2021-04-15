package com.pinto.receitas.interfaceadapters.controllers.controllersImpl;

import com.mysql.cj.xdevapi.JsonParser;
import com.pinto.receitas.application.appservicesImpl.AddRecipeServiceInter;
import com.pinto.receitas.interfaceadapters.controllers.controllersInter.AddRecpipeInter;
import com.pinto.receitas.shared.dto.RecipeDTO;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddRecipeImpl implements AddRecpipeInter {

    @Autowired
    AddRecipeServiceInter addRecipeService;

    // Para aceitar JSON precisa de ter annotation @ResponseBody e como parametro aceita o DTO,
    // Nome no Postman devem coincidir com os dados no DTO
    @PostMapping("/addRecipe")
    @ResponseBody
    public ResponseEntity<Object> addRecipe(@RequestBody RecipeDTO recipeDTO) {

        addRecipeService.createRecipe(recipeDTO);

        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }
}
