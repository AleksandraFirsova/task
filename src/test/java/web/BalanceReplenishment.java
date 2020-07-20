package web;

import com.codeborne.selenide.Selenide;
import config.Config;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AuthPage;
import pages.Credential;
import pages.MainPage;

public class BalanceReplenishment {
    private Config config = Config.getInstance();
    private AuthPage authPage;
    private MainPage mainPage;
    Credential credential = new Credential();

    @BeforeEach
    void setUp() {
        authPage = Selenide.open("https://publishers.propellerads.com/#/sites/list", AuthPage.class);
        authPage.auth(credential.getValidLogin(), credential.getValidPassword());
    }

    @Test
    void checkBalanceReplenishment() {

    }

    @AfterEach
    void closeBrowser() {
        Selenide.closeWindow();
    }
}
