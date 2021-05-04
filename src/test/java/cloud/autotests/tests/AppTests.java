package cloud.autotests.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class AppTests extends TestBase {
    @Test
    @Description("Check yandex search")
    @DisplayName("Search item on ya.ru")
    void generatedTest() {
        step("Open 'http://ya.ru'", () -> {
            open("");
            assertThat(title()).isEqualTo("Яндекс");
        });

        step("Set search 'Allure TestOps'", () -> {
            $("input#text").val("Allure TestOps");
        });

        step("Click 'search' button", () -> {
            $("button.button_theme_websearch").click();
            $("li.serp-item ").should(matchText("Allure TestOps"));
        });
    }
}