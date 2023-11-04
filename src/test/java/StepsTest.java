import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepsTest {
    private static final String REPOSITORY = "capitan-catalkin/HW_11_File";
    private static final String ISSUES = "Обработка ошибок";
@Test
    public void testLambdaIssuesSearch(){
    SelenideLogger.addListener("allure", new AllureSelenide());

    step("Открываем главную страницу", () ->{
        open("https://github.com/");
    });

    step("Ищем репозиторий " + REPOSITORY, () -> {
        $(".search-input-container").click();
        $("#query-builder-test").setValue(REPOSITORY).pressEnter();
    });

    step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
        $(By.linkText(REPOSITORY)).click();
    });

    step("Открываем Issues", () -> {
        $("#issues-tab").click();
    });

    step("Проверяем наличие Issues " + ISSUES, () -> {
        $("#issue_1").shouldHave(Condition.text(ISSUES));
    });

    }
    @Test
    public void testAnnotedStep(){
    SelenideLogger.addListener("allure", new AllureSelenide());
    WebSteps steps = new WebSteps();

    steps.openMainPage();
    steps.searchRepository(REPOSITORY);
    steps.clickLink(REPOSITORY);
    steps.openIssuesTab();
    steps.shouldName(ISSUES);

    }
}
