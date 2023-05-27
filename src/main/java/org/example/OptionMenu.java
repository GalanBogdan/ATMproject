package org.example;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(952141, 191904);
                data.put(989947, 71976);
                System.out.println("Welcome to the ATM machine!");
                System.out.println("Enter your customer Number");
                int customerNumber = menuInput.nextInt();

                System.out.println("Enter your PIN Number: ");
                int pinNumber = menuInput.nextInt();

                if (isValidLogin(customerNumber, pinNumber)) {
                    setCustomerNumber(customerNumber);
                    setPinNumber(pinNumber);
                    x = 2; // Break the loop
                } else {
                    System.out.println("\n" + "Invalid credentials. Please try again." + "\n");
                }
            } catch (Exception e) {
                System.out.println("\n" + "Invalid Character(s). Only Numbers." + "\n");
                menuInput.nextLine(); // Clear the input buffer
            }
        } while (x == 1);

        getAccountType();
    }

    private boolean isValidLogin(int customerNumber, int pinNumber) {
        Integer pin = data.get(customerNumber);
        return pin != null && pin == pinNumber;
    }



    public void getAccountType() {
        System.out.println("Select the Account you want to access: ");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Savings Account");
        System.out.println("Type 3 - Exit");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;

            case 2:
                getSavings();
                break;

            case 3:
                System.out.println("Thank you for using the ATM, bye. \n");
                break;

            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getAccountType();
        }
    }

    public void getChecking() {
        System.out.println("Checking Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using the ATM machine, bye");
                break;
            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getChecking();
        }
    }

    public void getSavings() {
        System.out.println("Saving Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving account balance: " + moneyFormat.format(getSavingsBalance()));
                getAccountType();
                break;
            case 2:
                getSavingsWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingsDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using the ATM, Bye.");
                break;
            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getSavings();
        }
    }
}