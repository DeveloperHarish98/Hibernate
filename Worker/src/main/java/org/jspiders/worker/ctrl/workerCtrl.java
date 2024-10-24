package org.jspiders.worker.ctrl;

import java.util.Scanner;

import org.jspiders.worker.dao.workerDAO;


public class workerCtrl {
	static Scanner sc = new Scanner(System.in);
	static workerDAO wo = new workerDAO();
	public static void main(String[] args) {
		while (true) {
			System.out.println();
			System.out.println("  [ KGF WORKERS PORTAL ]  ");
			System.out.println();
			System.out.println(" 1.Add New Worker Data \n 2.Delete Worker Data \n 3.Modify Worker Data \n 4.Check Worker details \n 5.Exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				wo.insert();
				break;
			case 2:
				wo.delete();
				break;
			case 3:
				wo.modify();
				break;
			case 4:
				wo.details();
				break;
			case 5:
				System.out.println("Thank you...Have a great day ahead!!!");
				break;
			default:
				System.out.println("You have entered wrong choice, Please Enter Correct choice...!!!");
				break;
			}
		}
	}
}
