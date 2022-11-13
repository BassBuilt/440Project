import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.sql.*;

public class Project {

    static final String jdbcURL = "jdbc:oracle:thin:@ora.csc.ncsu.edu:1521:orcl01";

    public static void main(final String[] args) {

        try {

            Class.forName("oracle.jdbc.OracleDriver");
            String user = "debass"; // For example, "jsmith"
            String passwd = "200053805"; // Your 9 digit student ID number

            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            conn = DriverManager.getConnection(jdbcURL, user, passwd);
            stmt = conn.createStatement();

            final String adminUserName = "admin";
            final String adminPassword = "1234";

            final Scanner keyboard = new Scanner(System.in);
            int userInput = 0;
            int lowerBound = 0;
            int upperBound = 0;
            Page currentPage = Page.START;
            User currentUser = null;
            boolean cont = false;

            switch (currentPage) {

                case START:
                    lowerBound = 1;
                    upperBound = 2;

                    while (!cont) {
                        System.out.print("1. Login\n2. Exit\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            currentPage = Page.LOGIN;
                            break;
                        case 2:
                            System.exit(0);
                            break;
                    }

                    break;
                case LOGIN:
                    lowerBound = 1;
                    upperBound = 2;

                    System.out.print("A. User ID\n> ");
                    final String username = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String password = keyboard.nextLine();

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            if (username.equals(adminUserName) && password.equals(adminPassword)) {
                                currentUser = User.ADMIN;
                            } else {
                                // TODO SQL to find out what type of employee they
                                // are
                            }

                            switch (currentUser) {
                                case ADMIN:
                                    currentPage = Page.ADMIN_LANDING;
                                    break;
                                case MANAGER:
                                    currentPage = Page.MANAGER_LANDING;
                                    break;
                                case CUSTOMER:
                                    currentPage = Page.CUSTOMER_LANDING;
                                    break;
                                case RECEPTIONIST:
                                    currentPage = Page.RECEPTIONIST_LANDING;
                                    break;
                                case MECHANIC:
                                    currentPage = Page.MECHANIC_LANDING;
                                    break;
                            }

                            break;
                        case 2:
                            currentPage = Page.START;
                            break;
                    }

                    break;
                case ADMIN_LANDING:
                    lowerBound = 1;
                    upperBound = 4;

                    while (!cont) {
                        System.out.print("1. System Set Up\n2. Add New Store\n3. Add New Service\n 4. Logout\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            currentPage = Page.ADMIN_SYSTEM_SETUP;
                            break;
                        case 2:
                            currentPage = Page.ADMIN_ADD_NEW_STORE;
                            break;
                        case 3:
                            currentPage = Page.ADMIN_ADD_NEW_SERVICE;
                            break;
                        case 4:
                            currentPage = Page.START;
                            break;
                    }
                    break;
                case ADMIN_SYSTEM_SETUP:
                    lowerBound = 1;
                    upperBound = 3;

                    final Scanner serviceInfo = getInputFileScanner(keyboard,
                            "A. Input file that contains the service general information\n> ");
                    final Scanner storeInfo = getInputFileScanner(keyboard,
                            "B. Input file that contains the store general information\\n> ");

                    while (!cont) {
                        System.out.print(
                                "1. Upload service general information\n2. Upload store general information\n3. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            // TODO parse the service file
                            break;
                        case 2:
                            // TODO parse the store file
                            break;
                        case 3:
                            currentPage = Page.ADMIN_LANDING;
                            break;
                    }
                    break;
                case ADMIN_ADD_NEW_STORE:
                    lowerBound = 1;
                    upperBound = 2;

                    System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine();

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case ADMIN_ADD_NEW_SERVICE:
                    lowerBound = 1;
                    upperBound = 2;

                    /* System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case CUSTOMER_LANDING:
                    lowerBound = 1;
                    upperBound = 2;

                    /* System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case CUSTOMER_VIEW_AND_UPDATE_PROFILE:
                    lowerBound = 1;
                    upperBound = 2;

                    /* System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case CUSTOMER_VIEW_PROFILE:
                    lowerBound = 1;
                    upperBound = 2;
/* 
                    System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case CUSTOMER_ADD_CAR:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case CUSTOMER_DELETE_CAR:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case CUSTOMER_VIEW_AND_SCHEDULE_SERVICE:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case CUSTOMER_VIEW_SERVICE_HISTORY:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case CUSTOMER_SCHEDULE_SERVICE:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case CUSTOMER_SCHEDULE_MAINTENANCE:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case CUSTOMER_SCHEDULE_REPAIR:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case CUSTOMER_ENGINE_SERVICES:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case CUSTOMER_EXHAUST_SERVICES:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case CUSTOMER_ELECTRICAL_SERVICES:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case CUSTOMER_TRANSMISSION_SERVICES:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case CUSTOMER_TIRE_SERVICES:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case CUSTOMER_HEATING_AND_AC_SERVICES:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case CUSTOMER_VIEW_CART_AND_SCHEDULE_SERVICE_TIME:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case CUSTOMER_SCHEDULE_SERVICES_IN_CART:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case CUSTOMER_INVOICES:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case CUSTOMER_VIEW_INVOICE_DETAILS:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case CUSTOMER_PAY_INVOICE:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case RECEPTIONIST_LANDING:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case RECEPTIONIST_ADD_NEW_CUSTOMER_PROFILE:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case RECEPTIONIST_FIND_CUSTOMERS_WITH_PENDING_INVOICES:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case MANAGER_LANDING:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case MANAGER_SETUP_STORE:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case MANAGER_ADD_EMPLOYEES:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case MANAGER_SETUP_OPERATIONAL_HOURS:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case MANAGER_SETUP_SERVICE_PRICES:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case MANAGER_SETUP_MAINTENANCE_SERVICE_PRICES:
                    lowerBound = 1;
                    upperBound = 2;

/*                     System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case MANAGER_SETUP_REPAIR_SERVICE_PRICES:
                    lowerBound = 1;
                    upperBound = 2;

                    /* System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case MANAGER_ADD_NEW_EMPLOYEE:
                    lowerBound = 1;
                    upperBound = 2;

                    /* System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case MECHANIC_LANDING:
                    lowerBound = 1;
                    upperBound = 2;

                    /* System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case MECHANIC_VIEW_SCHEDULE:
                    lowerBound = 1;
                    upperBound = 2;

                    /* System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                case MECHANIC_REQUEST_TIME_OFF:
                    lowerBound = 1;
                    upperBound = 2;

                    /* System.out.print("A. User ID\n> ");
                    final String input1 = keyboard.nextLine();
                    System.out.print("B. Password\n> ");
                    final String input2 = keyboard.nextLine(); */

                    while (!cont) {
                        System.out.print("1. Sign-In\n2. Go Back\n> ");
                        userInput = Integer.parseInt(keyboard.nextLine());
                        cont = validateUserNumericalInput(userInput, lowerBound, upperBound);
                    }

                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    break;
                default:
                    // TODO throw an error
                    break;

            }

        } catch (Throwable oops) {
            oops.printStackTrace();
        }
    }

    static boolean validateUserNumericalInput(final int input, final int lower, final int upper) {
        if (input >= lower && input <= upper) {
            return true;
        }
        System.out.println("Please input a number between " + lower + " and " + upper + ".");
        return false;
    }

    /**
     * Prompts the console to enter the name of the input file or file path.
     * Creates and returns a Scanner object for the associated file, or catches
     * the FileNotFoundException and re-prompts the console for alternate input.
     *
     * @param console
     *                Scanner object for command-line console
     * @return inputFileScanner Scanner object for input file
     */
    public static Scanner getInputFileScanner(final Scanner console, final String prompt) {
        Scanner inputFileScanner = null;
        while (inputFileScanner == null) {
            System.out.print(prompt);
            final String fileName = console.nextLine();
            try {
                inputFileScanner = new Scanner(new File(fileName));
            } catch (final FileNotFoundException e) {
                System.out.println("Error: file not found. Please try again.");
            }
        }
        return inputFileScanner;
    }

}
