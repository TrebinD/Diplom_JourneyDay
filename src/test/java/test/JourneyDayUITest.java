package test;

import data.Info;
import helper.DataHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.CreditRequestEntity;
import page.Home;
import page.PaymentEntity;

import static com.codeborne.selenide.Selenide.open;
import static helper.DataHelper.validInfo;

public class JourneyDayUITest {

    Info data;
    Home home;

    @BeforeEach
    public void connect() {
        open("http://localhost:8080/");
        data = validInfo();
        home = new Home();
    }

    @Test
    @DisplayName("Sending a form with valid data page Payment")
    public void inputValidInfo() {
        home.payment();
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.inputAllInfo(0, data.getMonth(), data.getYear(), data.getName(), data.getCvc());
        paymentEntity.sendTrue();
    }

    @Test
    @DisplayName("Sending a form with DECLINED card page Payment")
    public void inputDeclinedCard() {
        home.payment();
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.inputAllInfo(1, data.getMonth(),data.getYear(), data.getName(), data.getCvc());
        paymentEntity.sendFalse();
    }

    @Test
    @DisplayName("Sending empty form page Payment")
    public void emptyInfo() {
        home.payment();
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.emptyField();
    }

    @Test
    @DisplayName("Sending form with empty month page Payment")
    public void emptyMonth() {
        home.payment();
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.inputAllInfo(0, null, data.getYear(), data.getName(), data.getCvc());
        paymentEntity.emptyMonth();
    }

    @Test
    @DisplayName("Sending form with empty year page Payment")
    public void emptyYear() {
        home.payment();
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.inputAllInfo(0, data.getMonth(), null, data.getName(), data.getCvc());
        paymentEntity.emptyYear();
    }

    @Test
    @DisplayName("Sending form with empty Owner page Payment")
    public void emptyOwner() {
        home.payment();
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.inputAllInfo(0, data.getMonth(), data.getYear(), null, data.getCvc());
        paymentEntity.emptyOwner();
    }

    @Test
    @DisplayName("Sending form with empty CVC page Payment")
    public void emptyCVC() {
        home.payment();
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.inputAllInfo(0, data.getMonth(), data.getYear(), data.getName(), null);
        paymentEntity.emptyCVC();
    }

    @Test
    @DisplayName("Sending form with empty card number page Payment")
    public void emptyNumberCard() {
        home.payment();
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.inputAllInfo(3, data.getMonth(), data.getYear(), data.getName(), data.getCvc());
        paymentEntity.wrongNumberCard();
    }

    @Test
    @DisplayName("Sending form with short card number page Payment")
    public void shortCardNumber() {
        home.payment();
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.inputAllInfo(2, data.getMonth(), data.getYear(), data.getName(), data.getCvc());
        paymentEntity.wrongNumberCard();
    }

    @Test
    @DisplayName("Sending form with wrong month page Payment")
    public void wrongMonth() {
        home.payment();
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.inputAllInfo(0, DataHelper.nonValidMonth(),data.getYear(), data.getName(), data.getCvc());
        paymentEntity.wrongMonth();
    }

    @Test
    @DisplayName("Sending form with wrong year page Payment")
    public void wrongYear() {
        home.payment();
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.inputAllInfo(0, data.getMonth(), DataHelper.notValidYear(), data.getName(), data.getCvc());
        paymentEntity.wrongYear();
    }

    @Test
    @DisplayName("Sending form name with dash page Payment")
    public void nameWithDash() {
        home.payment();
        String name = "Orlov-Lvovsky Kirill";
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.inputAllInfo(0, data.getMonth(), data.getYear(), name, data.getCvc());
        paymentEntity.sendTrue();
    }

    @Test
    @DisplayName("Sending form name on Cyrillic page Payment")
    public void nameCyrillik() {
        home.payment();
        String name = "Петров Иван";
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.inputAllInfo(0, data.getMonth(), data.getYear(), name, data.getCvc());
        paymentEntity.wrongOwner();
    }

    @Test
    @DisplayName("Sending form name with number page Payment")
    public void nameWithNumber() {
        home.payment();
        String name = "Petrov123";
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.inputAllInfo(0, data.getMonth(), data.getYear(), name, data.getCvc());
        paymentEntity.wrongOwner();
    }

    @Test
    @DisplayName("Sending a form with valid data page Credit")
    public void inputValidInfoCredit() {
        home.creditRequest();
        CreditRequestEntity creditRequest = new CreditRequestEntity();
        creditRequest.inputAllInfo(0, data.getMonth(), data.getYear(), data.getName(), data.getCvc());
        creditRequest.sendTrue();
    }

