package RE_07_2412_Assignment2_Group_1;

import java.io.*;
import java.util.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.spi.DirStateFactory.Result;


public class Customer {
    private static Customer customer = new Customer();
    private static Timer timer = new Timer();

    private float e;
    private float m;

    String Payment = "Cash";
    public static int n;

    private boolean flag = false;
    private boolean flag1 = false;
    private boolean flag_timer = false;

    public void cancelaccept(Database data,Connection conn)throws SQLException{
        //add the canceled trascript
        ResultSet rs1 = data.getCurrentUser();
        String currentname = rs1.getString("username");
        String reason = "Customer cancel";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        data.addCancel(conn, currentname, date, reason);
        flag = true;
        //end
    }
    public void cancelaccept_overtime(Database data,Connection conn)throws SQLException{
        //add the canceled trascript
        ResultSet rs1 = data.getCurrentUser();
        String currentname = rs1.getString("username");
        String reason = "Operation timed out";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        data.addCancel(conn, currentname, date, reason);
        flag = true;
        //end
    }

    public String choosePayment(Connection conn,Database data) throws SQLException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a payment:");
        System.out.println("Cash or Card?");

        Date lastActiveTime = new Date();
        boolean Timerresult = true;

        String Payment = sc.nextLine();

        Timerresult = timer.run(lastActiveTime,Payment);
        if(Timerresult == false){
            // customer.cancelaccept_overtime(data, conn);
            flag_timer = true;
            return "overtime";
        }

