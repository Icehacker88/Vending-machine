package RE_07_2412_Assignment2_Group_1;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;




import java.sql.*;

public class App {

    
    private static Connection conn;
    private static Database data = new Database();
    private static Customer customer = new Customer();
    private static CalculatePayment calculatePayment = new CalculatePayment();
    private static Owner owner = new Owner();
    private static Cashier cashier = new Cashier();
    private static Seller seller = new Seller();
    private static Timer timer = new Timer();
    private static Card card = new Card();
    private String currentdate;
    private static String itemsold;
    private static String moneypaid;
    private static String returnedchange;
    private static String paymentmethod;
    //private static Customer c = new Customer();

    // private static UserLogin login = new UserLogin();
    // private static CustomerSignUp signUp = new CustomerSignUp();


    public static void main(String[] args) throws IOException, SQLException {
        ArrayList<Integer> cash_used_list = new ArrayList<>();
        Date lastActiveTime = new Date();
        boolean Timerresult = true;
        boolean card_result = false;

        data.connect();
        conn = data.getConn();
        data.createTableuser(conn);
        data.createTable(conn);
        data.createTablecurrentuser(conn);
        data.createTablecancel(conn);
        data.createTablecash(conn);
        data.createTableCard(conn);
        data.createTableSold(conn);
        data.createTablecashInput(conn);
        data.addCard(conn, "asdd", "1234", "customer1");
        data.addCash(conn, "20dollar","10");
        data.addCash(conn, "10dollar","10");
        data.addCash(conn, "5dollar","10");
        data.addCash(conn, "2dollar","10");
        data.addCash(conn, "1dollar","10");
        data.addCash(conn, "50cent","10");
        data.addCash(conn, "20cent","10");
        data.addCash(conn, "10cent","10");
        data.addCash(conn, "5cent","10");
        

        seller.addSeller(data, conn);
        data.addUser(conn, "customer1", "customer", "123");
        data.addUser(conn, "cashier1", "cashier", "123");
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        System.out.println("To use this vendingmachine, user login is required. Enter a to login, Enter b to signup");
        System.out.println("Enter your option");
        String choice = sc.nextLine();
        
        data.addInituser(conn, "owner1", "owner", "123");

        if(choice.equals("a")){
            System.out.println("Enter username");
            String userName = sc.nextLine();  // Read user input
            data.addCurrentUser(conn, userName);
            System.out.println("Enter password");  
            String password = sc.nextLine();// read user password
            if (data.checkexistancevaliduser(userName, password)==1) {
                String userType = data.getUsertype(userName, password);
                if (userType.equals("seller")) {
                    System.out.println("login Successful"+userName);
                    System.out.println("choose your option");                    
                    while (true) {
                        System.out.println("modify: products, get: current or sold, quit");
                        String choiceseller = sc.nextLine();
                        if(choiceseller.equals("modify")) {
                            // Enter productcode, productname, producttype, productnumber and productprice in order
                            System.out.println("Enter product code:");
                            String productcode = sc.nextLine();
                            System.out.println("Enter product name:");
                            String productname = sc.nextLine();
                            System.out.println("Enter product type:");
                            String producttype = sc.nextLine();
                            System.out.println("Enter product number:");
                            String productnumber = sc.nextLine();
                            System.out.println("Enter product price:");
                            String productprice = sc.nextLine();
                            seller.addP(productcode, productname, producttype, productnumber, productprice, data, conn);
                        } else if (choiceseller.equals("get current")) {
                            seller.getCurrentAvailable(data, conn);
                            System.out.println("Already got current available list.");
                        } else if (choiceseller.equals("get sold")) {
                            seller.getSoldReport(data, conn);
                            System.out.println("Already got sold report.");
                        } else if (choiceseller.equals("quit")) {
                            System.out.println("See you next time!");
                            break;
                        } else {
                            System.out.println("You entered wrong charactor, please try again.");
                        }
                    }        

                } else if(userType.equals("owner")){
                    System.out.println("login Successful "+userName);
                    System.out.println("choose your option");
                    System.out.println("change: user, modify: changes or product, get: canceled transcrip or roles list");
                    String choiceowner = sc.nextLine();
                    if(choiceowner.equals("change")){
                        System.out.println("Add user or Delete user");
                        owner.changeUser(data,conn);
                    }else if(choiceowner.equals("modify changes")){
                        owner.modifyChanges(data,conn);
                    }else if(choiceowner.equals("get cancel")){
                        ArrayList lscancel = data.getcancel();
                        System.out.println(lscancel);
                    }else if(choiceowner.equals("modify product")){
                        owner.modifyProduct(data,conn);
                    }else if(choiceowner.equals("get roles")){
                        System.out.println(owner.getRoles(data,conn));
                    }

                } else if(userType.equals("cashier")){
                    System.out.println("login Successful"+userName);
                    System.out.println("choose your option");
                    System.out.println("Display current change, Show transaction history");
                    String choicecashier = sc.nextLine();
                    if(choicecashier.equals("Display current change")){
                        System.out.println(cashier.displayChange());
                    }else if(choicecashier.equals("Show transaction history")){
                        System.out.println(cashier.getTransactionHistoyr());
                    }

                }else if(userType.equals("customer")){
                    System.out.println("login Successful "+userName);
                    System.out.println("Here is your recent Transaction Records: ");
                    ArrayList rs1=data.getSoldname(userName);
                    while (true) {
                        ResultSet rs=data.getProductData();
                        //System.out.println(data.getProductNumber("milk"));
                        System.out.println(rs1);
                    
                        System.out.println("Displaying product list ...");
                        System.out.println("Product code    Product name    Product type    Product number   Product price");
                        //System.out.println(data.getProductNumber("milk"));
                        while (rs.next()) {
                            String productcode = rs.getString("productcode");
                            String productname = rs.getString("productname");
                            String producttype = rs.getString("producttype");
                            String productnumber = rs.getString("productnumber");
                            String productprice = rs.getString("productprice");
                            System.out.println(productcode+"\t"+productname+"\t"+producttype+"\t"+productnumber+"\t"+productprice);
                        }
                        System.out.println("please type the product type to buy product");
                        
                        // timer
                        lastActiveTime = new Date();
                        Timerresult = true;

                        String ppname = sc.nextLine();


                        Timerresult = timer.run(lastActiveTime,ppname);
                        if(Timerresult == false){
                            customer.cancelaccept_overtime(data, conn);
                            return;
                        }
                        // timer end

                        if(ppname.equals("cancel")){
                            customer.cancelaccept(data,conn);
                            System.out.println("Bye");
                            return;
                        }
                        String result_ppname = customer.buyProduct(ppname, data, conn);
                        itemsold = result_ppname;
                        
                        boolean flag1 = customer.getflag1();
                        boolean flag_timer = customer.getflag_timer();

                        if(flag1){
                            customer.cancelaccept(data,conn);
                            System.out.println("Bye");
                            return;
                        }else if(flag_timer){
                            customer.cancelaccept_overtime(data, conn);
                            return;
                        }else{
                            String way_pay = customer.choosePayment(conn, data);
                            if(way_pay.equals("false")){
                                customer.cancelaccept(data,conn);
                                return;
                            }else if(way_pay.equals("overtime")){
                                customer.cancelaccept_overtime(data, conn);
                                return;
                            }else if(way_pay.equals("Cash")){
                                paymentmethod = "Cash";
                                double cash_sum = calculatePayment.ask_cashInput(data,conn);     
                                moneypaid = Double.toString(cash_sum);
                                
                                boolean flag = calculatePayment.getflag();
                                boolean flag_timer2 = calculatePayment.getflag_timer();
                                if(flag){
                                    customer.cancelaccept(data,conn);
                                    System.out.print("Bye");
                                    return;
                                }else if(flag_timer2){
                                    customer.cancelaccept_overtime(data, conn);
                                    return;
                                }else{
                                    data.addSoldname(conn, userName, result_ppname);
                                    String price = data.getProductprice(result_ppname);
                                    int number_product = customer.getn();
                                    cash_sum = cash_sum - Double.valueOf(price)*number_product;
                                    returnedchange = Double.toString(cash_sum);
                                    cash_used_list = calculatePayment.Calculate_Payment(result_ppname,cash_sum, conn, data);                 
                                    boolean flag2 = calculatePayment.getflag2();
                                    if(flag2){
                                        customer.cancelaccept(data,conn);
                                        return;
                                    }else{
                                        String soldcode = data.getSoldCode(result_ppname);
                                        String datee = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                                        String soldnumber = data.getSoldNumber(result_ppname);
                                        String productnumber_string = data.getProductNumber(result_ppname);
                                        String productprice = data.getProductprice(result_ppname);
                                        calculatePayment.reduce_number_database(cash_used_list, conn, data);
                                        seller.addToSold(soldcode, result_ppname, ppname, soldnumber, productnumber_string, productprice, data, conn);
                                        data.addTransaction(conn, datee, itemsold, moneypaid, returnedchange, paymentmethod);
                                        while (true) {
                                            System.out.println("buy: buy again; quit");
                                            String c1 = sc.nextLine();
                                            if (c1.equals("buy")) {
                                                break;
                                            } else if (c1.equals("quit")) {
                                                System.out.println("Bye");
                                                return; 
                                            } else {
                                                System.out.println("Wrong charactor, try again please.");
                                            }
                                        }
                                    }
                                }
                            } else if(way_pay.equals("Card")){
                                paymentmethod = "Card";
                                card_result = card.checkcard(data, conn, userName);
                                boolean flag3 = card.getflag();
                                boolean flag_timer3 = card.getflag_timer();
                                if (flag3){
                                    customer.cancelaccept(data,conn);
                                    System.out.println("Bye");
                                    return;
                                }else if(flag_timer3){
                                    customer.cancelaccept_overtime(data, conn);
                                    return;
                                }
                            }
                        
                        }
                    }
                    
                }else{
                    System.out.println("incorrect password or username");
                }
            }
                    
        }else if(choice.equals("b")){
                System.out.println("Enter username");
                String userName = sc.nextLine();  // Read user input
                if(userName.equals("cancel")){
                    customer.cancelaccept(data,conn);
                    System.out.println("Bye");
                    return;
                }
                System.out.println("Enter password");  
                String password = sc.nextLine();// read user password
                if(password.equals("cancel")){
                    customer.cancelaccept(data,conn);
                    System.out.println("Bye");
                    return;
                }
                boolean result = data.addUser(conn, userName,"customer", password);
                if(result == false){
                    System.out.print("The username already exist");
                }else{
                    System.out.println("SingupSuccessful");
                    while (true) {
                        System.out.println("Displaying product list ...");
                        ResultSet rs=data.getProductData();
                        //System.out.println(data.getProductNumber("milk"));
                        while (rs.next()) {
                            String productcode = rs.getString("productcode");
                            String productname = rs.getString("productname");
                            String producttype = rs.getString("producttype");
                            String productnumber = rs.getString("productnumber");
                            String productprice = rs.getString("productprice");
                            System.out.println(productcode+"\t"+productname+"\t"+producttype+"\t"+productnumber+"\t"+productprice);
                        }
                        System.out.println("please type the product type to buy product");
                        // timer
                        lastActiveTime = new Date();
                        Timerresult = true;
                        
                        String ppname = sc.nextLine();
                        
                        Timerresult = timer.run(lastActiveTime,ppname);
                        if(Timerresult == false){
                            customer.cancelaccept(data,conn);
                            return;
                        }
                        // timer end
                        if(ppname.equals("cancel")){
                            customer.cancelaccept(data,conn);
                            System.out.println("Bye");
                            return;
                        }
                        String result_ppname = customer.buyProduct(ppname, data, conn);
                        itemsold = result_ppname;
                        boolean flag1 = customer.getflag1();
                        if(flag1){
                            customer.cancelaccept(data,conn);
                            System.out.println("Bye");
                            return;
                        }else{
                            String way_pay = customer.choosePayment(conn, data);
                            if(way_pay.equals("false")){
                                customer.cancelaccept(data,conn);
                                return;
                            }
                            else if(way_pay.equals("Cash")){
                                paymentmethod = "Cash";
                                double cash_sum = calculatePayment.ask_cashInput(data,conn);     
                                moneypaid = Double.toString(cash_sum);
                                
                                boolean flag = calculatePayment.getflag();
                                if(flag){
                                    customer.cancelaccept(data,conn);
                                    return;
                                }else{
                                    data.addSoldname(conn, userName, result_ppname);
                                    String price = data.getProductprice(result_ppname);
                                    int number_product = customer.getn();
                                    cash_sum = cash_sum - Double.valueOf(price)*number_product;
                                    returnedchange = Double.toString(cash_sum);
                                    cash_used_list = calculatePayment.Calculate_Payment(result_ppname,cash_sum, conn, data);                
                                    boolean flag2 = calculatePayment.getflag2();
                                    if(flag2){
                                        customer.cancelaccept(data,conn);
                                        return;
                                    }else{
                                        String soldcode = data.getSoldCode(result_ppname);
                                        String datee = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                                        String soldnumber = data.getSoldNumber(result_ppname);
                                        String productnumber_string = data.getProductNumber(result_ppname);
                                        String productprice = data.getProductprice(result_ppname);
                                        calculatePayment.reduce_number_database(cash_used_list, conn, data);
                                        seller.addToSold(soldcode, result_ppname, ppname, soldnumber, productnumber_string, productprice, data, conn);
                                        data.addTransaction(conn, datee, itemsold, moneypaid, returnedchange, paymentmethod);
                                        while (true) {
                                            System.out.println("buy: buy again; quit");
                                            String c1 = sc.nextLine();
                                            if (c1.equals("buy")) {
                                                break;
                                            } else if (c1.equals("quit")) {
                                                System.out.println("Bye");
                                                return; 
                                            } else {
                                                System.out.println("Wrong charactor, try again please.");
                                            }
                                        }
                                    }
                                }
                            }
                            else if(way_pay.equals("Card")){
                                paymentmethod = "Card";
                                card_result = card.checkcard(data, conn, userName);
                                boolean flag3 = card.getflag();
                                if (flag3){
                                    customer.cancelaccept(data,conn);
                                    return;
                                }
                            }
                            
                        }
                    }
                    
                }
        }else{
            System.out.print("You entered wrong charactor");
        }



        // boolean signUpresult = signUp.customer_sign_up(userName, password);
        // System.out.println(signUpresult);
    }
}