    @Test
    @DisplayName("Sending a form with DECLINED card page Credit")
    public void inputDeclinedCardCredit() {
        home.creditRequest();
        CreditRequestEntity creditRequest = new CreditRequestEntity();
        creditRequest.inputAllInfo(1, data.getMonth(), data.getYear(), data.getName(), data.getCvc());
        creditRequest.sendFalse();
    }

    @Test
    @DisplayName("Sending empty form page Credit")
    public void emptyInfoCredit() {
        home.creditRequest();
        CreditRequestEntity creditRequest = new CreditRequestEntity();
        creditRequest.emptyField();
    }

    @Test
    @DisplayName("Sending form with empty month page Credit")
    public void emptyMonthCredit() {
        home.creditRequest();
        CreditRequestEntity creditRequest = new CreditRequestEntity();
        creditRequest.inputAllInfo(0, null, data.getYear(), data.getName(), data.getCvc());
        creditRequest.emptyMonth();
    }

    @Test
    @DisplayName("Sending form with empty year page Credit")
    public void emptyYearCredit() {
        home.creditRequest();
        CreditRequestEntity creditRequest = new CreditRequestEntity();
        creditRequest.inputAllInfo(0, data.getMonth(), null, data.getName(), data.getCvc());
        creditRequest.emptyYear();
    }

    @Test
    @DisplayName("Sending form with empty Owner page Credit")
    public void emptyOwnerCredit() {
        home.creditRequest();
        CreditRequestEntity creditRequest = new CreditRequestEntity();
        creditRequest.inputAllInfo(0, data.getMonth(), data.getYear(), null, data.getCvc());
        creditRequest.emptyOwner();
    }

    @Test
    @DisplayName("Sending form with empty CVC page Credit")
    public void emptyCVCCredit() {
        home.creditRequest();
        CreditRequestEntity creditRequest = new CreditRequestEntity();
        creditRequest.inputAllInfo(0, data.getMonth(), data.getYear(), data.getName(), null);
        creditRequest.emptyCVC();
    }

    @Test
    @DisplayName("Sending form with empty card number page Credit")
    public void emptyNumberCardCredit() {
        home.creditRequest();
        CreditRequestEntity creditRequest = new CreditRequestEntity();
        creditRequest.inputAllInfo(3, data.getMonth(), data.getYear(), data.getName(), data.getCvc());
        creditRequest.wrongNumberCard();
    }

    @Test
    @DisplayName("Sending form with short card number page Credit")
    public void shortCardNumberCredit() {
        home.creditRequest();
        CreditRequestEntity creditRequest = new CreditRequestEntity();
        creditRequest.inputAllInfo(2, data.getMonth(), data.getYear(), data.getName(), data.getCvc());
        creditRequest.wrongNumberCard();
    }

    @Test
    @DisplayName("Sending form with wrong month page Credit")
    public void wrongMonthCredit() {
        home.creditRequest();
        CreditRequestEntity creditRequest = new CreditRequestEntity();
        creditRequest.inputAllInfo(0, DataHelper.nonValidMonth(), data.getYear(), data.getName(), data.getCvc());
        creditRequest.wrongMonth();
    }

    @Test
    @DisplayName("Sending form with wrong year page Credit")
    public void wrongYearCredit() {
        home.creditRequest();
        CreditRequestEntity creditRequest = new CreditRequestEntity();
        creditRequest.inputAllInfo(0, data.getMonth(), DataHelper.notValidYear(), data.getName(), data.getCvc());
        creditRequest.wrongYear();
    }

    @Test
    @DisplayName("Sending form name with dash page Credit")
    public void nameWithDashCredit() {
        home.creditRequest();
        String name = "Orlov-Lvovsky Kirill";
        CreditRequestEntity creditRequest = new CreditRequestEntity();
        creditRequest.inputAllInfo(0, data.getMonth(), data.getYear(), name, data.getCvc());
        creditRequest.sendTrue();
    }

    @Test
    @DisplayName("Sending form name on Cyrillic page Credit")
    public void nameCyrillikCredit() {
        home.creditRequest();
        String name = "Петров Иван";
        CreditRequestEntity creditRequest = new CreditRequestEntity();
        creditRequest.inputAllInfo(0, data.getMonth(), data.getYear(), name, data.getCvc());
        creditRequest.wrongOwner();
    }

    @Test
    @DisplayName("Sending form name with number page Credit")
    public void nameWithNumberCredit() {
        home.creditRequest();
        String name = "Petrov123";
        CreditRequestEntity creditRequest = new CreditRequestEntity();
        creditRequest.inputAllInfo(0, data.getMonth(), data.getYear(), name, data.getCvc());
        creditRequest.wrongOwner();
    }



}
