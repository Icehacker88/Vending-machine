package RE_07_2412_Assignment2_Group_1;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.*;


public class DatabaseTest {


    @Test
    void testConnection() throws SQLException{
        Database db = new Database();

        assertFalse(db.getflag1());
        db.connect();
        Connection conn = db.getConn();
        assertTrue(db.getflag1());
        conn.close();
    }

    @Test
    void testCreateTableTest() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db.getConn();
        assertFalse(db.getflag());
        db.createTable(conn);
        assertTrue(db.getflag());
        conn.close();
    }

    @Test
    void testCreatetableCash() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db.getConn();
        assertFalse(db.getflag());
        db.createTablecash(conn);
        assertTrue(db.getflag());
        conn.close();

    }

    @Test 
    void testCreatetableUser() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db. getConn();
        assertFalse(db.getflag());
        db.createTableuser(conn);
        assertTrue(db.getflag());
        conn.close();
    }

    @Test 
    void testCreatetableTranscriptsummary() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db. getConn();
        assertFalse(db.getflag());
        db.createTableTransactionSumary(conn);
        assertTrue(db.getflag());
        conn.close();
    }

    @Test 
    void testCreatetableCancel() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db. getConn();
        assertFalse(db.getflag());
        db.createTablecancel(conn);
        assertTrue(db.getflag());
        conn.close();
    }

    @Test 
    void testCreatetableCurrentuser() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db. getConn();
        assertFalse(db.getflag());
        db.createTablecurrentuser(conn);
        assertTrue(db.getflag());
        conn.close();
    }

    @Test 
    void testCreatetableSold() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db. getConn();
        assertFalse(db.getflag());
        db.createTableSold(conn);
        assertTrue(db.getflag());
        conn.close();
    }

    @Test
    void test_addSold() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn =db.getConn();
        assertFalse(db.getflag());
        db.addSold(conn, "002", "milk","1");
        assertTrue(db.getflag());
        conn.close();
    }

    @Test
    void test_addcancel() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn =db.getConn();
        assertFalse(db.getflag());
        db.addCancel(conn, "abc", "2022-10-25 10:24:15","customer canceled");
        assertTrue(db.getflag());
        conn.close();
    }

    @Test
    void test_addcurrentuser() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn =db.getConn();
        assertFalse(db.getflag());
        db.addCurrentUser(conn, "abc");
        assertTrue(db.getflag());
        conn.close();
    }

    @Test
    void test_getCurrentUser() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn =db.getConn();
        assertFalse(db.getflag());
        db.getCurrentUser();
        assertTrue(db.getflag());
        conn.close();
    }

    @Test
    void test_getcancel() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn =db.getConn();
        assertFalse(db.getflag());
        db.getcancel();
        assertTrue(db.getflag());
        conn.close();
    }

    @Test
    void test_getSold() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn =db.getConn();
        assertFalse(db.getflag());
        db.getSold();
        assertTrue(db.getflag());
        conn.close();
    }

    @Test
    void modifyProduct() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn =db.getConn();
        assertFalse(db.getflag());
        db.addProduct(conn, "milk", "001","drink","5", "10");
        assertTrue(db.getflag());
        conn.close();
    }

    @Test
    void test_addcash() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn =db.getConn();
        assertFalse(db.getflag());
        db.addCash(conn,"10cent","10");
        assertTrue(db.getflag());
        conn.close();
    }

    @Test
    void test_addInituser() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn =db.getConn();
        assertFalse(db.getflag());
        db.addInituser(conn,"1156","customer","123");
        assertTrue(db.getflag());
        conn.close();
    }

    @Test
    void test_getusertype() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn =db.getConn();
        assertFalse(db.getflag());
        db.getUsertype("1156","123");
        assertTrue(db.getflag());
        conn.close();
    }

    @Test
    void test_addCash_exist_valid() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn =db.getConn();
        assertFalse(db.getflag());
        db.addCash_exist(conn,"10cent","5");
        assertTrue(db.getflag());
        conn.close();
    }

    @Test
    void test_addCash_exist_invalid() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn =db.getConn();
        assertFalse(db.getflag());
        db.addCash_exist(conn,"10cent","500");
        assertTrue(db.getflag());
        conn.close();
    }
    
    @Test
    void checkexistanceusertest() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db.getConn();
        assertFalse(db.getflag());
        db.checkexistanceuser("a");
        assertTrue(db.getflag());
        conn.close();
    }
    @Test
        void test_checkexistanceusertype() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db.getConn();
        assertFalse(db.getflag());
        db.checkexistanceusertype("customer");
        assertTrue(db.getflag());
        conn.close();
    }
    @Test
    void checkexistancevaliduserTestvalid() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db.getConn();
        assertFalse(db.getflag());
        db.checkexistancevaliduser("SicongLiu","123");
        assertTrue(db.getflag());
        conn.close();
    }
    @Test
        void checkexistancevaliduserTestInvalid() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db.getConn();
        assertFalse(db.getflag());
        db.checkexistancevaliduser("a","a");
        assertTrue(db.getflag());
        conn.close();
        }
    @Test
        void test_adduser() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db.getConn();
        assertFalse(db.getflag());
        db.addUser(conn,"1156","customer","123");
        assertTrue(db.getflag());
        conn.close();
    }
    @Test
        void checkGetproductResult() throws SQLException{
            Database db = new Database();
            db.connect();
            Connection conn = db.getConn();
            assertFalse(db.getflag());
            db.getProductData();
            assertTrue(db.getflag());
            conn.close();
        }
    @Test
        void testadduserINVALID() throws SQLException{
            Database db = new Database();
            db.connect();
            Connection conn = db.getConn();
            assertFalse(db.getflag());
            db.addUser(conn,"SicongLiu","customer","123");
            assertTrue(db.getflag());
            conn.close();
        }
    @Test
    void testadduserVALID() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db.getConn();
        assertFalse(db.getflag());
        db.addUser(conn,"abc","customer","123");
        assertTrue(db.getflag());
        conn.close();
    }

    @Test
    void getproductnumber() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db.getConn();
        assertFalse(db.getflag());
        db.getProductNumber("milk");
        assertTrue(db.getflag());
        conn.close();
    }
    @Test
    void test_getcashData() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db.getConn();
        assertFalse(db.getflag());
        db.getcashData();
        assertTrue(db.getflag());
        conn.close();
    }
    @Test
    void test_getuserData() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db.getConn();
        assertFalse(db.getflag());
        db.getUserData();
        assertTrue(db.getflag());
        conn.close();
    }
    @Test
    void test_addUserType() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db.getConn();
        assertFalse(db.getflag());
        db.addUserType(conn,"1156","customer");
        assertTrue(db.getflag());
        conn.close();
    }
    @Test
    void test_addTransaction() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db.getConn();
        assertFalse(db.getflag());
        db.addTransaction(conn,"2022-10-25","milk","20.0","10.0","card");
        assertTrue(db.getflag());
        conn.close();
    }
    @Test
    void test_getTransactionSummary() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db.getConn();
        assertFalse(db.getflag());
        db.getTransactionSummary();
        assertTrue(db.getflag());
        conn.close();
    }
    @Test
    void test_delusertype() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db.getConn();
        assertFalse(db.getflag());
        db.delUserType(conn,"1156");
        assertTrue(db.getflag());
        conn.close();
    }
    @Test
    void test_getpnumber() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db.getConn();
        assertFalse(db.getflag());
        db.getProductNumber("milk");
        assertTrue(db.getflag());
        conn.close();
    }
    @Test
    void test_getpprice() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db.getConn();
        assertFalse(db.getflag());
        db.getProductprice("milk");
        assertTrue(db.getflag());
        conn.close();
    }
    @Test
    void test_getcnumber() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db.getConn();
        assertFalse(db.getflag());
        db.getCashnumber("10cent");
        assertTrue(db.getflag());
        conn.close();
    }
    @Test
    void test_getSoldNumber() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db.getConn();
        assertFalse(db.getflag());
        db.getSoldNumber("milk");
        assertTrue(db.getflag());
        conn.close();
    }
    @Test
    void test_getSoldCode() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db.getConn();
        assertFalse(db.getflag());
        db.getSoldCode("milk");
        assertTrue(db.getflag());
        conn.close();
    }
    @Test
    void test_checkcash() throws SQLException{
        Database db = new Database();
        db.connect();
        Connection conn = db.getConn();
        assertFalse(db.getflag());
        db.checkcash("10cent","20");
        assertTrue(db.getflag());
        conn.close();
    }
}

