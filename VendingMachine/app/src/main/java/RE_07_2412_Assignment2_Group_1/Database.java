package RE_07_2412_Assignment2_Group_1;
import java.sql.*;
import java.util.*;

public class Database {
    private Connection conn = null;
    private boolean flag = false;
    private boolean flag1 = false;
    public void connect() {
        try {
            // db parameters
            String url = "jdbc:sqlite:Product.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");
            flag1 = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }

    //test
    public Connection getConn(){
        return this.conn;
    }

    public void createTable(Connection conn) throws SQLException {
        



        String create = ""+
                "CREATE TABLE IF NOT EXISTS Product "+
                "("+
                "productcode varchar(225),"+
                "productname varchar(225),"+
                "producttype varchar(225),"+
                "productnumber varchar(225),"+
                "productprice varchar(225) "+
                
                "); "+
                "";
        Statement sa = conn.createStatement();
        sa.execute(create);
        sa.close();
        flag = true;
    }
    //test
    public void createTablecash(Connection conn) throws SQLException{
        
        String create = ""+
        "CREATE TABLE IF NOT EXISTS Cash "+
                "("+
                "cashtype varchar(225),"+
                "cashnumber varchar(255) "+
                "); "+
                "";
        Statement sa = conn.createStatement();
        sa.execute(create);
        sa.close();
        flag = true;
    }
    public void createTablecashInput(Connection conn) throws SQLException{
        
        String create = ""+
        "CREATE TABLE IF NOT EXISTS Cashinput "+
                "("+
                "cashtype varchar(225),"+
                "cashnumber varchar(255) "+
                "); "+
                "";
        Statement sa = conn.createStatement();
        sa.execute(create);
        sa.close();
        flag = true;
    }
    //test
    public void createTableuser(Connection conn) throws SQLException{
       
        String create = ""+
        "CREATE TABLE IF NOT EXISTS User "+
                "("+
                "username varchar(255), "+
                "usertype varchar(255), "+
                "userpassword varchar(255), "+
                "usertrasaction varchar(225) "+
                "); "+
                "";
        Statement sa = conn.createStatement();
        sa.execute(create);
        sa.close();
        flag = true;
    }
    public void createTableCard(Connection conn) throws SQLException{
       
        String create = ""+
        "CREATE TABLE IF NOT EXISTS Card "+
                "("+
                "cardusername varchar(255), "+
                "cardpassword varchar(255), "+
                "username varchar(225) "+
                "); "+
                "";
        Statement sa = conn.createStatement();
        sa.execute(create);
        sa.close();
        flag = true;
    }
    //test
    public void createTableTransactionSumary(Connection conn) throws SQLException{
       
        String create = ""+
        "CREATE TABLE IF NOT EXISTS Transactionsummary "+
                "("+
                "date varchar(255), "+
                "itemsold varchar(255), "+
                "moneypaid varchar(255), "+
                "returnedchange varchar(255), "+
                "paymentmethod varchar(225) "+
                "); "+
                "";
        Statement sa = conn.createStatement();
        sa.execute(create);
        sa.close();
        flag = true;
    }
    //test
    public void createTablecancel(Connection conn) throws SQLException{
       
        String create = ""+
        "CREATE TABLE IF NOT EXISTS Cancel "+
                "("+
                "username varchar(255), "+
                "date_time varchar(255), "+
                "reason varchar(225) "+
                "); "+
                "";
        Statement sa = conn.createStatement();
        sa.execute(create);
        sa.close();
        flag = true;
    }
    //test
    public void createTablecurrentuser(Connection conn) throws SQLException{
       
        String del = ""+
        "DROP TABLE IF EXISTS CurrentUser"+
                "";
        Statement sa = conn.createStatement();
        sa.execute(del);

        String create = ""+
        "CREATE TABLE IF NOT EXISTS CurrentUser "+
                "("+
                "username varchar(255)"+
                "); "+
                "";
        sa.execute(create);
        sa.close();
        flag = true;
    }
    //test
    public void createTableSold(Connection conn) throws SQLException{
        
        String create = ""+
        "CREATE TABLE IF NOT EXISTS Sold "+
                "("+
                "soldcode varchar(225),"+
                "soldname varchar(255), "+
                "soldnumber varchar(255) "+
                "); "+
                "";
        Statement sa = conn.createStatement();
        sa.execute(create);
        sa.close();
        flag = true;
    }

