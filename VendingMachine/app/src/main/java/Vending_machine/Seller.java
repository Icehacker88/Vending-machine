package RE_07_2412_Assignment2_Group_1;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Seller {
    private static Customer customer = new Customer();
    private boolean flag = false;

    public void addSeller(Database data, Connection conn) throws SQLException {
        data.addUser(conn, "seller1", "seller", "234");
        flag = true;
    }
    
    public void addP(String productcode, String productname, String producttype, String productnumber, String productprice, Database data, Connection conn) throws SQLException {
        if (Integer.parseInt(productnumber) > 15) {
            System.out.println("The quantity added will be over than the limit (15).");
            flag = false;
        } else {
            data.addProduct(conn, productcode, productname, producttype, productnumber, productprice);
            System.out.println("Modify successfully!");
        }
        flag = true;
    }

    public void addToSold(String soldcode, String soldname, String soldtype, String soldnumber, String productnumber_string, String productprice, Database data, Connection conn) throws SQLException {
        int n = customer.getn();
        int sold = Integer.parseInt(soldnumber) + n;
        data.addSold(conn, soldcode, soldname, String.valueOf(sold));
        int productnumber = Integer.parseInt(productnumber_string) - n;
        data.addProduct(conn, soldcode, soldname, soldtype, String.valueOf(productnumber), productprice);
        flag = true;
    }

    public void getCurrentAvailable(Database data, Connection conn) throws SQLException, IOException {

        BufferedOutputStream buffoutputstream = null; 

        try {
            try (BufferedWriter f = new BufferedWriter(new FileWriter("CurrentAvailable.txt"))) {
                ResultSet rs = data.getProductData();
                String content="[productcode]"+"\t"+"[productname]"+"\t"+"[producttype]"+"\t"+"[productnumber]"+"\t"+"[productprice]"+"\n";
                f.write(content);
                try {
                    while(rs.next()) {
                        content = rs.getString("productcode")+"\t\t";
                        f.write(content);
                        content = rs.getString("productname")+"\t\t";
                        f.write(content);
                        content = rs.getString("producttype")+"\t\t";
                        f.write(content);
                        content = rs.getString("productnumber")+"\t\t";
                        f.write(content);
                        content = rs.getString("productprice")+"\n";
                        f.write(content);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        finally {
            if (buffoutputstream != null)
                try {
                    buffoutputstream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        flag = true;
    }

    public void getSoldReport(Database data, Connection conn) throws SQLException, IOException {
        
        BufferedOutputStream buffoutputstream = null;
        try {
            try (BufferedWriter f = new BufferedWriter(new FileWriter("SoldReport.txt"))) {
                ResultSet rs = data.getSold();
                String content = "[soldcode]"+"\t"+"[soldname]"+"\t"+"[soldnumber]"+"\n";
                f.write(content);
                try {
                    while(rs.next())
                    {
                        content = rs.getString("soldcode")+"\t";
                        f.write(content);
                        content = rs.getString("soldname")+"\t";
                        f.write(content);
                        content = rs.getString("soldnumber")+"\n";
                        f.write(content);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        finally {
            if (buffoutputstream != null)
                try {
                    buffoutputstream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        flag = true;
    }

    public boolean getflag(){
        return this.flag;
    }
}