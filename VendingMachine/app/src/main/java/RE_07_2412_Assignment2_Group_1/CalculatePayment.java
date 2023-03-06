package RE_07_2412_Assignment2_Group_1;

import java.io.*;
import java.util.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.Data;

public class CalculatePayment {
    boolean flag = false;
    boolean flag2 = false;
    boolean flag_timer = false;
    Customer customer = new Customer();
    private static Connection conn;
    private static Database data = new Database();
    private static Timer timer = new Timer();
    public double ask_cashInput(Database data,Connection conn)throws SQLException{
        double sum = 0;
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please type your cash number.");
        System.out.println("100 dollar:");
        Date lastActiveTime = new Date();
        boolean result = true;

        String hundred_dollar = sc.nextLine();

        result = timer.run(lastActiveTime,hundred_dollar);
        if(result == false){
            flag_timer = true;
            return 0;
        }

        if(hundred_dollar.equals("cancel")){
            //add the canceled trascript
            System.out.println("Bye");
            flag =true;
            return 0;
        }
        sum +=Double.parseDouble(hundred_dollar)*100;
        System.out.println("50 dollar:");
        lastActiveTime = new Date();
        String fifty_dollar = sc.nextLine();

        result = timer.run(lastActiveTime,fifty_dollar);
        if(result == false){
            flag_timer = true;
            return sum;
        }
        if(fifty_dollar.equals("cancel")){
            //add the canceled trascript
            //end
            System.out.println("Bye");
            flag = true;
            return sum;
        }
        sum +=Double.parseDouble(fifty_dollar)*50;
        System.out.println("20 dollar:");
        lastActiveTime = new Date();
        String twenty_dollar = sc.nextLine();

        result = timer.run(lastActiveTime,twenty_dollar);
        if(result == false){
            flag_timer = true;
            return 0;
        }
        if(twenty_dollar.equals("cancel")){
            //add the canceled trascript
            //end
            System.out.println("Bye");
            flag = true;
            return sum;
        }
        sum +=Double.parseDouble(twenty_dollar)*20;
        System.out.println("10 dollar:");
        lastActiveTime = new Date();
        String ten_dollar = sc.nextLine();

        result = timer.run(lastActiveTime,ten_dollar);
        if(result == false){
            flag_timer = true;
            return 0;
        }
        if(ten_dollar.equals("cancel")){
            //add the canceled trascript
            //end
            System.out.println("Bye");
            flag = true;
            return sum;
        }
        sum +=Double.parseDouble(ten_dollar)*10;
        System.out.println("5 dollar:");
        lastActiveTime = new Date();
        String five_dollar = sc.nextLine();

        result = timer.run(lastActiveTime,five_dollar);
        if(result == false){
            flag_timer = true;
            return 0;
        }
        if(five_dollar.equals("cancel")){
            //add the canceled trascript
            //end
            System.out.println("Bye");
            flag = true;
            return sum;
        }
        sum +=Double.parseDouble(five_dollar)*5;
        System.out.println("2 dollar:");
        lastActiveTime = new Date();
        String two_dollar = sc.nextLine();

        result = timer.run(lastActiveTime,two_dollar);
        if(result == false){
            flag_timer = true;
            return 0;
        }
        if(two_dollar.equals("cancel")){
            //add the canceled trascript
            //end
            System.out.println("Bye");
            flag = true;
            return sum;
        }
        sum +=Double.parseDouble(two_dollar)*2;
        System.out.println("1 dollar:");
        lastActiveTime = new Date();
        String one_dollar = sc.nextLine();

        result = timer.run(lastActiveTime,one_dollar);
        if(result == false){
            flag_timer = true;
            return 0;
        }
        if(one_dollar.equals("cancel")){
            //add the canceled trascript
            //end
            System.out.println("Bye");
            flag = true;
            return sum;
        }
        sum +=Double.parseDouble(one_dollar)*1;
        System.out.println("50 cent:");
        lastActiveTime = new Date();
        String fifty_cent = sc.nextLine();

        result = timer.run(lastActiveTime,fifty_cent);
        if(result == false){
            flag_timer = true;
            return 0;
        }
        if(fifty_cent.equals("cancel")){
            //add the canceled trascript
            //end
            System.out.println("Bye");
            flag = true;
            return sum;
        }
        sum +=Double.parseDouble(fifty_cent)*0.5;
        System.out.println("20 cent:");
        lastActiveTime = new Date();
        String twenty_cent = sc.nextLine();

        result = timer.run(lastActiveTime,twenty_cent);
        if(result == false){
            flag_timer = true;
            return 0;
        }
        if(twenty_cent.equals("cancel")){
            //add the canceled trascript
            //end
            System.out.println("Bye");
            flag = true;
            return sum;
        }
        sum +=Double.parseDouble(twenty_cent)*0.2;
        System.out.println("10 cent:");
        lastActiveTime = new Date();
        String ten_cent = sc.nextLine();

        result = timer.run(lastActiveTime,ten_cent);
        if(result == false){
            flag_timer = true;
            return 0;
        }
        if(ten_cent.equals("cancel")){
            //add the canceled trascript
            //end
            System.out.println("Bye");
            flag = true;
            return sum;
        }
        sum +=Double.parseDouble(ten_cent)*0.1;
        System.out.println("5 cent:");
        lastActiveTime = new Date();
        String five_cent = sc.nextLine();

        result = timer.run(lastActiveTime,five_cent);
        if(result == false){
            flag_timer = true;
            return 0;
        }
        if(five_cent.equals("cancel")){
            //add the canceled trascript
            //end
            System.out.println("Bye");
            flag = true;
            return sum;
        }
        sum +=Double.parseDouble(five_cent)*0.05;
        return sum;
    }
    

