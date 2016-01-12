import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Enter your sentence and let see if your friend can guess it.");
  }

  @Test
  public void changeVowelsTest() {
    goTo("http://localhost:4567/");
    fill("#sentence").with("Where is my bear?");
    submit(".btn");
    assertThat(pageSource()).contains("Wh-r- -s my b--r?");
  }

  @Test
  public void gameResultTest_true() {
    goTo("http://localhost:4567/");
    fill("#sentence").with("Never give up!");
    submit(".btn");
    fill("#userGuesss").with("Never give up!");
    submit(".btn");
    assertThat(pageSource()).contains("Congratulation! How did you know?");
  }

}
