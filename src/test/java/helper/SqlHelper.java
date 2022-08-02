package helper;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SqlHelper {
    private static QueryRunner queryRunner;
    private static Connection connection;

    @SneakyThrows
    public static void setupSQL() {
        queryRunner = new QueryRunner();
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }

//    @SneakyThrows
//    public static void setupSQL() {
//        queryRunner = new QueryRunner();
//        connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/test", "app", "pass");
//    }

    @SneakyThrows
    public static  String getIdPayment(){
        setupSQL();
        var data = "SELECT payment_id FROM order_entity ORDER BY created DESC limit 1";
        return queryRunner.query(connection,data,new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getIdCreditPayment(){
        setupSQL();
        var data = "SELECT credit_id FROM order_entity ORDER BY created DESC limit 1";
        return queryRunner.query(connection,data,new ScalarHandler<>());
    }

    @SneakyThrows
    public static   String getPaymentStatus(String paymentId){
        setupSQL();
        var data = "SELECT status FROM payment_entity WHERE transaction_id = ?";
        return queryRunner.query(connection,data,new ScalarHandler<>(),paymentId);
    }

    @SneakyThrows
    public static  String getCreditPaymentStatus(String paymentId){
        setupSQL();
        var data = "SELECT status FROM credit_request_entity WHERE bank_id = ?";
        return queryRunner.query(connection,data,new ScalarHandler<>(),paymentId);
    }

    public static void assertStatusPaymentApproved(){
        String id = SqlHelper.getIdPayment();
        String actual = SqlHelper.getPaymentStatus(id);
        String expected = "APPROVED";
        assertEquals(expected,actual);
    }

    public void assertStatusPaymentDeclined(){
        String id = SqlHelper.getIdPayment();
        String actual = SqlHelper.getPaymentStatus(id);
        String expected = "DECLINED";
        assertEquals(expected,actual);
    }

    public void assertStatusCreditApproved(){
        String id = SqlHelper.getIdCreditPayment();
        String actual = SqlHelper.getCreditPaymentStatus(id);
        String expected = "APPROVED";
        assertEquals(expected,actual);
    }

    public void assertStatusCreditDeclined(){
        String id = SqlHelper.getIdCreditPayment();
        String actual = SqlHelper.getCreditPaymentStatus(id);
        String expected = "DECLINED";
        assertEquals(expected,actual);
    }

}