    public ArrayList<Integer> Calculate_Payment(String ProductName, double CustomerPay,Connection conn,Database data) throws NumberFormatException, SQLException {
        ArrayList<Integer> result_list = new ArrayList<>();
        double remain = CustomerPay;
        int five_cent_count = 0;
        int ten_cent_count = 0;
        int twenty_cent_count = 0;
        int fifty_cent_count = 0;
        int one_dollar_count = 0;
        int two_dollar_count = 0;
        int five_dollar_count = 0;
        int ten_dollar_count = 0;
        int twenty_dollar_count = 0;
        int twenty_dollar_store = Integer.parseInt(data.getCashnumber("20dollar"));
        int ten_dollar_store = Integer.parseInt(data.getCashnumber("10dollar"));
        int five_dollar_store = Integer.parseInt(data.getCashnumber("5dollar"));
        int two_dollar_store = Integer.parseInt(data.getCashnumber("2dollar"));
        int one_dollar_store = Integer.parseInt(data.getCashnumber("1dollar"));
        int fifty_cent_store = Integer.parseInt(data.getCashnumber("50cent"));
        int twenty_cent_store = Integer.parseInt(data.getCashnumber("20cent"));
        int ten_cent_store = Integer.parseInt(data.getCashnumber("10cent"));
        int five_cent_store = Integer.parseInt(data.getCashnumber("5cent"));
        double sum = twenty_dollar_store*20+ten_dollar_store*10+five_dollar_store*5+two_dollar_store*2+one_dollar_store*1+fifty_cent_store*0.5+twenty_cent_store*0.2+ten_cent_store*0.1+five_cent_store*0.05;
        if(remain>sum){
            System.out.println("Change is not enough.");
            flag2 = true;
            return result_list;
        }
        while(remain>0){
            if((remain/20)>=1){
                twenty_dollar_count = (int) ((remain-(remain%20))/20);
                if(twenty_dollar_store<twenty_dollar_count){
                    twenty_dollar_count = twenty_dollar_store;
                    remain = remain -twenty_dollar_count*20;
                }
                else{
                    remain = remain%20;
                }
            }
            if((remain/10)>=1){
                ten_dollar_count = (int) ((remain-(remain%10))/10);
                if(ten_dollar_store<ten_dollar_count){
                    ten_dollar_count = ten_dollar_store;
                    remain = remain -ten_dollar_count*10;
                }
                else{
                    remain = remain%10;
                }
            }
            if((remain/5)>=1){
                five_dollar_count = (int) ((remain-(remain%5))/5);
                if(five_dollar_store<five_dollar_count){
                    five_dollar_count = five_dollar_store;
                    remain = remain -five_dollar_count*5;
                }
                else{
                    remain = remain%5;
                }
            }
            if((remain/2)>=1){
                two_dollar_count = (int) ((remain-(remain%2))/2);
                if(two_dollar_store<two_dollar_count){
                    two_dollar_count = two_dollar_store;
                    remain = remain -two_dollar_count*2;
                }
                else{
                    remain = remain%2;
                }
            }
            if((remain/1)>=1){
                one_dollar_count = (int) ((remain-(remain%1))/1);
                if(one_dollar_store<one_dollar_count){
                    one_dollar_count = one_dollar_store;
                    remain = remain -one_dollar_count*1;
                }
                else{
                    remain = remain%1;
                }
            }
            if((remain/0.5)>=1){
                fifty_cent_count = (int) ((remain-(remain%0.5))/0.5);
                if(fifty_cent_store<fifty_cent_count){
                    fifty_cent_count = fifty_cent_store;
                    remain = remain -fifty_cent_count*0.5;
                }
                else{
                    remain = remain%0.5;
                }
            }
            if((remain/0.2)>=1){
                twenty_cent_count = (int) ((remain-(remain%0.2))/0.2);
                if(twenty_cent_store<twenty_cent_count){
                    twenty_cent_count = twenty_cent_store;
                    remain = remain -twenty_cent_count*0.2;
                }
                else{
                    remain = remain%0.2;
                }
            }
            if((remain/0.1)>=1){
                ten_cent_count = (int) ((remain-(remain%0.1))/0.1);
                if(ten_cent_store<ten_cent_count){
                    ten_cent_count = ten_cent_store;
                    remain = remain -ten_cent_count*0.1;
                }
                else{
                    remain = remain%0.1;
                }
            }
            if((remain/0.05)>=1){
                five_cent_count = (int) ((remain-(remain%0.05))/0.05);
                if(five_cent_store<five_cent_count){
                    five_cent_count = five_cent_store;
                    remain = remain -five_cent_count*0.05;
                }
                else{
                    remain = remain%0.05;
                }
            }
        }

        result_list.add(0,twenty_dollar_count);
        result_list.add(1,ten_dollar_count);
        result_list.add(2,five_dollar_count);
        result_list.add(3,two_dollar_count);
        result_list.add(4,one_dollar_count);
        result_list.add(5,fifty_cent_count);
        result_list.add(6,twenty_cent_count);
        result_list.add(7,ten_cent_count);
        result_list.add(8,five_cent_count);
       
        data.addCashinput(conn,"20dollar",Integer.toString(twenty_dollar_count) );
        data.addCashinput(conn,"10dollar",Integer.toString(ten_dollar_count) );
        data.addCashinput(conn,"5dollar",Integer.toString(five_dollar_count) );
        data.addCashinput(conn,"2dollar",Integer.toString(two_dollar_count) );
        data.addCashinput(conn,"1dollar",Integer.toString(one_dollar_count) );
        data.addCashinput(conn,"50cent",Integer.toString(fifty_cent_count) );
        data.addCashinput(conn,"20cent",Integer.toString(twenty_cent_count) );
        data.addCashinput(conn,"10cent",Integer.toString(ten_cent_count) );
        data.addCashinput(conn,"5cent",Integer.toString(five_cent_count) );
     
    
        return result_list;
    }

