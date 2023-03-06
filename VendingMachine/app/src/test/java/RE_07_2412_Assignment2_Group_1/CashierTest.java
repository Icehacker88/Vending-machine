package RE_07_2412_Assignment2_Group_1;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class CashierTest {
    @Test
    void displayChangetest() throws SQLException{
        Connection conn;
        Database data = new Database();
        Cashier cas = new Cashier();
        data.connect();
        conn = data.getConn();
        cas.displayChange();
    }

    @Test
    void getTransactionHistoyrtest() throws SQLException{
        Connection conn;
        Database data = new Database();
        Cashier cas = new Cashier();
        data.connect();
        conn = data.getConn();
        cas.getTransactionHistoyr();
    }
}
