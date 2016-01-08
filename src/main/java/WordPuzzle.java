import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class WordPuzzle {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("puzzle", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/puzzle.vtl");

      String userInput= request.queryParams("sentence");

      String puzzle = changeVowels(userInput);

      model.put("key", puzzle);
      return new ModelAndView(model, layout);

      }, new VelocityTemplateEngine());

  }

  public static String changeVowels(String sentence){
    //ArrayList<Char> letters = new ArrayList<Char>();
    String[] letters = {"a", "e", "i", "o", "u", "A", "E", "I", "O", "U"};
    //sentence = sentence.toLowerCase();
    for (Integer i=0; i<letters.length; i++){
      sentence = sentence.replace(letters[i], "-");
    }
    return sentence;
  }
}
