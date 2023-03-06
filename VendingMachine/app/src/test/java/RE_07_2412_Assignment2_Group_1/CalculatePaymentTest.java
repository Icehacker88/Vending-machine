package RE_07_2412_Assignment2_Group_1;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatePaymentTest {
    

    @Test 
    void testaskCashInput() throws SQLException{
        // Connection conn;
        // Database d = new Database();
        // conn = d.getConn();
        CalculatePayment c = new CalculatePayment();
        String userInput = ("1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1");
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        //assertEquals(188.85, c.ask_cashInput()); 
        //conn.close();
  
        
    }

    @Test
    void Calculate_PaymentTest() throws NumberFormatException, SQLException{
        Connection conn;
        Database d = new Database();
        ArrayList<Integer> result_list = new ArrayList<>();
        
        CalculatePayment c = new CalculatePayment();
        d.connect();
        conn = d.getConn();
        result_list = c.Calculate_Payment("smiths", 15, conn, d);
        assertEquals(result_list, c.Calculate_Payment("smiths", 15, conn, d));
        result_list = c.Calculate_Payment("smiths", 20, conn, d);
        assertEquals(result_list, c.Calculate_Payment("smiths", 20, conn, d));
        result_list = c.Calculate_Payment("smiths", 10000, conn, d);
        assertEquals(result_list, c.Calculate_Payment("smiths", 10000, conn, d));
        result_list = c.Calculate_Payment("smiths", 1, conn, d);
        assertEquals(result_list, c.Calculate_Payment("smiths", 1, conn, d));
        result_list = c.Calculate_Payment("smiths", 38.85, conn, d);
        assertEquals(result_list, c.Calculate_Payment("smiths", 38.85, conn, d));
        conn.close();

    }

    @Test
    void reduce_number_databasetest() throws SQLException{
        Connection conn;
        Database d = new Database();
        ArrayList<Integer> result_list = new ArrayList<>();
        result_list.add(0);
        result_list.add(0);
        result_list.add(0);
        result_list.add(0);
        result_list.add(0);
        result_list.add(0);
        result_list.add(0);
        result_list.add(0);
        result_list.add(0);
        
        CalculatePayment c = new CalculatePayment();
        d.connect();
        conn = d.getConn();
        assertEquals(true, c.reduce_number_database(result_list, conn, d)); 
        conn.close();
    }


    
    
}
