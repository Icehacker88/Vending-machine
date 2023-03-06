package RE_07_2412_Assignment2_Group_1;

import java.sql.Connection;
import java.sql.SQLException;

public class Cashier {
    private static Connection conn;
    private static Database data = new Database();

    public String displayChange() throws SQLException{
        data.connect();
        return data.getcashData();

    }
    public String getTransactionHistoyr() throws SQLException{
        data.connect();
        return data.getTransactionSummary();
    }
}