    public void createTableSoldname(Connection conn) throws SQLException{
        
        String create = ""+
        "CREATE TABLE IF NOT EXISTS Soldname1 "+
                "("+
                "username varchar(225),"+
                "soldname varchar(255) "+
                "); "+
                "";
        Statement sa = conn.createStatement();
        sa.execute(create);
        sa.close();
        flag = true;
    }
    //test
    public void addSold (Connection conn, String soldcode, String soldname, String soldnumber) throws SQLException {

        String del = "DELETE FROM Sold where soldname = ?";
        PreparedStatement st1 = conn.prepareStatement(del);
        st1.setString(1,soldname);
        st1.executeUpdate();
        st1.close();
        String save = "INSERT INTO Sold(soldcode, soldname, soldnumber) VALUES(?,?,?)";
        st1 = conn.prepareStatement(save);
        st1.setString(1, soldcode);
        st1.setString(2, soldname);
        st1.setString(3, soldnumber);
        st1.executeUpdate();
        st1.close();
        flag = true;
    }

    public void addSoldname (Connection conn, String username, String soldname) throws SQLException {

        String save = "INSERT INTO Soldname1(username,soldname) VALUES(?,?)";
        PreparedStatement st1 = conn.prepareStatement(save);
        st1 = conn.prepareStatement(save);
        st1.setString(1, username);
        st1.setString(2, soldname);
        st1.executeUpdate();
        st1.close();
        flag = true;
    }

    public ArrayList getSoldname(String username) throws SQLException {

        ArrayList<String> ls = new ArrayList<String>();
        String result = "select soldname from Soldname1 where username = ? order by rowid desc limit 5";
        PreparedStatement st2 = conn.prepareStatement(result);
        st2.setString(1,username);
        ResultSet rs2 = st2.executeQuery();
        while (rs2.next()) {
            ls.add(rs2.getString(1));
        }
        flag =true;
        return  ls;
    }
    
    //test
    public void addCancel(Connection conn,String username,String date_time,String reason) throws SQLException {
       
        String save = "INSERT INTO Cancel(username,date_time,reason) VALUES(?,?,?)";
        PreparedStatement st1 = conn.prepareStatement(save);
        st1.setString(1,username);
        st1.setString(2, date_time);
        st1.setString(3, reason);
        st1.executeUpdate();
        st1.close();
        flag = true;
    }
    //test
    public void addCurrentUser(Connection conn,String username) throws SQLException {
       
        String save = "INSERT INTO CurrentUser(username) VALUES(?)";
        PreparedStatement st1 = conn.prepareStatement(save);
        st1.setString(1,username);
        st1.executeUpdate();
        st1.close();
        flag = true;
    }
    //test
    public ResultSet getCurrentUser() throws SQLException{
    
        String result = "SELECT * from CurrentUser";
        PreparedStatement st1 = conn.prepareStatement(result);
        ResultSet rs = st1.executeQuery();
        flag = true;
        return rs;
    }
    //test
    public ArrayList getcancel() throws SQLException{
    
        ArrayList<String> ls = new ArrayList<String>();
        ArrayList<ArrayList> Bls = new ArrayList<ArrayList>();
        String result = "SELECT username,date_time,reason from Cancel";
        PreparedStatement st10 = conn.prepareStatement(result);
        ResultSet rs10 = st10.executeQuery();
        while(rs10.next()){
            ls.add(rs10.getString("username"));
            ls.add(rs10.getString("date_time"));
            ls.add(rs10.getString("reason"));
            
        }
        flag = true;
        return ls;
    }
    
