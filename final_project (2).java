package final_project;

import java.util.Scanner;

/**
 *
 * @author hp
 */
public class test {

//..arrays to every methods
    static int numberOfUsers = 1;
    final static int MAX_USER_NUMBER = 20;
    static Scanner in = new Scanner(System.in);
    static String[] idCustemer = new String[MAX_USER_NUMBER];
    static String[] passwordCustemer = new String[MAX_USER_NUMBER];
    static String[] nameCustemer = new String[MAX_USER_NUMBER];
    static String[] phoneNumber = new String[MAX_USER_NUMBER];
    static double[] blance = new double[MAX_USER_NUMBER];
    static String inputUserId;

    public static void main(String[] args) {
        idCustemer[0]="123";
        passwordCustemer[0]="100200";
        nameCustemer[0]="nour";
        phoneNumber[0]="123";
        idCustemer[0]="123";
        boolean is_admin = false;//start the admin
        boolean is_user = false; // start the user
        boolean is_admin_login = false; // is admin login befor
        boolean is_user_login = false; // is user login befor
        boolean is_login = true; // start the program 

        System.err.println(" <=================== ~ Welcame a Bank System ~ =======================>       ");
        System.out.println("                                                 By: Noor El Afifi");
        System.out.println("                                                 Eng: Mahmoud Ashour       ");
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
        System.out.println("Login to the bank system:");

        String[] usernameAdmins = {"admin", "ahmed", "noor", "omar", "sama"};
        String[] passwordAdmins = {"123456", "10002000", "102030", "987654", "0123456"};

        while (is_login) {
            //-- choose is admin or not 
            loginList();
            System.out.print("Enter a number to login:");
            int chooseNumber = in.nextInt();
            if (chooseNumber == 1) {
                System.err.println("*Login as Administrator*");

                is_admin = true;
                //---
                while (is_admin) {

                    //is login correct (the initial value is equal to false)
                    boolean is_login_correct = false;
                    //check is login correct 
                    if (!is_admin_login) {//true 

                        is_login_correct = checkAdminLogin(usernameAdmins, passwordAdmins);
                    }
                    if (is_login_correct || is_admin_login) {
                        is_admin_login = true;//admin logged in from before
                        adminList();
                        System.out.println("");
                        System.out.println("Enter your choese:  ");
                        chooseNumber = in.nextInt();

                        switch (chooseNumber) {
                            case 1:
                                Creat_account();
                                System.out.println("********************************************************");

                                break;
                            case 2:

                                Deposit();
                                System.out.println("********************************************************");

                                break;
                            case 3:

                                Withdraw();
                                System.out.println("********************************************************");

                                break;
                            case 4:

                                Modify();
                                System.out.println("********************************************************");

                                break;
//                            case 5:
//                                Delete_account();
//
//                                break;
                            case 6:

                                serch_account();
                                System.out.println("\n********************************************************");

                                break;
                            case 7:

                                view_account();
                                System.out.println("********************************************************");

                                break;
                            case 8:
                                System.err.println("Login again.");
                                is_admin = false;// exit adminList && Back to loginList
                                break;
                            default:

                                System.err.println("Invalid option,Please try again.");
                        }
                    } else {
                        //when login is false (username || password) for admin 
                        System.err.print("Please,try again you have a problem .");
                        is_admin_login = false;
                        is_admin = false;
                    }
                }

            } else if (chooseNumber == 2) {

                is_user = true; //start users operations
                System.err.println("*Login as User*");
                while (is_user) {
                    boolean is_login_correct = false;

                    if (!is_user_login) {//true
                        //------+
                        System.out.print("Enter Id user:");
                        inputUserId = in.next();
                        // is_login_correct if true 
                        is_login_correct = checkUserLogin(idCustemer, passwordCustemer, inputUserId);
                    }
                    //  System.out.println("bbb : " + is_login_correct);
                    if (is_login_correct || is_user_login) {
                        is_user_login = true;//user logged in from before

                        userList();
                        //       System.out.println("aaa : " + is_login_correct);
                        System.out.print("Enter your choese:  ");
                        chooseNumber = in.nextInt();
                        //check is login correct
                        switch (chooseNumber) {
                            case 1:
                                viewAccountUser();

                                System.out.println("***************************************************");
                                break;

                            case 2:
                                WithdrawToUser();
                                System.out.println("***************************************************");
                                break;
                            case 3:
                                // if enter 3(exit) will show loginList again
                                System.out.println("Please logout .");
                                is_user_login = false;
                                is_user = false;
                                break;
                            default:
                                System.err.println("Invalid option,Please try again.");
                        }
                    } else {
                        //when login is false (id || password) for user
                        System.err.print("Please,try again you have a problem .");
                        is_user_login = false;
                        is_user = false;
                    }

                }
            } else if (chooseNumber == 3) {
                System.out.println("Exit");
                System.exit(0);
            } else {
                System.err.println("Error, try again .");

            }
        }
    }

