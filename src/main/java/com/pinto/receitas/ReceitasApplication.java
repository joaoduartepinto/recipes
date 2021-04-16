package com.pinto.receitas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@EnableAutoConfiguration
@SpringBootApplication
//@EntityScan(basePackages = {"com.pinto.receitas.shared.datamodel"})
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