    public boolean reduce_number_database(ArrayList<Integer> list, Connection conn, Database data) throws SQLException{

        int twenty_dollar = Integer.parseInt(data.getCashnumber("20dollar"));
        twenty_dollar = twenty_dollar-list.get(0);
        data.addCash_exist(conn,"20dollar",String.valueOf(twenty_dollar));

        int ten_dollar = Integer.parseInt(data.getCashnumber("10dollar"));
        ten_dollar = ten_dollar-list.get(1);
        data.addCash_exist(conn,"10dollar",String.valueOf(ten_dollar));

        int five_dollar = Integer.parseInt(data.getCashnumber("5dollar"));
        five_dollar = five_dollar-list.get(2);
        data.addCash_exist(conn,"5dollar",String.valueOf(five_dollar));

        int two_dollar = Integer.parseInt(data.getCashnumber("2dollar"));
        two_dollar = two_dollar-list.get(3);
        data.addCash_exist(conn,"2dollar",String.valueOf(two_dollar));

        int one_dollar = Integer.parseInt(data.getCashnumber("1dollar"));
        one_dollar = one_dollar-list.get(4);
        data.addCash_exist(conn,"1dollar",String.valueOf(one_dollar));

        int fifty_cent = Integer.parseInt(data.getCashnumber("50cent"));
        fifty_cent = fifty_cent-list.get(5);
        data.addCash_exist(conn,"50cent",String.valueOf(fifty_cent));

        int twenty_cent = Integer.parseInt(data.getCashnumber("20cent"));
        twenty_cent = twenty_cent-list.get(6);
        data.addCash_exist(conn,"20cent",String.valueOf(twenty_cent));

        int ten_cent_count = Integer.parseInt(data.getCashnumber("10cent"));
        ten_cent_count = ten_cent_count-list.get(7);
        data.addCash_exist(conn,"10cent",String.valueOf(ten_cent_count));

        int five_cent = Integer.parseInt(data.getCashnumber("5cent"));
        five_cent = five_cent-list.get(8);
        data.addCash(conn,"5cent",String.valueOf(five_cent));

        return true;
        
    }

    public boolean getflag(){
        return this.flag;
    }
    public boolean getflag2(){
        return this.flag2;
    }
    public boolean getflag_timer(){
        return this.flag_timer;
    }

}