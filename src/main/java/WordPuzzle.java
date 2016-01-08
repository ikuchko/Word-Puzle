import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class WordPuzzle {
  public static void main(String[] args) {}

  public static String changeVowels(String sentence){
    //ArrayList<Char> letters = new ArrayList<Char>();
    String[] letters = {"a", "e", "i", "o", "u"};
    for (Integer i=0; i<letters.length; i++){
      sentence = sentence.replace(letters[i], "-");
    }
    return sentence;
  }
}