    //test
    public ResultSet getSold() throws SQLException {
        
        String result = "SELECT * from Sold";
        PreparedStatement st1 = conn.prepareStatement(result);
        ResultSet rs = st1.executeQuery();
        flag = true;
        return rs;
    }
    //test
    public void addProduct(Connection conn, String productcode, String productname, String producttype, String productnumber, String productprice) throws SQLException {

       
        String del = "DELETE FROM Product where productcode = ?";
        // String dell = "DELETE FROM Product where productname = ?)";
        PreparedStatement st1 = conn.prepareStatement(del);
        // PreparedStatement st11 = conn.prepareStatement(dell);
        st1.setString(1,productcode);
        st1.executeUpdate();
        st1.close();
        String save = "INSERT INTO Product(productcode, productname, producttype, productnumber, productprice) VALUES(?,?,?,?,?)";
        st1 = conn.prepareStatement(save);
        st1.setString(1,productcode);
        st1.setString(2,productname);
        st1.setString(3,producttype);
        st1.setString(4,productnumber);
        st1.setString(5,productprice);
        
        st1.executeUpdate();
        st1.close();
        flag = true;
    }
    //test
    public void addCash(Connection conn,String cashtype, String cashnumber) throws SQLException {

        String del = "DELETE FROM Cash where cashtype = ?";
        PreparedStatement st1 = conn.prepareStatement(del);
        st1.setString(1,cashtype);
        st1.executeUpdate();
        st1.close();
        String save = "INSERT INTO Cash(cashtype,cashnumber) VALUES(?,?)";
        st1 = conn.prepareStatement(save);
        st1.setString(1,cashtype);
        st1.setString(2,cashnumber);
        st1.executeUpdate();
        st1.close();
        flag = true;

    }
    public void addCashinput(Connection conn,String cashtype, String cashnumber) throws SQLException {

        String del = "DELETE FROM Cashinput where cashtype = ?";
        PreparedStatement st1 = conn.prepareStatement(del);
        st1.setString(1,cashtype);
        st1.executeUpdate();
        st1.close();
        String save = "INSERT INTO Cashinput(cashtype,cashnumber) VALUES(?,?)";
        st1 = conn.prepareStatement(save);
        st1.setString(1,cashtype);
        st1.setString(2,cashnumber);
        st1.executeUpdate();
        st1.close();
        flag = true;

    }
    //text
    public void addInituser(Connection conn,String username, String usertype,String password) throws SQLException {

        String del = "Delete from User where username = 'owner1'";
        PreparedStatement st1 = conn.prepareStatement(del);
        st1.executeUpdate();
        String save = "INSERT INTO User(username,usertype,userpassword) VALUES(?,?,?)";
            st1 = conn.prepareStatement(save);
            st1.setString(1,username);
            st1.setString(2,usertype);
            st1.setString(3,password);
            st1.executeUpdate();
            st1.close();
            flag = true;

    }
    //test
    public String getUsertype(String username,String password) throws SQLException{
        String result = "SELECT usertype from User WHERE username = ? AND userpassword = ?";
        PreparedStatement st1 = conn.prepareStatement(result);
        st1.setString(1,username);
        st1.setString(2,password);
        ResultSet rs = st1.executeQuery();
        flag = true;
        return rs.getString(1);
    }
    //test
    public void addCash_exist(Connection conn,String cashtype, String cashnumber) throws SQLException {

        if(checkcash(cashtype, cashnumber) == true){
         String del = "DELETE FROM Cash where cashtype = ?";
         PreparedStatement st1 = conn.prepareStatement(del);
         st1.setString(1,cashtype);
         st1.executeUpdate();
         st1.close();
         String save = "INSERT INTO Cash(cashtype,cashnumber) VALUES(?,?)";
         st1 = conn.prepareStatement(save);
         st1.setString(1,cashtype);
         st1.setString(2,cashnumber);
         st1.executeUpdate();
         st1.close();
         flag = true;
         
        }else{
         System.out.println("Can't add "+cashnumber+ "many cash under "+cashtype);
         if(cashtype.equals("5cent")){
            System.out.println(cashtype + "maximum is 40");
        }else if(cashtype.equals("10cent")){
            System.out.println(cashtype + "maximum is 20");
        }else if(cashtype.equals("20cent")){
            System.out.println(cashtype + "maximum is 10");
        }else if(cashtype.equals("50cent")){
            System.out.println(cashtype + "maximum is 10");
        }else if(cashtype.equals("1dollar")){
            System.out.println(cashtype + "maximum is 20");
        }else if(cashtype.equals("2dollar")){
            System.out.println(cashtype + "maximum is 25");
        }else if(cashtype.equals("5dollar")){
            System.out.println(cashtype + "maximum is 10");
        }else if(cashtype.equals("10dollar")){
            System.out.println(cashtype + "maximum is 10");
        }else if(cashtype.equals("20dollar")){
            System.out.println(cashtype + "maximum is 10");
        }
         flag = true;
        }
 
     }
    //test
    public Integer checkexistanceuser(String username) throws SQLException{
        
        String check = "SELECT EXISTS(SELECT 1 FROM User WHERE username =?)";
        PreparedStatement st1 = conn.prepareStatement(check);
        st1.setString(1,username);
        ResultSet rs = st1.executeQuery();
        flag = true;
        return rs.getInt(1);
       
    }
    //test
    public Integer checkexistanceusertype(String usertype) throws SQLException{
        
        String check = "SELECT EXISTS(SELECT 1 FROM User WHERE usertype =?)";
        PreparedStatement st1 = conn.prepareStatement(check);
        st1.setString(1,usertype);
        ResultSet rs = st1.executeQuery();
        flag = true;
        return rs.getInt(1);
       
    }
    public Integer checkcardnmae(String cardname, String cardpassword) throws SQLException{
        
        String check = "SELECT EXISTS(SELECT 1 FROM Card WHERE cardusername =? and cardpassword =?)";
        PreparedStatement st1 = conn.prepareStatement(check);
        st1.setString(1,cardname);
        st1.setString(2, cardpassword);
        ResultSet rs = st1.executeQuery();
        flag = true;
        return rs.getInt(1);
    
    }

