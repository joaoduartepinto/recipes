package com.pinto.receitas;

import com.pinto.receitas.application.appservicesImpl.AddRecipeServiceInter;
import com.pinto.receitas.shared.dto.RecipeDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ReceitasApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReceitasApplication.class, args);
    }

    //TODO: como fazer ligação ao MySql?!

    /*
    @Bean
    public CommandLineRunner test(AddRecipeServiceInter addRecipeServiceInter) {
        return (args) -> {
            List<String> ingredientes = new ArrayList<>();
            ingredientes.add("batata");
            addRecipeServiceInter.createRecipe(new RecipeDTO("arroz", ingredientes, "cozer" , "3 minutos"));

        };
    }

     */



}
