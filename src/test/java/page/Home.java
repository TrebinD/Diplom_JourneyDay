package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Home {

    private SelenideElement payment = $x("//button[@role =\"button\"]//*[text() = \"Купить\"]");
    private SelenideElement creditRequest = $x("//button[@role =\"button\"]//*[text() = \"Купить в кредит\"]");

    public PaymentEntity payment() {
        payment.click();
        return new PaymentEntity();
    }

    public CreditRequestEntity creditRequest() {
        creditRequest.click();
        return new CreditRequestEntity();
    }
}
