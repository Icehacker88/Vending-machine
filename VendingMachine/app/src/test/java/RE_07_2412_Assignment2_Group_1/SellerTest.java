package RE_07_2412_Assignment2_Group_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class SellerTest {

    @Test
    void testaddSeller() throws SQLException {
        Connection conn;
        Database data = new Database();
        Seller seller = new Seller();
        data.connect();
        conn = data.getConn();
        seller.addSeller(data, conn);
        assertEquals(true, seller.getflag());
        conn.close();
    }

    @Test
    void testaddP() throws SQLException {
        Connection conn;
        Database data = new Database();
        Seller seller = new Seller();
        data.connect();
        conn = data.getConn();     
        // String productcode = "005";
        // String productname = "cola";
        // String producttype = "drinks";
        // String productnumber = "5";
        // String productprice = "20";
        seller.addP("005", "cola", "drinks", "5", "20", data, conn);
        assertEquals(true, seller.getflag());
        conn.close();
    }

    @Test
    void testaddPfail() throws SQLException {
        Connection conn;
        Database data = new Database();
        Seller seller = new Seller();
        data.connect();
        conn = data.getConn();   
        // String productcode = "005";
        // String productname = "cola";
        // String producttype = "drinks";
        // String productnumber = "25";
        // String productprice = "20";
        seller.addP("005", "cola", "drinks", "25", "20", data, conn);
        assertEquals(false, seller.getflag());
        conn.close();
    }

    @Test
    void testaddToSold() throws SQLException {
        Connection conn;
        Database data = new Database();
        Seller seller = new Seller();
        data.connect();
        conn = data.getConn();
        seller.addToSold("005", "Coca cola", "drinks", "0", "7", "10", data, conn);
        assertEquals(true, seller.getflag());
        conn.close();
    }

    @Test
    void testaddToSoldfail() throws SQLException {
        Connection conn;
        Database data = new Database();
        Seller seller = new Seller();
        data.connect();
        conn = data.getConn();
        seller.addToSold("006", "Pepsi", "chips", "0", "7", "10", data, conn);
        assertEquals(false, seller.getflag());
        conn.close();
    }

    @Test
    void testgetCurrentAvailable() throws SQLException, IOException {
        Connection conn;
        Database data = new Database();
        Seller seller = new Seller();
        data.connect();
        conn = data.getConn();
        seller.getCurrentAvailable(data, conn);
        assertEquals(true, seller.getflag());
        conn.close();
    }

    @Test
    void testgetSoldReport() throws SQLException, IOException {
        Connection conn;
        Database data = new Database();
        Seller seller = new Seller();
        data.connect();
        conn = data.getConn();
        seller.getSoldReport(data, conn);
        assertEquals(true, seller.getflag());
        conn.close();
    }
}