package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class AuthPage {
    private SelenideElement inputLogin = $("input[type = 'text']");
    private SelenideElement inputPassword = $("input[type = 'password']");
    private SelenideElement buttonLogIn = $(".Button");
    private SelenideElement alertInvalidLogin = $(".Toastify__toast--error");
    private SelenideElement alertInvalidPassword = $(".Toastify__toast-container--top-right");

    public MainPage auth(String login, String password) {
        inputLogin.click();
        inputLogin.setValue(login);
        inputPassword.click();
        inputPassword.setValue(password);
        buttonLogIn.click();
        return new MainPage();
    }

    public AuthPage invalidAuth(String login, String password) {
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



