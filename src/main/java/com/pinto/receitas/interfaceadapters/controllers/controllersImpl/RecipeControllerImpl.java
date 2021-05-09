package com.pinto.receitas.interfaceadapters.controllers.controllersImpl;

import com.pinto.receitas.application.appservicesInter.AddRecipeServiceInter;
import com.pinto.receitas.application.appservicesInter.GetRecipeServiceInter;
import com.pinto.receitas.application.appservicesInter.GetRecipesServiceInter;
import com.pinto.receitas.dto.RecipeHEADOutputDTO;
import com.pinto.receitas.interfaceadapters.controllers.controllersInter.RecipeController;
import com.pinto.receitas.dto.AddRecipeResponseDTO;
import com.pinto.receitas.dto.RecipeInputDTO;
import com.pinto.receitas.dto.RecipeOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/recipes")
public class RecipeControllerImpl implements RecipeController {

    @Autowired
    AddRecipeServiceInter addRecipeService;

    @Autowired
    GetRecipeServiceInter getRecipeServiceInter;

    @Autowired
    GetRecipesServiceInter getRecipesServiceInter;

    @PostMapping
    @Override
    public ResponseEntity<AddRecipeResponseDTO> addRecipe(@RequestBody RecipeInputDTO recipeInputDTO) {

        AddRecipeResponseDTO addRecipeResponseDTO;

        try {

            addRecipeResponseDTO = addRecipeService.createRecipe(recipeInputDTO);

            Link link = linkTo(methodOn(RecipeControllerImpl.class).getRecipe(addRecipeResponseDTO.getRecipeName())).withSelfRel();

            addRecipeResponseDTO.add(link);

            return new ResponseEntity<>(addRecipeResponseDTO, HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping(value = "/{recipeName}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<RecipeOutputDTO> getRecipe(@PathVariable String recipeName) {
        RecipeOutputDTO recipeDTO;
        try {
            recipeDTO = getRecipeServiceInter.getRecipe(recipeName);

            return new ResponseEntity<>(recipeDTO, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Page<RecipeHEADOutputDTO>> getRecipes(Pageable pageable) {

        Page<RecipeHEADOutputDTO> recipePage = getRecipesServiceInter.getRecipes(pageable);

        for (RecipeHEADOutputDTO recipeHEADOutputDTO : recipePage){
            Link link = linkTo(methodOn(RecipeControllerImpl.class).getRecipe(recipeHEADOutputDTO.getRecipeName())).withSelfRel();
            recipeHEADOutputDTO.add(link);
        }

        return new ResponseEntity(recipePage, HttpStatus.OK);
    }
}