    //test
    public Integer checkexistancevaliduser(String username,String password) throws SQLException{
       
        String check = "SELECT EXISTS(SELECT 1 FROM User WHERE username =? AND userpassword = ?)";
        PreparedStatement st1 = conn.prepareStatement(check);
        st1.setString(1,username);
        st1.setString(2, password);
        ResultSet rs = st1.executeQuery();
        flag = true;
        return rs.getInt(1);
    }
    public boolean addCard(Connection conn,String cardusername,String cardpassword, String username) throws SQLException {
       

        if(checkcardnmae(cardusername,cardpassword)==1){
            System.out.println("Card already here");
            flag = true;
            return false;
        }else{
            String save = "INSERT INTO Card(cardusername,cardpassword,username) VALUES(?,?,?)";
            PreparedStatement st1 = conn.prepareStatement(save);
            st1.setString(1,cardusername);
            st1.setString(2, cardpassword);
            st1.setString(3, username);
            st1.executeUpdate();
            st1.close();
            flag = true;
            return true;
        }

       
    }
    //test
    public boolean addUser(Connection conn,String username,String usertype, String userpassword) throws SQLException {
       

        if(checkexistanceuser(username)==1){
            System.out.println("user already here");
            flag = true;
            return false;
        }else{
            String save = "INSERT INTO User(username,usertype,userpassword) VALUES(?,?,?)";
            PreparedStatement st1 = conn.prepareStatement(save);
            st1.setString(1,username);
            st1.setString(2, usertype);
            st1.setString(3, userpassword);
            st1.executeUpdate();
            st1.close();
            flag = true;
            return true;
        }

       
    }
    //test
    public String getcashData() throws SQLException{
        String a = "cashtype" + "\t" + "cashnumber" + "\n";
        String result = "SELECT * from Cash";
        PreparedStatement st1 = conn.prepareStatement(result);
        ResultSet rs = st1.executeQuery();
        
        while (rs.next()) {
            String cashtype = rs.getString("cashtype");
            String cashnumber = rs.getString("cashnumber");
            
            a += cashtype+"\t"+cashnumber + "\n";
         
            
            
        }
        flag = true;
        return a;
    }


