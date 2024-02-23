package com.bank.studentBank;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class BankDAO22 {
	private static Scanner sc;
	private static Session ss;
	static{
		sc=new Scanner(System.in);
		Configuration cf= new Configuration();
		cf.configure();
		SessionFactory sf=cf.buildSessionFactory();
		ss=sf.openSession();

	}
	AccountDTO22 ac= new AccountDTO22();
	public void insertAccountDetails() {
		System.out.println("1.Create Account Number, 2.Enter Name, 3.Enter Phone Number, 4.Enter Initial Balance");
		ac.setAccNumber(sc.nextLong());
		sc.nextLine();
		ac.setName(sc.nextLine());
		ac.setPhoneNumber(sc.next());
		ac.setBalance(sc.nextDouble());
		try {
			Transaction tr=ss.beginTransaction();
			ss.save(ac);
			tr.commit();
		} catch (Exception e) {
			System.out.println("Account is already existed....");
			return;
		}
		
		System.out.println("Account succesfully created .....");
	} 
	
	public void deleteAccount() {
			System.out.println("Enter the Account Number....");
			long id=sc.nextLong();
			try {
				AccountDTO22 ad=(AccountDTO22)ss.load(AccountDTO22.class, id);	
				Transaction tr=ss.beginTransaction();
				ss.delete(ad);
				tr.commit();
			} catch (Exception e) {
				System.out.println("Account is not exist....");
				return;
			}
			System.out.println("Account succesfully deleted.....");
	}
	public void modifyAccount() {
		System.out.println("Enter the Account Number...");
		long id=sc.nextLong();
		try {
			AccountDTO22 ad=(AccountDTO22)ss.load(AccountDTO22.class, id);	
			System.out.println("Press 1. For Change Name \n Press 2. For Change Phone Number");
			int key=sc.nextInt();
			switch (key) {
			case 1:
				System.out.println("Enter new Name");
//				ad.setName(sc.next());
				sc.nextLine();
				ad.setName(sc.nextLine());
				break;
			case 2:
				System.out.println("Enter new Phone Number ");
				ad.setPhoneNumber(sc.next());
				break;
			default:
				System.out.println("Invalid operation...");
				break;
			}
			Transaction tr=ss.beginTransaction();
			ss.update(ad);
			tr.commit();
		} catch (Exception e) {
			System.out.println("Account is not exist....");
			return;
		}
		System.out.println("Account succesfully updated.....");
		
	}
	public void readAccount() {
		System.out.println("Enter the Account Number ");	
		long id=sc.nextLong();

		try{
			AccountDTO22 ad=(AccountDTO22)ss.load(AccountDTO22.class, id);
			System.out.println("Account Holder Name : "+ad.getName());
			System.out.println("Account Number : "+ad.getAccNumber());
			System.out.println("Phone Number :"+ad.getPhoneNumber());
			System.out.println("Account Balance :"+ad.getBalance());

		} catch (Exception e) {
			System.out.println("Account is not exist....");
			return;
		}
		System.out.println("Thank you.....");
		
	}
	public void moneyTranction() {
		System.out.println("Enter the Account Number...");
		long id=sc.nextLong();
		try {
			AccountDTO22 ad=(AccountDTO22)ss.load(AccountDTO22.class, id);	
			System.out.println(" Press 1. For Deposit Money \n Press 2. For Withdrawl Money");
			int key=sc.nextInt();
			switch (key) {
			case 1:
				System.out.println("Enter Deposit Amount");
				double nbl = sc.nextDouble();
		        double bl  = ad.getBalance();
		                bl = bl + nbl;
				        ad.setBalance(bl);
				        System.out.println("Successfully Deposit, New Balance is : "+ bl +"/-");
				break;
				
			case 2:
				System.out.println("Enter Withdrawl Amount");
				double wb=sc.nextDouble();
				double mb=ad.getBalance();
				if(mb<wb) {
				System.out.println("WithDraw Unsuccessful, only : "+ mb +"/-"+" is left");
					}
					else
					{
						mb=mb-wb;
						double bbl = ad.getBalance();
						double mmb=mb;
						mmb= bbl - mmb;
						double bb=mmb;
						bb = ad.getBalance() - bb;
						ad.setBalance(bb);
						System.out.println("WithDraw Successful, Current Balance is : "+ bb +"/-");
					}
				break;
			default:
				System.out.println("Invalid operation...");
				break;
			}
			Transaction tr=ss.beginTransaction();
			ss.update(ad);
			tr.commit();
		} catch (Exception e) {
			System.out.println("Account is not exist...");
			return;
		}
	}
	
}
