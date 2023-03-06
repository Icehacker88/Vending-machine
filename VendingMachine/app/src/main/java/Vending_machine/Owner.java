package RE_07_2412_Assignment2_Group_1;

import java.sql.*;
import java.util.*;

public class Owner {
    private Integer flag = 0;
    private boolean flag1 = false;

    public ArrayList<String> getRoles(Database data, Connection conn)throws SQLException{
        ArrayList<String> ls = new ArrayList<String>();
        ResultSet rs = data.getUserData();
        while (rs.next()){
            String username = rs.getString("username");
            ls.add(username);
            String usertype = rs.getString("usertype");
            ls.add(usertype);
        }
        flag = 1;
        return ls;
    }

    public void changeUser(Database data,Connection conn)throws SQLException{
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if(choice.equals("Add")){
            System.out.println("Type the user name you want to add");
            String user_name = sc.nextLine();
            System.out.println("Type the user type you want to add");
            String user_type = sc.nextLine();
            data.addUserType(conn, user_name, user_type);
            System.out.println("Add successeful");
            flag=2;
        }else if(choice.equals("Delete")){
            System.out.println("Type the user name you want to delete");
            String user_name = sc.nextLine();
            data.delUserType(conn, user_name);
            System.out.println("Delete successeful");
            flag=3;
        }   
        
    }

    public void modifyChanges(Database data,Connection conn)throws SQLException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Type the cash type you want to modify");
        String cash_type = sc.nextLine();
        System.out.println("Type the cash number you want to modify");
        String cash_number = sc.nextLine();
        data.addCash_exist(conn, cash_type, cash_number);
        flag = 4;
    }

    public void modifyProduct(Database data,Connection conn)throws SQLException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Type the product code you want to modify");
        String product_code = sc.nextLine();
        System.out.println("Type the product name you want to modify");
        String product_name = sc.nextLine();
        System.out.println("Type the product type you want to modify");
        String product_type = sc.nextLine();
        System.out.println("Type the product number you want to modify");
        String product_number = sc.nextLine();
        System.out.println("Type the product price you want to modify");
        String product_price = sc.nextLine();
        data.addProduct(conn, product_code, product_name, product_type, product_number, product_price);
        System.out.println("Modify successeful");
        flag = 5;
    }

    public Integer getflag(){
        return this.flag;
    }

}
