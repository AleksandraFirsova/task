package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private SelenideElement checkAuthResult = $(".cgYHss");
    private SelenideElement balance = $(" ");

    public void checkThatSitesPageIsOpen(String expectedResult) {
        checkAuthResult.shouldHave(Condition.text(expectedResult));
    }
}
