package RE_07_2412_Assignment2_Group_1;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.*;
import java.util.ArrayList;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class OwnerTest {
    

    @Test
    void test_get_roles() throws SQLException{
        Connection conn;
        Database data = new Database();
        Owner ow = new Owner();
        data.connect();
        conn = data.getConn();
        ArrayList<String> ls = new ArrayList<String>();
        ls = ow.getRoles(data, conn);
        assertEquals(ow.getRoles(data,conn), ls);
        conn.close();
    }

    @Test
    void test_changeUser_add() throws SQLException{
        Connection conn;
        Database data = new Database();
        Owner ow = new Owner();
        data.connect();
        conn = data.getConn();
        String userInput = ("Add\nliuhao\nseller");
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        ow.changeUser(data,conn);
        assertEquals(2, ow.getflag());
        conn.close();
    }

    @Test
    void test_changeUser_del() throws SQLException{
        Connection conn;
        Database data = new Database();
        Owner ow = new Owner();
        data.connect();
        conn = data.getConn();
        String userInput = ("Delete\nliuhao\nseller");
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        ow.changeUser(data,conn);
        assertEquals(3, ow.getflag());
        conn.close();
    }

    @Test
    void test_modifyChanges_valid() throws SQLException{
        Connection conn;
        Database data = new Database();
        Owner ow = new Owner();
        data.connect();
        conn = data.getConn();
        String userInput = ("50cent\n5");
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        ow.modifyChanges(data,conn);
        assertEquals(4, ow.getflag());
        conn.close();
    }

    @Test
    void test_modifyChanges_invalid() throws SQLException{
        Connection conn;
        Database data = new Database();
        Owner ow = new Owner();
        data.connect();
        conn = data.getConn();
        String userInput = ("50cent\n100");
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        ow.modifyChanges(data,conn);
        assertEquals(4, ow.getflag());
        conn.close();
    }

    @Test
    void test_modifyProduct() throws SQLException{
        Connection conn;
        Database data = new Database();
        Owner ow = new Owner();
        data.connect();
        conn = data.getConn();
        String userInput = ("001\nmilk\ndrinks\n3\n6");
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        ow.modifyProduct(data,conn);
        assertEquals(5, ow.getflag());
        conn.close();
    }

    @Test
    void test_getCanceltranscript() throws SQLException{
        Connection conn;
        Database data = new Database();
        Owner ow = new Owner();
        data.connect();
        conn = data.getConn();
        ArrayList<String> ls = new ArrayList<String>();
        ls.add("abc");
        ls.add("2022-10-25 10:24:15");
        ls.add("customer canceled");
        assertEquals(ow.getCanceltranscript(data,conn), ls);
        conn.close();
    }
}
