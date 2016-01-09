import org.junit.*;
import static org.junit.Assert.*;

public class WordPuzzleTest {

  @Test
  public void puzzle_ReplaceVowel_A_InWordCat_Ct(){
    WordPuzzle sentence = new WordPuzzle();
    assertEquals("C-t", sentence.changeVowels("Cat"));
  }

  @Test
  public void puzzle_ReplaceVowelsInSentenceHowAreYou_Hwry(){
    WordPuzzle sentence = new WordPuzzle();
    assertEquals("H-w -r- y--?", sentence.changeVowels("How are you?"));
  }

  @Test
  public void puzzle_ReplaceVowelsWithoutCaseSensitivityInSentenceHOwArEYOU_Hwry(){
    WordPuzzle sentence = new WordPuzzle();
    assertEquals("H-w -r- y--?", sentence.changeVowels("How ArE yOU?"));
  }

  @Test
  public void puzzleResult_caseSensitivityTestCATcat_true(){
    WordPuzzle sensetivity = new WordPuzzle();
    assertEquals(true, sensetivity.gameResult("CAT", "cat"));
  }
}
