package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

public class MainPageAdvertiser {
    private SelenideElement fieldBalance = $(".TgedP");
    private ElementsCollection radioButton = $$(".add-funds__method");
    private SelenideElement fieldAmount = $("input[id = 'amount']");
    private ElementsCollection agreementCard = $$(".checkbox__icon");
    private SelenideElement agreement = $(".checkbox__icon");
    private SelenideElement buttonPayCard = $("[id = 'payBySafeChargeUsd']");
    private SelenideElement buttonPayWebMoney = $("[id = 'payByPaymaster']");
    private SelenideElement buttonPayYandexMoney = $("[id = 'payByPaymaster']");
    private SelenideElement payResultCard = $(".pm_available");
    private SelenideElement payResultWebMoney = $(".dd-selected-text");
    private SelenideElement buttonPay;

    public MainPageAdvertiser selectButtonPay(Payments type) {

        if (type.equals(Payments.BANKCARD)) {
            buttonPay = buttonPayCard;
        }
        if (type.equals(Payments.WEBMONEY)) {
            buttonPay = buttonPayWebMoney;
        }
        if (type.equals(Payments.YANDEXMONEY)) {
            buttonPay = buttonPayYandexMoney;
        }
        return null;
    }

    public MainPageAdvertiser fillingInRequiredFieldsBalance(int position, Payments type) {
        if (type.equals(Payments.BANKCARD)) {
            fieldBalance.click();
            radioButton.get(position).click();
            fieldAmount.setValue("100");
            agreementCard.first().click();
            agreementCard.last().click();
            selectButtonPay(type);
            sleep(2000);
            buttonPay.click();
            return new MainPageAdvertiser();
        }
        if (type.equals(Payments.WEBMONEY) || type.equals(Payments.YANDEXMONEY)) {
            fieldBalance.click();
            radioButton.get(position).click();
            fieldAmount.setValue("100");
            agreement.click();
            selectButtonPay(type);
            sleep(2000);
            buttonPay.click();
            return new MainPageAdvertiser();
        }
        return null;
    }

    public void checkOpenPaymentPage(String expectedResult, Payments type) {
        if (type.equals(Payments.BANKCARD)) {
            payResultCard.shouldHave(Condition.text(expectedResult));
        }
        if (type.equals(Payments.WEBMONEY)) {
            sleep(5000);
            payResultWebMoney.shouldHave(Condition.text(expectedResult));
        }
        if (type.equals(Payments.YANDEXMONEY)) {
            payResultCard.shouldHave(Condition.text(expectedResult));
        }
    }
}
