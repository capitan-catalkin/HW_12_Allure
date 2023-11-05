import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchRepository(String repo) {
        $(".search-input-container").click();
        $("#query-builder-test").setValue(repo).pressEnter();
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickLink(String repo) {
        $(By.linkText(repo)).click();
    }

    @Step("Открываем Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issues {issue}")
    public void shouldName(String issue) {
        $("#issue_1").shouldHave(Condition.text(issue));
    }
}