    public static void loginList() {
        System.out.println("");
        System.out.println("1. " + "Login as Administrator");
        System.out.println("2. " + "Login as User");
        System.out.println("3. " + "Exit");
    }

    static void adminList() {//this list will print if the condition is true
        //  System.out.println("-------------------------------------------------------------");
        System.out.println("Enter the type of operation :");
        System.out.println("");
        System.out.println("1." + "Creat a new acount");
        System.out.println("2." + "Deposit an amount in the acount");
        System.out.println("3." + "Withdraw an amount in the acount");
        System.out.println("4." + "Modify the customer data");
        System.out.println("5." + "Delete a bank acount");
        System.out.println("6." + "Search for a bank acount");
        System.out.println("7." + "View all a bank acounts");
        System.out.println("8." + "Go back");
    }

    static void userList() {
        System.out.println("1. View bank acount information  ");
        System.out.println("2. Withdraw an amount in the account ");
        System.out.println("3. exit");

    }

    public static boolean checkAdminLogin(String[] usernameAdmins, String[] passwordAdmins) {

        System.out.print("Enter Username:");
        String inputUsername = in.next();

        System.out.print("Enter Password:");
        String inputPassword = in.next();

        for (int i = 0; i < usernameAdmins.length; i++) {
            if (usernameAdmins[i].equals(inputUsername)
                    && passwordAdmins[i].equals(inputPassword)) {
                return true;
            }
        }
        return false;
    }
//-Creat a new acount 

    static void Creat_account() {

        System.err.println(" *Creat a new acount* ");
        System.out.print("Custemer ID Number: ");
        idCustemer[numberOfUsers] = in.next();
        System.out.print("Custemer Name: ");
        nameCustemer[numberOfUsers] = in.next();
        System.out.print("Custemer password: ");
        passwordCustemer[numberOfUsers] = in.next();
        System.out.print("Custemer Phone Number: ");
        phoneNumber[numberOfUsers] = in.next();

        System.err.println("Your data has been stored successfully");
        double blance = 0.0;
        numberOfUsers++;// increases per lap
    }
//Deposit amount (add amount )

    static void Deposit() {

        System.err.println(" *Deposit an amount in the acount* ");

        int numberOfAdd = 0;
        System.out.print("Custemer ID Number: ");
        String inputIdCustemer = in.next();
        boolean isFound = false;
        for (int i = 0; i < idCustemer.length; i++) {
            if (inputIdCustemer.equals(idCustemer[i])) {
                isFound = true;
                System.out.print("How much do you want to add? ");
                numberOfAdd = in.nextInt();
                //  System.out.println("before: " + blance[i]);
                blance[i] += numberOfAdd;
                System.out.println("The blance is :" + blance[i] + "$");
            }
        }
        if (!isFound) {
            System.out.println("Your ID is not Found,try again");
        }

    }
//Withdraw amount 

    static void Withdraw() {

        System.err.println(" *Withdraw an amount in the acount* ");
        System.out.print("Custemer ID Number: ");
        String inputIdCustemer = in.next();
        boolean isFound = false;
        double withdraw;
        for (int i = 0; i < idCustemer.length; i++) {
            if (inputIdCustemer.equals(idCustemer[i])) {
                isFound = true;
                System.out.print("How much do you want to Withdraw? ");
                withdraw = in.nextDouble();
                if (blance[i] < withdraw) {//if blance less than withdraw
                    System.out.println("There is not enough money.");
                } //  System.out.println("before: " + blance[i]);
                else {
                    blance[i] -= withdraw;
                    System.out.println("The blance is: " + blance[i] + "$");
                }
            }
        }
        if (!isFound) {
            System.out.println("Your ID is not Found,try again");
        }

    }
//Modify paaword or phonenumber 

