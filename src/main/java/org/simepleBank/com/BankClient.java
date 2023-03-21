package org.simepleBank.com;

import java.util.Scanner;

public class BankClient {
    private int current = -1;
    private Scanner scanner = new Scanner(System.in);
    private boolean done = false;
    private Bank bank = new Bank();


    public void run(){
        scanner = new Scanner(System.in);
        while (!done){
            System.out.println("Enter command (0=quit, 1=new,\n" +
                    "2=select, 3=deposit, 4=loan,\n" +
                    "5=show, 6=interest, 7=setforeign):");

            int cmd = scanner.nextInt();
            processCommand(cmd);
        }
        scanner.close();
    }

    private void processCommand(int cmd) {

        if (cmd == 0) {quit();}
        else if (cmd == 1){ newAccount();}
        else if (cmd == 2){ select();}
        else if (cmd == 3) {deposit();}
        else if (cmd == 4) {authorizeLoan();}
        else if (cmd == 5) {showAll();}
        else if (cmd == 6) {addInterest();}
        else if (cmd == 7) setForeign();
        else {
            System.out.println("Illegal command");


        }
    }

    private void setForeign() {
        bank.setForeign(current, requestForeign());
    }

    private boolean requestForeign() {
        System.out.print("Enter 1 for foreign, 2 for domestic: ");
        int val = scanner.nextInt();

        return (val == 1);

    }

    private void addInterest() {
        bank.addInterest();
    }

    private void showAll() {
        System.out.println(bank.toString());
    }

    private void authorizeLoan() {
        System.out.println("Enter Deposit amount: ");
        int loanamt = scanner.nextInt();
        if (bank.authorizeLoan(current, loanamt)){
            System.out.println("your loan is approved");
        }else{
            System.out.println("your loan is denied");
        }

    }

    private void deposit() {
        System.out.print("Enter deposit amt: ");
        int amt = scanner.nextInt();
        bank.deposit(current, amt);
    }


    private void select() {
        System.out.print("Enter acct#: ");
        current = scanner.nextInt();
        int balance = bank.getBalance(current);
        System.out.println("The balance of account "
                + current + " is " + balance);
    }

    private void newAccount() {
        boolean isforeign = requestForeign();
        current = bank.newAccount(isforeign);
        System.out.println("Your new Account is" + current);
    }

    private void quit() {
        done = true;
        System.out.println("Goodbye!");
    }



    

}
