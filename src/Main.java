import DISPLAY.TermsAndConditions;
import DISPLAY.UserMenu;
import DISPLAY.asciiArt;
import DISPLAY.clearScreen;
import DISPLAY.intro;
import DISPLAY.loading;
import DISPLAY.mainmenu;
import ExpenseTracker.AccountUpdater;
import ExpenseTracker.DeleteAccount;
import ExpenseTracker.MyAccount;
import ExpenseTracker.TemporaryDatabase;
import ExpenseTracker.UpdateAccount;
import ExpenseTracker.login;
import ExpenseTracker.register;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String email = "", password = "", nickname = "";
        double income = 0.0;
        int choice = 0;
        char agree;
        String confirmation;
        String registeredEmail, registeredPassword;
        String electricityDate, waterDate, rentDate, internetDate;

        TermsAndConditions terms = new TermsAndConditions();
        mainmenu mainmenu = new mainmenu();
        loading load = new loading();
        clearScreen clr = new clearScreen();
        register register = new register();
        TemporaryDatabase db = new TemporaryDatabase();
        login login = new login();
        asciiArt art = new asciiArt();
        intro intro = new intro();
        UserMenu userMenu = new UserMenu();
        MyAccount myAccount = new MyAccount();
        DeleteAccount delete = new DeleteAccount();
        UpdateAccount update = new UpdateAccount();
        AccountUpdater updater = new AccountUpdater();

        
        //start
        clr.clearScreen();

        art.display();
        load.loading();
        clr.clearScreen();

        //intro.display(); 
        //may error sa intro.display

        
       mainloop : while (true) {

            //while (true) { 
                mainmenu.display();
                System.out.print("\n   Enter choice : ");
                
                try {
                    choice = s.nextInt();
                    s.nextLine(); 
                } catch (InputMismatchException e) {
                    System.out.println("Invalid choice. Please enter a valid number.");
                    clr.clearScreen();
                    s.nextLine(); 
                    continue;
                }

                        switch (choice) {
                            //registration
                            case 1: 
                                clr.clearScreen();
                                System.out.println("Registration");

                                while (true) {
                                    //email
                                    try {
                                        System.out.print("Enter Email: ");
                                        email = s.nextLine();

                                            if (email == null){
                                                System.out.println("Email is required.");
                                            }
                                            else if(!email.contains("@") || !email.contains(".")) {
                                                throw new Exception();
                                            }
                                            else{

                                                if(register.isEmailExist(email) == true){
                                                    System.out.println("Email already exists.");
                                                }
                                                else{
                                                    register.setEmail(email);
                                                    break;
                                                }
                                                
                                            }
                                            } catch (Exception e) {
                                        System.out.println("Invalid input for email. Please try again.");
                                    }
                                }

                                while (true) {
                                //pass
                                    try {
                                        System.out.print("Enter Password: ");
                                        password = s.nextLine();
                                        register.setPassword(password);
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid input for password. Please try again.");
                                    }
                                }


                                //nickname
                                while (true) {
                                    try {
                                        System.out.print("Enter Nickname: ");
                                        nickname = s.nextLine();
                                        register.setNickname(nickname);
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid input for nickname. Please try again.");
                                    }
                                }

                                //terms and conditions medyo mahaba
                                terms.display();

                                while (true) {

                                    try {
                                        System.out.print("\tDo you agree to the terms and conditions? (y/n): ");
                                        agree = s.nextLine().toLowerCase().charAt(0);
                                        if (agree == 'y' || agree == 'n') {
                                            break;
                                        } else {
                                            System.out.println("Invalid input. Please enter 'y' or 'n'.");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Invalid input. Please enter 'y' or 'n'.");
                                    }
                                }

                                if (agree == 'n') {
                                    System.out.println("You must agree to the terms and conditions to proceed.");
                                    break;
                                }

                                while (true) {
                                    try {
                                        System.out.print("Enter Income: ");
                                        income = Double.parseDouble(s.nextLine());
                                        register.setIncome(income);
                                        break;
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid input for income. Please enter a valid number.");
                                    } catch (Exception e) {
                                        System.out.println("An error occurred while entering income. Please try again.");
                                    }
                                }


                                /*utilities due dates keme */                               
                                while (true) {
                                    System.out.println("ELECTRICITY");
                                    System.out.print("Enter due date (YYYY-MM-DD): ");
                                    electricityDate = s.nextLine();
                                    if (register.isCorrectdate(electricityDate)) {
                                        register.setElectricity(electricityDate);
                                        break;
                                    }
                                }
                                
                            
                                while (true) {
                                    System.out.println("WATER");
                                    System.out.print("Enter due date (YYYY-MM-DD): ");
                                    waterDate = s.nextLine();
                                    if (register.isCorrectdate(waterDate)) {
                                        register.setWater(waterDate);
                                        break;
                                    }
                                }
                                
                            
                                while (true) {
                                    System.out.println("RENT");
                                    System.out.print("Enter due date (YYYY-MM-DD): ");
                                    rentDate = s.nextLine();
                                    if (register.isCorrectdate(rentDate)) {
                                        register.setRent(rentDate);
                                        break;
                                    }
                                }
                                
                            
                                while (true) {
                                    System.out.println("INTERNET");
                                    System.out.print("Enter due date (YYYY-MM-DD): ");
                                    internetDate = s.nextLine();
                                    if (register.isCorrectdate(internetDate)) {
                                        register.setInternet(internetDate);
                                        break;
                                    }
                                }

                                //end of utilities due dates keme
                                register.write();
                            
                                break;

                            case 2: 
                                //login
                                clr.clearScreen();
                                System.out.println("Login");

                                while (true) {
                                    try {
                                        System.out.print("Enter Email: ");
                                        email = s.nextLine();
                                        login.setEmail(email);
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid input for email. Please try again.");
                                    }
                                }

                                while (true) {
                                        try {
                                            System.out.print("Enter Password: ");
                                            password = s.nextLine();
                                            login.setPassword(password);
                                            break;
                                        } catch (Exception e) {
                                            System.out.println("Invalid input for password. Please try again.");
                                        }
                                }

                                boolean loginStatus = login.userLogin(login.getEmail(), login.getPassword());
                                if (loginStatus) {
                                    
                                UserMainMenu : while (true) {
                                    userMenu.display();
                                    System.out.println("Enter choice: ");
                                    int userChoice = s.nextInt();


                                    switch(userChoice){
                                        case 1:
                                        myAccountmenu : while (true) {
                                            myAccount.display();
                                            System.out.println("Enter choice: ");
                                            int accountChoice = s.nextInt();
                                            switch(accountChoice){
                                                case 1:
                                                    //change email                                  
                                                    updater.changeEmail();
                                                    break;    

                                                case 2:
                                                    //change password (final)
                                                    updater.changePassword();
                                                    break;
                                            
                                                   

                                                case 3:
                                                    
                                                    //change monthly income
                                                    updater.ChangeIncome();
                                                    

                                                case 4:
                                                    //deletion ng account
                                                    s.nextLine();
                                                    while (true) {
                                                        System.out.print("Enter your registered email: ");
                                                        registeredEmail = s.nextLine();
                                                        delete.setEmail(registeredEmail);
                                                    
                                                    
                                                        if (!delete.isCorrectEmail()) {
                                                            System.out.println("Email does not match the registered email.");
                                                            continue;  
                                                        }
                                                        else{
                                                            break;
                                                        }
                                                    }
                                                    
                                                    while(true){
                                                        System.out.print("Enter your password: ");
                                                        registeredPassword = s.nextLine();
                                                        delete.setPassword(registeredPassword);
                                                    
                                                    
                                                        if (!delete.isCorrectPassword()) {
                                                            System.out.println("Incorrect password.");
                                                            continue;  
                                                        }
                                                        else{
                                                            break;
                                                        }

                                                    }
                                                    
                                                        
                                                        System.out.print("Are you sure you want to delete your account? (y/n): ");
                                                        confirmation = s.nextLine().toLowerCase().trim();
                                                    
                                                        if (confirmation.charAt(0) == 'y') {
                                                            delete.delete();
                                                            break;
                                                            
                                                        } else {
                                                            System.out.println("Account deletion cancelled.");
                                                            
                                                            continue myAccountmenu;
                                                        } 

                                                        


                                                case 5:
                                                /**
                                                 * 
                                                 * 
                                                 * 
                                                 * 
                                                 * RAIN - PRINTING OF DATA SHARING AGREEMENT
                                                 * 
                                                 * 
                                                 * 
                                                 * 
                                                 * 
                                                 */
                                                //*ipapagawa kay rain */
                                                    //read data sharing agreement
                                                    break;

                                                case 6:
                                                /**
                                                 * 
                                                 * 
                                                 * 
                                                 * 
                                                 * RAIN - PRINTING HOW TO USE THE SYSTEM
                                                 * 
                                                 * 
                                                 * 
                                                 *                                         
                                                 */
                                                //*ipapagawa kay rain */
                                                    //help
                                                    break;

                                                case 7:
                                                
                                                    continue UserMainMenu;
                                                default:
                                                    System.out.println("Invalid choice. Please select a valid option.");
                                                    break;
                                            }//switch case of my accountAccount
                                        } //my account end loop
                                        
                                        

                                        /** 
                                         * 
                                         * 
                                         *  BRYAN - EXPENSE TRACKER  
                                         * 
                                         * 
                                         * 
                                         * */                                       
                                        case 2:
                                            //expense tracker
                                            break;


                                        case 3:
                                            //insights summary or history of the user expenses keme
                                            break;
                                        case 4:
                                            //logout
                                            continue mainloop;
                                        default:
                                            System.out.println("Invalid choice. Please select a valid option.");
                                            break;
                                    }
                                
                                } //end of user main menu loop

                                    }//login status
                                    else {
                                        System.out.println("Invalid email or password. Please try again.");
                                    }

                            
                                break;
                            





                            case 3: 
                                System.out.println("\n\tThnak you for using our application!");
                                break mainloop;

                            default:
                                System.out.println("Invalid choice. Please select a valid option.");
                                break;
                        }
                    //}
        }//end ng main loop
    }
}