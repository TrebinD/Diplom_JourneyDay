package page;

import com.codeborne.selenide.SelenideElement;
import helper.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class PaymentEntity {
    private SelenideElement inputNumberCard = $x("//input[@placeholder=\"0000 0000 0000 0000\"]");
    private SelenideElement inputMonth = $x("//input[@placeholder=\"08\"]");
    private SelenideElement inputYear = $x("//input[@placeholder=\"22\"]");
    private SelenideElement inputOwner = $x("//*[@id=\"root\"]/div/form/fieldset/div[3]/span/span[1]/span/span/span[2]/input");
    private SelenideElement inputCVC = $x("//input[@placeholder=\"999\"]");
    private SelenideElement button = $x("//button[@role=\"button\"]//*[text()=\"Продолжить\"]");
    private SelenideElement errorNumberCard = $x("//*[@id=\"root\"]/div/form/fieldset/div[1]/span/span/span[3]");
    private SelenideElement errorMonth = $x("//*[@id=\"root\"]/div/form/fieldset/div[2]/span/span[1]/span/span/span[3]");
    private SelenideElement errorYear = $x("//*[@id=\"root\"]/div/form/fieldset/div[2]/span/span[2]/span/span/span[3]");
    private SelenideElement errorOwner = $x("//*[@id=\"root\"]/div/form/fieldset/div[3]/span/span[1]/span/span/span[3]");
    private SelenideElement errorCVC = $x("//*[@id=\"root\"]/div/form/fieldset/div[3]/span/span[2]/span/span/span[3]");
    private SelenideElement iconWaitSend = $x("//*[@id=\"root\"]/div/form/fieldset/div[4]/button/span/span/span");
    private SelenideElement messageWaitSend = $x("//*[text()=\"Отправляем запрос в Банк...\"]");
    private SelenideElement messageApproved = $x("//div[@class = \"notification notification_visible notification_status_ok notification_has-closer notification_stick-to_right notification_theme_alfa-on-white\"]//div[@class = \"notification__content\"]");
    private SelenideElement buttonCloseMessageApproved = $x("//*[@id=\"root\"]/div/div[2]/button/span/span");
    private SelenideElement messageDeclined = $x("//*[@id=\"root\"]/div/div[3]/div[3]");
    private SelenideElement buttonCloseDeclined = $x("//*[@id=\"root\"]/div/div[3]/button");


    public void inputAllInfo(int numberCard, String month, String year, String ownerName, String cvc) {
        inputNumberCard.val(DataHelper.numberCards(numberCard));
        inputMonth.val(String.valueOf(month));
        inputYear.val(String.valueOf(year));
        inputOwner.val(ownerName);
        inputCVC.val(String.valueOf(cvc));
        button.click();
    }

    public void sendTrue() {
        errorNumberCard.should(hidden);
        errorMonth.should(hidden);
        errorYear.should(hidden);
        errorOwner.should(hidden);
        errorCVC.should(hidden);
        iconWaitSend.should(visible);
        messageWaitSend.should(text("Отправляем запрос в Банк..."));
        messageApproved.should(text("Операция одобрена Банком."), Duration.ofSeconds(15));
        buttonCloseMessageApproved.click();
    }

    public void sendFalse() {
        errorNumberCard.should(hidden);
        errorMonth.should(hidden);
        errorYear.should(hidden);
        errorOwner.should(hidden);
        errorCVC.should(hidden);
        iconWaitSend.should(visible);
        messageWaitSend.should(text("Отправляем запрос в Банк..."));
        messageDeclined.should(text("Ошибка! Банк отказал в проведении операции."));
        buttonCloseDeclined.click();
    }

    public void emptyField() {
        button.click();
        errorNumberCard.should(visible);
        errorMonth.should(visible);
        errorYear.should(visible);
        errorOwner.should(visible);
        errorCVC.should(visible);
    }

    public void wrongMonth() {
        errorNumberCard.should(hidden);
        errorMonth.should(visible);
        errorMonth.should(text("Неверно указан срок действия карты"));
        errorYear.should(hidden);
        errorOwner.should(hidden);
        errorCVC.should(hidden);
    }

    public void wrongYear() {
        errorNumberCard.should(hidden);
        errorMonth.should(hidden);
        errorYear.should(visible);
        errorYear.should(text("Истёк срок действия карты"));
        errorOwner.should(hidden);
        errorCVC.should(hidden);
    }

    public void emptyMonth() {
        errorNumberCard.should(hidden);
        errorMonth.should(visible);
        errorMonth.should(text("Неверный формат"));
        errorYear.should(hidden);
        errorOwner.should(hidden);
        errorCVC.should(hidden);
    }

    public void emptyYear() {
        errorNumberCard.should(hidden);
        errorMonth.should(hidden);
        errorYear.should(visible);
        errorYear.should(text("Неверный формат"));
        errorOwner.should(hidden);
        errorCVC.should(hidden);
    }

    public void emptyOwner() {
        errorNumberCard.should(hidden);
        errorMonth.should(hidden);
        errorYear.should(hidden);
        errorOwner.should(visible);
        errorOwner.should(text("Поле обязательно для заполнения"));
        errorCVC.should(hidden);
    }

    public void emptyCVC() {
        errorNumberCard.should(hidden);
        errorMonth.should(hidden);
        errorYear.should(hidden);
        errorOwner.should(hidden);
        errorCVC.should(visible);
        errorCVC.should(text("Неверный формат"));
    }

    public void wrongNumberCard() {
        errorNumberCard.should(visible);
        errorNumberCard.should(text("Неверный формат"));
        errorMonth.should(hidden);
        errorYear.should(hidden);
        errorOwner.should(hidden);
        errorCVC.should(hidden);
    }

    public void wrongOwner() {
        errorNumberCard.should(hidden);
        errorMonth.should(hidden);
        errorYear.should(hidden);
        errorOwner.should(visible);
        errorOwner.should(text("Неверный формат данных"));
        errorCVC.should(hidden);
    }


}
