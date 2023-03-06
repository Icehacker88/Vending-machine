package RE_07_2412_Assignment2_Group_1;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Card {
    boolean flag = false;
    boolean flag_timer = false;
    private static Timer timer = new Timer();
    Customer customer = new Customer();
    public boolean checkcard(Database data, Connection conn, String username) throws SQLException {
        boolean result = false;
        ResultSet rs= data.getUsernameFromCard();
        while(rs.next()){
            String username_card = rs.getString("username");
            if(username.equals(username_card)){
                result = true;
                System.out.println("Card can be used.");
                return result;
            }
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Please type your card username.");
        Date lastActiveTime = new Date();
        boolean result_timer = true;

        String card_username = sc.nextLine();


        result_timer = timer.run(lastActiveTime,card_username);
        if(result_timer == false){
            flag_timer = true;
            return false;
        }

        if(card_username.equals("cancel")){
            //add the canceled trascript
            System.out.println("Bye");
            flag =true;
            return false;
        }

        System.out.println("Please type your card password.");
        lastActiveTime = new Date();
        String card_password = sc.nextLine();


        result_timer = timer.run(lastActiveTime,card_password);
        if(result_timer == false){
            flag_timer = true;
            return false;
        }

        if(card_password.equals("cancel")){
            //add the canceled trascript
            System.out.println("Bye");
            flag =true;
            return false;
        }

        if(data.checkcardnmae(card_username, card_password)==1){
            result = true;
            System.out.println("Card can be used.");
            data.addCard(conn, card_username, card_password, username);
            return result;
        }
        System.out.println("Card can not be used.");
        return result;
    }
    public boolean getflag(){
        return this.flag;
    }
    public boolean getflag_timer(){
        return this.flag_timer;
    }
}
