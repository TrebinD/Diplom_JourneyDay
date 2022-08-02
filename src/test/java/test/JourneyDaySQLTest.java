package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.Info;
import helper.SqlHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import page.Home;
import page.PaymentEntity;

import static com.codeborne.selenide.Selenide.open;
import static helper.DataHelper.validInfo;

public class JourneyDaySQLTest {
    Info data;
    Home home;

    @BeforeEach
    public void connect() {
        open("http://localhost:8080/");
        data = validInfo();
        home = new Home();
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll(){
        SelenideLogger.removeListener("allure");
    }

        @Test
    @DisplayName("APPROVED status by payment")
    public void paymentApprovedStatus() {
        home.payment();
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.inputAllInfo(0, data.getMonth(), data.getYear(), data.getName(), data.getCvc());
        paymentEntity.sendTrue();
        SqlHelper sqlHelper = new SqlHelper();
        sqlHelper.assertStatusPaymentApproved();
    }

    @Test
    @DisplayName("DECLINED status by payment")
    public void paymentDeclinedStatus() {
        home.payment();
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.inputAllInfo(1, data.getMonth(), data.getYear(), data.getName(), data.getCvc());
        paymentEntity.sendTrue();
        SqlHelper sqlHelper = new SqlHelper();
        sqlHelper.assertStatusPaymentDeclined();
    }

    @Test
    @DisplayName("APPROVED status by Credit Payment")
    public void creditPaymentApprovedStatus() {
        home.payment();
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.inputAllInfo(0, data.getMonth(), data.getYear(), data.getName(), data.getCvc());
        paymentEntity.sendTrue();
        SqlHelper sqlHelper = new SqlHelper();
        sqlHelper.assertStatusCreditApproved();
    }

    @Test
    @DisplayName("DECLINED status by Credit Payment")
    public void creditPaymentDeclinedStatus() {
        home.payment();
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.inputAllInfo(1, data.getMonth(), data.getYear(), data.getName(), data.getCvc());
        paymentEntity.sendTrue();
        SqlHelper sqlHelper = new SqlHelper();
        sqlHelper.assertStatusCreditDeclined();
    }

}


