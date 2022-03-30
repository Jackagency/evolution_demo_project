package evolution.autotests.tests;

import com.codeborne.selenide.Condition;
import evolution.autotests.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class MainPageTests extends TestBase {
    @Test
    @Description("Search tests")
    @DisplayName("Search with 'Stockholm' value")
    void searchForStockholm() {
        step("Open https://www.evolution.com/", () -> {
            open("https://www.evolution.com/");
        });

        step("Accept Cookies", () -> {
            $("#onetrust-accept-btn-handler").click();
        });

        step("Click the Search button", () -> {
            $(".show-search", 1).click();
        });

        step("Set Stockholm in the search field", () -> {
            $("[name=apachesolr_panels_search_form]").setValue("Stockholm").pressEnter();
        });

        step("Check results", () -> {
            $("div ol li:nth-child(1)").shouldHave(Condition.text("Stockholm"));
        });
    }

    @Test
    @Description("Search tests")
    @DisplayName("Search with 'Development' value")
    void searchForDevelopment() {
        step("Open https://www.evolution.com/", () -> {
            open("https://www.evolution.com/");
        });

        step("Accept Cookies", () -> {
            $("#onetrust-accept-btn-handler").click();
        });

        step("Click the Search button", () -> {
            $(".show-search", 1).click();
        });

        step("Set Development in the search field", () -> {
            $("[name=apachesolr_panels_search_form]").setValue("Development").pressEnter();
        });

        step("Check results", () -> {
            $("div ol li:nth-child(1)").shouldHave(Condition.text("Development"));
        });
    }

    @Test
    @Description("Search tests")
    @DisplayName("Search with 'Quality' value")
    void searchForQuality() {
        step("Open https://www.evolution.com/", () -> {
            open("https://www.evolution.com/");
        });

        step("Accept Cookies", () -> {
            $("#onetrust-accept-btn-handler").click();
        });

        step("Click the Search button", () -> {
            $(".show-search", 1).click();
        });

        step("Set Quality in the search field", () -> {
            $("[name=apachesolr_panels_search_form]").setValue("Quality").pressEnter();
        });

        step("Check results", () -> {
            $("div ol li:nth-child(1)").shouldHave(Condition.text("Quality"));
        });
    }

    @Test
    @Description("Title tests")
    @DisplayName("Who we are title tests")
    void whoweareTitleTest() {
        step("Open https://www.evolution.com/", () -> {
            open("https://www.evolution.com/");
        });

        step("Accept Cookies", () -> {
            $("#onetrust-accept-btn-handler").click();
        });

        step("Click 'who we are'", () -> {
            $("li.menu-mlid-690", 1).click();
        });

        step("Check the title", () -> {
            $(".buttons-container").scrollIntoView(false);
            $(".slide-title").shouldHave(Condition.text("We are game creators and game changers"));
        });
    }

    @Test
    @Description("Title tests")
    @DisplayName("Our games title tests")
    void ourgamesTitleTest() {
        step("Open https://www.evolution.com/", () -> {
            open("https://www.evolution.com/");
        });

        step("Accept Cookies", () -> {
            $("#onetrust-accept-btn-handler").click();
        });

        step("Click 'Our games'", () -> {
            $("li.menu-mlid-693", 1).click();
        });

        step("Check the title", () -> {
            $(".buttons-container").scrollIntoView(false);
            $(".slide-title").shouldHave(Condition.text("World leading online casino"));
        });
    }

    @Test
    @Description("Title tests")
    @DisplayName("News title tests")
    void newsTitleTest() {
        step("Open https://www.evolution.com/", () -> {
            open("https://www.evolution.com/");
        });

        step("Accept Cookies", () -> {
            $("#onetrust-accept-btn-handler").click();
        });

        step("Click 'News'", () -> {
            $("li.menu-mlid-55340", 1).click();
        });

        step("Check the title", () -> {
            $(".buttons-container").scrollIntoView(false);
            $(".animateIn", 0).shouldHave(Condition.text("Our news"));
        });
    }

    @Test
    @Description("Broken tests")
    @DisplayName("Broken test 1")
    @Disabled
    void brokenTest1() {
        step("Open https://www.evolution.com/", () -> {
            open("https://www.evolution.com/");
        });

        step("Accept Cookies", () -> {
            $("#onetrust-accept-btn-handler").click();
        });

        step("Click 'News'", () -> {
            $("li.menu-mlid-55340", 1).click();
        });

        step("Check the title", () -> {
            $(".buttons-container").scrollIntoView(false);
            $(".animateIn", 0).shouldHave(Condition.text("Our news"));
        });
    }

    @Test
    @Description("Broken tests")
    @DisplayName("Broken test 2")
    @Disabled
    void brokenTest2() {
        step("Open https://www.evolution.com/", () -> {
            open("https://www.evolution.com/");
        });

        step("Accept Cookies", () -> {
            $("#onetrust-accept-btn-handler").click();
        });

        step("Click 'News'", () -> {
            $("li.menu-mlid-55340", 1).click();
        });

        step("Check the title", () -> {
            $(".buttons-container").scrollIntoView(false);
            $(".animateIn", 0).shouldHave(Condition.text("Our news"));
        });
    }

    @Test
    @Description("Page title test")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://www.evolution.com/'", () ->
            open("https://www.evolution.com/"));

        step("Page title should have text 'Evolution'", () -> {
            String expectedTitle = "Evolution";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Page console test")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://www.evolution.com/'", () ->
            open("https://www.evolution.com/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}