package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class AuthPagePublisher {
    private SelenideElement inputLogin = $("input[type = 'text']");
    private SelenideElement inputPassword = $("input[type = 'password']");
    private SelenideElement buttonLogIn = $(".Button");
    private SelenideElement alertInvalidLogin = $(".Toastify__toast--error");
    private SelenideElement alertInvalidPassword = $(".Toastify__toast-container--top-right");

    public MainPagePublisher auth(String login, String password) {
        inputLogin.click();
        inputLogin.setValue(login);
        inputPassword.click();
        inputPassword.setValue(password);
        buttonLogIn.click();
        return new MainPagePublisher();
    }

    public AuthPagePublisher invalidAuth(String login, String password) {
        inputLogin.click();
        inputLogin.setValue(login);
        inputPassword.click();
        inputPassword.setValue(password);
        buttonLogIn.click();
        return this;
    }

    public void checkInvalidLogin(String expectedResult) {
        alertInvalidLogin.shouldHave(Condition.text(expectedResult));
    }

    public void checkInvalidPassword(String expectedResult) {
        alertInvalidPassword.shouldHave(Condition.text(expectedResult));
    }
}



