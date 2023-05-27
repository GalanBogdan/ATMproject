package org.example;


import java.text.DecimalFormat;
import java.util.Scanner;


public class Account {
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingsBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void calcCheckingWithdraw(double amount) {
        checkingBalance = (checkingBalance - amount);
    }

    public void calcSavingsWithdraw(double amount) {
        savingsBalance = (savingsBalance - amount);
    }

    public double calcCheckingDeposit(double amount) {
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }

    public double calcSavingsDeposit(double amount) {
        savingsBalance = (savingsBalance + amount);
        return savingsBalance;
    }

    public void getCheckingWithdrawInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to withdraw from Checking Account: ");
        double amount = input.nextDouble();
        if ((checkingBalance - amount) >= 0) {
            calcCheckingWithdraw(amount);
            System.out.println("New checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Balance Cannot be Negative." + "\n");
        }
    }

    public void getCheckingDepositInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to deposit from Checking Account: ");
        double amount = input.nextDouble();
        if ((checkingBalance + amount) >= 0) {
            calcCheckingDeposit(amount);
            System.out.println("New checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Balance Cannot be Negative." + "\n");
        }
    }

    public void getSavingsWithdrawInput() {
        System.out.println("Savings Account Balance: " + moneyFormat.format(savingsBalance));
        System.out.println("Amount you want to Withdraw from Savings Account: ");
        double amount = input.nextDouble();
        if ((savingsBalance - amount) >= 0) {
            calcSavingsWithdraw(amount);
            System.out.println("New checking Account Balance: " + moneyFormat.format(savingsBalance));
        } else {
            System.out.println("Balance Cannot be Negative." + "\n");
        }
    }

    public void getSavingsDepositInput() {
        System.out.println("Savings Account Balance: " + moneyFormat.format(savingsBalance));
        System.out.println("Amount you want to Deposit from Savings Account: ");
        double amount = input.nextDouble();
        if ((savingsBalance + amount) >= 0) {
            calcSavingsDeposit(amount);
            System.out.println("New checking Account Balance: " + moneyFormat.format(savingsBalance));
        } else {
            System.out.println("Balance Cannot be Negative." + "\n");
        }
    }

}
