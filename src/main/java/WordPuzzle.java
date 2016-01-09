import java.util.Map;
import java.util.HashMap;
import java.io.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class WordPuzzle {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";
    HashMap<Integer, String> hash = new HashMap<Integer, String>();

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("puzzle", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/puzzle.vtl");

      //String userInput = request.queryParams("sentence");
      hash.put(1, request.queryParams("sentence"));

      String puzzle = changeVowels(hash.get(1));

      model.put("key", puzzle);
      return new ModelAndView(model, layout);

    }, new VelocityTemplateEngine());

    get("puzzleResult", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      hash.put(2, request.queryParams("userGuesss"));
      Boolean result = gameResult(hash.get(1), hash.get(2));
    //  Boolean result = true;

    //  model.put ("ress", hash.get(1));
    //  model.put ("res", hash.get(2));

    //  model.put ("res", true);

      if (result) {
        model.put("template", "templates/puzzleResult.vtl");
      } else {
        model.put("template", "templates/home.vtl");
      }
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

  public static Boolean gameResult(String masterString, String guessString){
    if (masterString.toLowerCase().equals(guessString.toLowerCase())) {
  //  if (masterString.equals(guessString)) {
      return true;
    } else {
      return false;
    }


  }
}
