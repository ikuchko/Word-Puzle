import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class WordPuzzle {
  public static void main(String[] args) {}

  public static String changeVowels(String sentence){
    //ArrayList<Char> letters = new ArrayList<Char>();
    String[] lettersLowerCase = {"a", "e", "i", "o", "u"};
    String[] lettersUpperCase = {"A", "E", "I", "O", "U"};
    //sentence = sentence.toLowerCase();
    for (Integer i=0; i<lettersLowerCase.length; i++){
      sentence = sentence.replace(lettersLowerCase[i], "-");
      sentence = sentence.replace(lettersUpperCase[i], "-");
    }
    return sentence;
  }
}
