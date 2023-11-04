import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {
@Test
    public void testIssuesSearch(){
    SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        $(".search-input-container").click();
        $("#query-builder-test").setValue("capitan-catalkin/HW_11_File").pressEnter();
        $(By.linkText("capitan-catalkin/HW_11_File")).click();
        $("#issues-tab").click();
        $("#issue_1").shouldHave(Condition.text("Обработка ошибок"));


    }

}
