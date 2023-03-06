package RE_07_2412_Assignment2_Group_1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class CustomerTest {
    @Test
    void canceltest() throws SQLException{
        Connection conn;
        Database data = new Database();
        Customer cus = new Customer();
        data.connect();
        conn = data.getConn();
        String userInput = ("cancel");
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        cus.cancelaccept(data, conn);
        assertTrue(cus.getflag());
        conn.close();
    }

    @Test
    void choosetest() throws SQLException{
        Connection conn;
        Database data = new Database();
        Customer cus = new Customer();
        data.connect();
        conn = data.getConn();
        String userInput = ("Wrong payment!");
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        cus.choosePayment(conn, data);
        assertTrue(cus.getflag());
        conn.close();
    }

    @Test
    void buydrinksTest() throws SQLException, IOException{
        Connection conn;
        Database data = new Database();
        Customer cus = new Customer();
        data.connect();
        conn = data.getConn();
        String userInput = ("drinks\nmilk\n2");
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        
        assertEquals("drinks", cus.buyProduct("drinks",data, conn));
        assertTrue(cus.getflag());
        conn.close();
    }

    @Test
    void buychocolatesTest() throws SQLException, IOException{
        Connection conn;
        Database data = new Database();
        Customer cus = new Customer();
        data.connect();
        conn = data.getConn();
        String userInput = ("chocolates\nmilk chocolate");
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        assertEquals("chocolates", cus.buyProduct("chocolates",data, conn));
        assertTrue(cus.getflag());
        conn.close();
    }

    @Test
    void buydcandieTest() throws SQLException, IOException{
        Connection conn;
        Database data = new Database();
        Customer cus = new Customer();
        data.connect();
        conn = data.getConn();
        String userInput = ("candies\nmentos");
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        assertEquals("candies", cus.buyProduct("candies",data, conn));
        assertTrue(cus.getflag());
        conn.close();
    }

    @Test
    void buycihpsTest() throws SQLException, IOException{
        Connection conn;
        Database data = new Database();
        Customer cus = new Customer();
        data.connect();
        conn = data.getConn();
        String userInput = ("chips\nsmiths");
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        assertEquals("chips", cus.buyProduct("chips",data, conn));
        assertTrue(cus.getflag());
        conn.close();
    }
}