        if (Payment.equals("Card") | Payment.equals("Cash")) {
            flag = true;
            return Payment;
        }
        System.out.println("Wrong payment!");
        //add the canceled trascript
        ResultSet rs = data.getCurrentUser();
        String currentname = rs.getString("username");
        String reason = "Wrong payment";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        data.addCancel(conn, currentname, date, reason);
        flag = true;
        //end
        return "false";
        
    }

    public int getn() {
        return n;
    }
    // public boolean isEnoughMoney() {
    //     if (amount - m > e) { // customer pay - price > left amount in machine
    //         System.out.println("There is no enough money in the vending machine to provide change!");
    //         return false;
    //     }
    //     return true;
    // }

    // public boolean getCorrectChange() {
    //     return false;
    // }

    public String buyProduct(String choice_input, Database data, Connection conn) throws IOException, SQLException{

        // data.connect();
        // conn = data.getConn();
        data.createTableuser(conn);
        data.createTable(conn);
        data.createTableSold(conn);
        String result_choice = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("What kind of product whould you like?");
        System.out.println("drinks,chocolates,chips or candies?");
        System.out.println("Enter your option");
        String choice = choice_input;
        ResultSet rs = data.getProductData();
        // ResultSet s = data.getSold();
        ArrayList<String> ls = new ArrayList<String>();
        if (choice.equals("drinks")){
            System.out.println("What kind of drinks whould you like?");
            while (rs.next()){
                String productcode = rs.getString("productcode");
                String productname = rs.getString("productname");
                String producttype = rs.getString("producttype");
                String productnumber_string = rs.getString("productnumber");
                String productprice = rs.getString("productprice");
                Integer productnumber = Integer.parseInt(productnumber_string);
                if(producttype.equals("drinks")){
                    if(productnumber >0){
                        ls.add(productname);
                        flag = true; 
                    }
                }    
            }
            System.out.println(ls);
            Date lastActiveTime = new Date();
            boolean Timerresult = true;
            
            String choicedrink = sc.nextLine();

            Timerresult = timer.run(lastActiveTime,choicedrink);
            if(Timerresult == false){
                // customer.cancelaccept_overtime(data, conn);
                flag_timer=true;
                return "overtime";
            }
            if(choicedrink.equals("cancel")){
                flag1=true;
                return "cancel";
            }
            // if (Integer.parseInt(data.getProductNumber(choicedrink)) == 0) {
            //     System.out.printf("There is no %s in the vending machine.", choicedrink);
            // } 
            while (true) {
                System.out.println("How many do you want to buy?");

                lastActiveTime = new Date();
                Timerresult = true;

                n = sc.nextInt();

                Timerresult = timer.run(lastActiveTime,Integer.toString(n));
                if(Timerresult == false){
                    // customer.cancelaccept_overtime(data, conn);
                    flag_timer=true;
                    return "overtime";
                }
                String pn = data.getProductNumber(choicedrink);
                if (n > Integer.parseInt(pn)) {
                    System.out.println("Only " + pn + " in the machine. Please choose again.");
                    continue;
                } else {
                    result_choice = choicedrink;
                    break;
                }
            }
            
        }else if (choice.equals("chocolates")){
            System.out.println("What kind of drinks whould you like?");
            while (rs.next()){
                String productcode = rs.getString("productcode");
                String productname = rs.getString("productname");
                String producttype = rs.getString("producttype");
                String productnumber_string = rs.getString("productnumber");
                String productprice = rs.getString("productprice");
                Integer productnumber = Integer.parseInt(productnumber_string);
                if(producttype.equals("chocolates")){
                    if(productnumber >0){
                        ls.add(productname);
                        flag = true; 
                    }
                }    
            }
            System.out.println(ls);
            Date lastActiveTime = new Date();
            boolean Timerresult = true;

            String choicechocolate = sc.nextLine();

            Timerresult = timer.run(lastActiveTime,choicechocolate);
            if(Timerresult == false){
                // customer.cancelaccept_overtime(data, conn);
                flag_timer=true;
                return "overtime";
            }
            if(choicechocolate.equals("cancel")){
                flag1=true;
                return "cancel";
            }
            // if (Integer.parseInt(data.getProductNumber(choicechocolate)) == 0) {
            //     System.out.printf("There is no %s in the vending machine.", choicechocolate);
            // }
            while (true) {
                System.out.println("How many do you want to buy?");
                n = sc.nextInt();
                String pn = data.getProductNumber(choicechocolate);
                if (n > Integer.parseInt(pn)) {
                    System.out.println("Only " + pn + " in the machine. Please choose again.");
                    continue;
                } else {
                    result_choice = choicechocolate;
                    break;
                }
            }
        }else if (choice.equals("chips")){
            System.out.println("What kind of drinks whould you like?");
            while (rs.next()){
                String productcode = rs.getString("productcode");
                String productname = rs.getString("productname");
                String producttype = rs.getString("producttype");
                String productnumber_string = rs.getString("productnumber");
                String productprice = rs.getString("productprice");
                Integer productnumber = Integer.parseInt(productnumber_string);
                if(producttype.equals("chips")){
                    if(productnumber >0){
                        ls.add(productname);
                        flag = true; 
                    }
                }    
            }
            System.out.println(ls);
            Date lastActiveTime = new Date();
            boolean Timerresult = true;

            String choicechip = sc.nextLine();

            Timerresult = timer.run(lastActiveTime,choicechip);
            if(Timerresult == false){
                // customer.cancelaccept_overtime(data, conn);
                flag_timer=true;
                return "overtime";
            }
            if(choicechip.equals("cancel")){
                flag1=true;
                return "cancel";
            }
            // if (Integer.parseInt(data.getProductNumber(choicechip)) == 0) {
            //     System.out.printf("There is no %s in the vending machine.", choicechip);
            // }
            while (true) {
                System.out.println("How many do you want to buy?");
                n = sc.nextInt();
                String pn = data.getProductNumber(choicechip);
                if (n > Integer.parseInt(pn)) {
                    System.out.println("Only " + pn + " in the machine. Please choose again.");
                    continue;
                } else {
                    result_choice = choicechip;
                    break;
                }
            }
        }else if (choice.equals("candies")){
            System.out.println("What kind of drinks whould you like?");
            while (rs.next()){
                String productcode = rs.getString("productcode");
                String productname = rs.getString("productname");
                String producttype = rs.getString("producttype");
                String productnumber_string = rs.getString("productnumber");
                String productprice = rs.getString("productprice");
                Integer productnumber = Integer.parseInt(productnumber_string);
                if(producttype.equals("candies")){
                    if(productnumber >0){
                        ls.add(productname);
                        flag = true; 
                    }
                }    
            }
            System.out.println(ls);
            Date lastActiveTime = new Date();
            boolean Timerresult = true;

            String choicecandy = sc.nextLine();
            Timerresult = timer.run(lastActiveTime,choicecandy);
            if(Timerresult == false){
                // customer.cancelaccept_overtime(data, conn);
                flag_timer=true;
                return "overtime";
            }
            if(choicecandy.equals("cancel")){
                flag1=true;
                return "cancel";
            }
            // if (Integer.parseInt(data.getProductNumber(choicecandy)) == 0) {
            //     System.out.printf("There is no %s in the vending machine.", choicecandy);
            // }
            while (true) {
                System.out.println("How many do you want to buy?");
                n = sc.nextInt();
                String pn = data.getProductNumber(choicecandy);
                if (n > Integer.parseInt(pn)) {
                    System.out.println("Only " + pn + " in the machine. Please choose again.");
                    continue;
                } else {
                    result_choice = choicecandy;
                    break;
                }
            }
        }
        return result_choice;

        
    }
    public boolean getflag(){
        return this.flag;
    }

    public boolean getflag1(){
        return this.flag1;
    }
    public boolean getflag_timer(){
        return this.flag_timer;
    }
}
