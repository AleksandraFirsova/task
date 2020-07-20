package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPagePublisher {

    private SelenideElement checkAuthResult = $(".cgYHss");

    public void checkThatSitesPageIsOpen(String expectedResult) {
        checkAuthResult.shouldHave(Condition.text(expectedResult));
    }
}
