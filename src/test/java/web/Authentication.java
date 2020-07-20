package web;

import com.codeborne.selenide.Selenide;
import config.Config;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.AuthPagePublisher;

public class Authentication {
    private Config config = Config.getInstance();
    private AuthPagePublisher authPagePublisher;


    @BeforeEach
    void setUp() {
        Selenide.open("https://publishers.propellerads.com/#/sites/list");
        authPagePublisher = new AuthPagePublisher();
    }

    @CsvSource({"alsfirsova@gmail.com, 1q2w3e4r1Q, My sites",
    })
    @ParameterizedTest
    void checkAuthorization(String queryLogin, String queryPassword, String expectedResult) {
        authPagePublisher.auth(queryLogin, queryPassword).checkThatSitesPageIsOpen(expectedResult);
    }

    @CsvSource({"alsfirsovagmail.com, 1q2w3e4r1Q, Invalid login or password"})
    @ParameterizedTest
    void checkIncorrectLogin(String queryLogin, String queryPassword, String expectedResult) {
        authPagePublisher.invalidAuth(queryLogin, queryPassword).checkInvalidLogin(expectedResult);
    }

    @CsvSource({"alsfirsova@gmail.com, 1, Invalid login or password"})
    @ParameterizedTest
    void checkIncorrectPassword(String queryLogin, String queryPassword, String expectedResult) {
        authPagePublisher.invalidAuth(queryLogin, queryPassword).checkInvalidPassword(expectedResult);
}

    @AfterEach
    void closeBrowser() {
        Selenide.closeWindow();
    }
}