    //test
    public ResultSet getProductData() throws SQLException{
    
        String result = "SELECT * from Product";
        PreparedStatement st1 = conn.prepareStatement(result);
        ResultSet rs = st1.executeQuery();
        flag = true;
        return rs;
    }
    //test
    public ResultSet getUserData() throws SQLException{
    
        String result = "SELECT * from User";
        PreparedStatement st1 = conn.prepareStatement(result);
        ResultSet rs = st1.executeQuery();
        flag = true;
        return rs;
    }
    public ResultSet getUsernameFromCard() throws SQLException{
    
        String result = "SELECT username from Card";
        PreparedStatement st1 = conn.prepareStatement(result);
        ResultSet rs = st1.executeQuery();
        flag = true;
        return rs;
    }
    //test
    public void addUserType(Connection conn,String username,String usertype) throws SQLException {
       

        if(checkexistanceuser(username)==1){
            System.out.println("user already here");
        }else{
            String save = "INSERT INTO User(username,usertype) VALUES(?,?)";
            PreparedStatement st1 = conn.prepareStatement(save);
            st1.setString(1,username);
            st1.setString(2,usertype);
            st1.executeUpdate();
            st1.close();
            flag = true;
        }
    }
    //test
    public void addTransaction(Connection conn,String date,String itemsold, String moneypaid, String returnedchange, String paymentmethod ) throws SQLException {
       

        
        String save = "INSERT INTO Transactionsummary(date,itemsold,moneypaid,returnedchange,paymentmethod) VALUES(?,?,?,?,?)";
        PreparedStatement st1 = conn.prepareStatement(save);
        st1.setString(1,date);
        st1.setString(2,itemsold);
        st1.setString(3,moneypaid);
        st1.setString(4,returnedchange);
        st1.setString(5,paymentmethod);
        st1.executeUpdate();
        st1.close();
        flag = true;
    
    }
    //test
    public String getTransactionSummary() throws SQLException{
        String a = "date" + "\t" + "itemsold" +"\t" + "moneypaid" +"\t" + "returnedchange" +"\t" + "paymentmethod" + "\n";
        String result = "SELECT * from Transactionsummary";
        PreparedStatement st1 = conn.prepareStatement(result);
        ResultSet rs = st1.executeQuery();
        flag = true;
        while (rs.next()) {
            String date = rs.getString("date");
            String itemsold = rs.getString("itemsold");
            String moneypaid = rs.getString("moneypaid");
            String returnedchange = rs.getString("returnedchange");
            String paymentmethod = rs.getString("paymentmethod");
            a += date+"\t"+itemsold +"\t"+moneypaid +"\t"+returnedchange +"\t"+paymentmethod + "\n";
         
            
            
        }
        flag = true;
        return a;
    }
    //test
    public void delUserType(Connection conn,String username) throws SQLException {
       

        if(checkexistanceuser(username)!=1){
            System.out.println("user not found");
        }else{
            String del = "DELETE FROM User where username = ?";
            PreparedStatement st1 = conn.prepareStatement(del);
            st1.setString(1,username);
            st1.executeUpdate();
            st1.close();
            flag = true;
        }
    }
    //test
    public String getProductNumber(String productname) throws SQLException{
        String result = "SELECT productnumber from Product where productname = ?";
        PreparedStatement st1 = conn.prepareStatement(result);
        st1.setString(1,productname);
        ResultSet rs = st1.executeQuery();
        flag = true;
        return rs.getString(1);
    }
    //test
    public String getProductprice(String productname) throws SQLException{
        String result = "SELECT productprice from Product where productname = ?";
        PreparedStatement st1 = conn.prepareStatement(result);
        st1.setString(1,productname);
        ResultSet rs = st1.executeQuery();
        flag = true;
        return rs.getString(1);
    }
    //test
    public String getCashnumber(String cashtype) throws SQLException{
        String result = "SELECT cashnumber from Cash where cashtype = ?";
        PreparedStatement st1 = conn.prepareStatement(result);
        st1.setString(1,cashtype);
        ResultSet rs = st1.executeQuery();
        flag = true;
        return rs.getString(1);
    }
    //test
    public String getSoldNumber(String soldname) throws SQLException {
        String result = "SELECT soldnumber from Sold where soldname = ?";
        PreparedStatement st1 = conn.prepareStatement(result);
        st1.setString(1,soldname);
        ResultSet rs1 = st1.executeQuery();
        flag = true;
        return rs1.getString(1);
    }
    //test
    public String getSoldCode(String soldname) throws SQLException {
        String result = "SELECT soldcode from Sold where soldname = ?";
        PreparedStatement st2 = conn.prepareStatement(result);
        st2.setString(1,soldname);
        ResultSet rs2 = st2.executeQuery();
        flag = true;
        return rs2.getString(1);
    }
    //test
    public boolean checkcash(String cashtype, String cashnumber) throws SQLException{
        String result = "SELECT cashnumber from Cash where cashtype = ?";
        PreparedStatement st1 = conn.prepareStatement(result);
        st1.setString(1,cashtype);
        
        flag = true;
        if(cashtype.equals("5cent") &&  Integer.parseInt(cashnumber)<= 40){
            return true;
        }else if(cashtype.equals("10cent") &&  Integer.parseInt(cashnumber)<= 20){
            return true;
        }else if(cashtype.equals("20cent") &&  Integer.parseInt(cashnumber)<= 10){
            return true;
        }else if(cashtype.equals("50cent") &&  Integer.parseInt(cashnumber)<= 10){
            return true;
        }else if(cashtype.equals("1dollar") &&  Integer.parseInt(cashnumber)<= 20){
            return true;
        }else if(cashtype.equals("2dollar") &&  Integer.parseInt(cashnumber)<= 25){
            return true;
        }else if(cashtype.equals("5dollar") &&  Integer.parseInt(cashnumber)<= 10){
            return true;
        }else if(cashtype.equals("10dollar") &&  Integer.parseInt(cashnumber)<= 10){
            return true;
        }else if(cashtype.equals("20dollar") &&  Integer.parseInt(cashnumber)<= 10){
            return true;
        }
        else{
            return false;
        }

    }

    public boolean getflag(){
        return this.flag;
    }
    public boolean getflag1(){
        return this.flag1;
    }

}