    static void Modify() {

        System.err.println(" *Modify the customer data* ");
        System.out.println("1." + "Edit password");
        System.out.println("2." + "Edit Phone Number");
        System.out.println("3." + "Go Back ");
        System.out.println("Enter your Choise: ");
        int choiceToModify = in.nextInt();
        boolean isFound = false;
        if (choiceToModify == 1) {
            System.err.println(" *Edit password* ");
            System.out.print("Custemer ID Number: ");
            String inputIdCustemer = in.next();
            for (int i = 0; i < idCustemer.length; i++) {
                if (inputIdCustemer.equals(idCustemer[i])) {
                    System.out.print("Enter New Password:");
                    passwordCustemer[i] = in.next();
                    isFound = true;
                }
            }
            if (!isFound) {
                System.out.println("Your ID is not Found");
            }
        } else if (choiceToModify == 2) {
            System.err.println(" *Edit Phone Number* ");
            System.out.print("Custemer ID Number: ");
            String inputIdCustemer = in.next();
            for (int i = 0; i < idCustemer.length; i++) {
                if (inputIdCustemer.equals(idCustemer[i])) {
                    System.out.print("Enter New Phone: ");
                    phoneNumber[i] = in.next();
                    isFound = true;
                }
            }//if id is not found 
            if (!isFound) {
                System.out.println("Your ID is not Found");
            }
            // Get me adminlist (8 operations)
        } else if (choiceToModify == 3) {
            adminList();//back to 8 operation 
        }
    }

    static void Delete_account() {

        System.err.println(" *Delete a bank acount* ");
        System.out.print("Custemer ID Number: ");
        String inputIdCustemer = in.next();
        boolean isFound = false;
        for (int i = 0; i < numberOfUsers; i++) {
            if (idCustemer[i].equals(inputIdCustemer)) {
                idCustemer[i] = "";
                nameCustemer[i] = "";
                phoneNumber[i] = "";
                passwordCustemer[i] = "";
                blance[i] = 0;
                isFound = true;
                System.out.println(" Account successfully deleted");
            }
        }
        if (!isFound) {
            System.out.println(" cannot find this account !!");
        }

    }

//serch_account ==>just enter your id 
    static void serch_account() {
        boolean isFound = false;
        System.err.println("*Search for a bank acount*");

        System.out.print("Custemer ID Number: ");
        String inputIdCustemer = in.next();

        for (int i = 0; i < idCustemer.length; i++) {
            if (inputIdCustemer.equals(idCustemer[i])) {
                System.out.print("Id:" + inputIdCustemer + "| Name: " + nameCustemer[i] + " |password: "
                        + passwordCustemer[i] + "| phone number :" + phoneNumber[i] + "| blance:" + blance[i]);
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("your ID is not Found");
        }
    }
//-view all acount in bank 

    public static void view_account() {
        System.err.println("*View all a bank acounts*");
        System.out.println("----- ");
        for (int i = 0; i < numberOfUsers; i++) {
            System.out.print("id : " + idCustemer[i]);
            System.out.print(" | name : " + nameCustemer[i]);
            System.out.print(" | password : " + passwordCustemer[i]);
            System.out.print(" | PhoneNumer : " + phoneNumber[i]);
            System.out.print(" | balance :" + blance[i] + "$");
            System.out.println(" ");
        }
        System.out.println("");
    }

//------methode for user -------
    public static boolean checkUserLogin(String[] idCustemer, String[] passwordCustemer, String inputUserId) {
        boolean isFound = false;
        System.out.print("Enter Password:");
        String inputPassword = in.next();
        for (int i = 0; i < idCustemer.length; i++) {
            if (inputUserId.equals(idCustemer[i])
                    && passwordCustemer[i].equals(inputPassword)) {
                isFound = true;
                return true;
            }
        }
        if (!isFound) {
            System.out.println("your ID is not found ");
        }

        return false;
    }

    public static void viewAccountUser() {
        System.err.println("*View bank acount information*  ");
        boolean isFound = false;
        //when the condition is true 
        for (int i = 0; i < numberOfUsers; i++) {

            if (idCustemer[i].equals(inputUserId)) {
                System.out.println("Id:" + idCustemer[i] + "| Name: " + nameCustemer[i] + " |password: "
                        + passwordCustemer[i] + "| phone number: " + phoneNumber[i] + "| blance:" + blance[i]);
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("this ID is not Found ");
        }
    }

    static void WithdrawToUser() {
        boolean isFound = false;
        System.err.println(" *Withdraw an amount in the account* ");
        for (int i = 0; i < idCustemer.length; i++) {
            if (inputUserId.equals(idCustemer[i])) {
                isFound = true;
                System.out.print("How much do you want to Withdraw? ");
                double withdraw = in.nextDouble();
                if (blance[i] < withdraw) {//when the blance less than withdraw 
                    System.out.println("There is not enough money.");
                } //  System.out.println("before: " + blance[i]);
                else {
                    blance[i] -= withdraw;
                    System.out.println("The blance is: " + blance[i] + "$");
                }
            }
        }
        if (!isFound) {
            System.out.println("this ID is not Found ");
        }
    }

}
