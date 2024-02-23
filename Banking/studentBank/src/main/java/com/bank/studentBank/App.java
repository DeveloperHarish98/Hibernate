package com.bank.studentBank;

import java.util.Scanner;

public class App 
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		BankDAO22 bo=new BankDAO22();
		while(true) {
			System.out.println(" WELCOME TO BANK OF STUDENT ");
			System.out.println();
			System.out.println(" Enter Choice...\n 1.Create New Bank Account \n 2.Delete Account \n 3.Modify Account \n 4.Check Account details \n 5.Money Transection \n 6.Exit");
			int choice=sc.nextInt();
			switch (choice) {
			case 1:
				bo.insertAccountDetails();
				break;
			case 2:
				bo.deleteAccount();
				break;
			case 3:
				bo.modifyAccount();
				break;
			case 4:
				bo.readAccount();
				break;
			case 5:
				bo.moneyTranction();
				break;
			case 6:
				System.out.println("Thank you...");
				return;

			default:
				System.out.println(" wrong choice...");
				break;
			}
		}
	}
}
