package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenidGithubJunit {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }
    @AfterAll
    static void afterAll() { closeWebDriver();}

    @Test
    void shouldFindJunit5() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-box").$(withText("more pages")).click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("JUnit5"));
    }
}
