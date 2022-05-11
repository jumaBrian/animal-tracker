
import Models.EndangeredSpecies;
import Models.UnthreatenedSpecies;

import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) {

        staticFileLocation("/public");
        staticFileLocation("/public");      // EnableDebugScreen();

        // index page
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        // animals registry
        get("/animals-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        // animals catalogue
        get("/Animals", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Safe> safeAnimal = Safe.all();
            List<Endangered>  unsafeAnimal = Endangered.all();
            model.put("safeAnimal", safeAnimal);
            model.put("unsafeAnimal",unsafeAnimal);
            return new ModelAndView(model, "allAnimals.hbs");
        }, new HandlebarsTemplateEngine());




        //
    }
}
