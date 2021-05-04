import models.Animal;
import models.Endangered;
import models.Ranger;
import models.Sighting;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App{
    public static void main(String[] args) {
        ProcessBuilder process = new ProcessBuilder();
        int port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
        port(port);
        staticFileLocation("/public");

        // creating the landing page
        get("/",(request, response) ->{
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());
        // get new animals
        get( "/animal/form", (request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"animal-form.hbs");
        },new HandlebarsTemplateEngine());
        post("/animals/new",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            String animalName = request.queryParams("Name");
            String health = request.queryParams("health");
            String Age = request.queryParams("age");
            String rangerName = request.queryParams("ranger");
            String location = request.queryParams("location");
            int sightId = Integer.parseInt(request.queryParams("sightingId"));
            try {
                Animal animal = new Animal(animalName, sightId);
                animal.save();
                Sighting sight = new Sighting(rangerName, location);
                sight.saveSighting();
            }catch(IllegalArgumentException exception){
                System.out.println("Enter the right data");
            }
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());
        get("/animals/new",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            model.put("animals",Animal.allAnimals());
            return new ModelAndView(model,"animal.hbs");
        }, new HandlebarsTemplateEngine());
        // get endangered
        get("/endangered/form",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            model.put("animals",Animal.allAnimals());
            model.put("rangers",Ranger.all());
            return new ModelAndView(model,"endangered-form.hbs");
        },new HandlebarsTemplateEngine());
        post("/endangered/new",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            String animalName = request.queryParams("Name");
            String health = request.queryParams("health");
            String Age = request.queryParams("age");
            String rangerName = request.queryParams("ranger");
            String location = request.queryParams("location");
            Endangered endangered = new Endangered(animalName,health,Age,rangerName);
            endangered.save();
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());
        get("/endangered/new",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            model.put("animals",Endangered.all());
            return new ModelAndView(model,"endangered.hbs");
        }, new HandlebarsTemplateEngine());
        get("/ranger/form",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            return new ModelAndView(model,"ranger-form.hbs");
        }, new HandlebarsTemplateEngine());
        get("/ranger/new",(request, response) -> {
            Map<String, Object>model = new HashMap<>();
            model.put("rangers",Ranger.all());
            return new ModelAndView(model,"ranger.hbs");
        }, new HandlebarsTemplateEngine());
        post("/ranger/new",(request, response) -> {
            Map<String, Object>model = new HashMap<>();
            String name = request.queryParams("Name");
            String phone = request.queryParams("Phone");
            String email = request.queryParams("Email");
            try {
                Ranger ranger = new Ranger(name, phone, email);
                ranger.save();
            }catch(IllegalArgumentException exception){
                System.out.println("Please enter the correct data");
            }
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());

    }
}