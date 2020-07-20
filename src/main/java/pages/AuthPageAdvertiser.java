package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AuthPageAdvertiser {
    private SelenideElement inputLogin = $("input[type = 'text']");
    private SelenideElement inputPassword = $("input[type = 'password']");
    private SelenideElement buttonLogIn = $("button[type = 'submit']");

    public MainPageAdvertiser auth(String login, String password) {
        inputLogin.click();
        inputLogin.setValue(login);
        inputPassword.click();
        inputPassword.setValue(password);
        buttonLogIn.click();
        return new MainPageAdvertiser();
    }
}
