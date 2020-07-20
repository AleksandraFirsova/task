package web;

import com.codeborne.selenide.Selenide;
import config.Config;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.AuthPageAdvertiser;
import pages.Credential;
import pages.MainPageAdvertiser;
import pages.Payments;

public class Balance {
    private Config config = Config.getInstance();
    private AuthPageAdvertiser authPageAdvertiser;
    private MainPageAdvertiser mainPageAdvertiser;
    Credential credential = new Credential();

    @BeforeEach
    void setUp() {
        authPageAdvertiser = Selenide.open("https://partners.propellerads.com/#/app/auth", AuthPageAdvertiser.class);
        authPageAdvertiser.auth(credential.getValidLogin(), credential.getValidPasswordAdv());
        mainPageAdvertiser = new MainPageAdvertiser();
    }

    @CsvSource({"0, Card, BANKCARD",
            "1, WebMoney, WEBMONEY",
            "2, Yandex.Money, YANDEXMONEY"})

    @ParameterizedTest
    void openPaymentPage(int position, String expectedResult, Payments type) {
        mainPageAdvertiser.fillingInRequiredFieldsBalance(position, type).checkOpenPaymentPage(expectedResult, type);
    }

    @AfterEach
    void closeBrowser() {
        Selenide.closeWindow();
    }
}
