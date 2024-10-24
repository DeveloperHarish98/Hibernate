package org.jspiders.worker.dao;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.jspiders.worker.dto.workerDTO;

public class workerDAO {
//	private static Scanner sc;
//	private static Session ss;
//	static {
		static Scanner sc = new Scanner(System.in);
		static Session ss = new Configuration().configure().buildSessionFactory().openSession();
	


		public void insert() {
			workerDTO dto=new workerDTO();
			System.out.println("Enter Worker Name");
			dto.setName(sc.nextLine()); 
			System.out.println("Enter Worker Number");
			dto.setNumber(sc.nextLong());
			System.out.println("Enter Worker Email");
			dto.setEmail(sc.next());
			System.out.println("Enter Worker Password");
			dto.setPassword(sc.next());
			try {	
				Transaction tr = ss.beginTransaction();
				ss.save(dto);
				tr.commit();
		  }	catch (Exception e) {
			  System.out.println("Account is not created or Already exist");
			return;
		  }
			System.out.println("Worker detailes are added with Unique ID: "+dto.getId());
		}

	public void delete() {
			System.out.println(" Enter Worker ID ");
			int id = sc.nextInt();
			try {
			workerDTO dto = (workerDTO) ss.load(workerDTO.class, id);
			Transaction tr = ss.beginTransaction();
			ss.delete(dto);
			tr.commit();
		} catch (Exception e) {
			System.out.println(" Worker ID is not exist... ");
			return;
		  }
			System.out.println(" Worker data is deleted... ");
		}
	
	public void modify() {
		System.out.println(" Enter Worker ID ");
		int id =sc.nextInt();
		try {
			workerDTO dto=(workerDTO)ss.load(workerDTO.class, id);
			System.out.println(" Enter 1. For Change Worker Name \n Enter 2. For Change Worker Number \n Enter 3. For Change Worker Email \n Enter 4. For Change Worker Password");
			int key = sc.nextInt();
			switch (key) {
			case 1:
				System.out.println("Enter New Name");
				sc.nextLine();
				dto.setName(sc.nextLine()); 
				break;
			case 2:
				System.out.println("Enter new Number ");
				dto.setNumber(sc.nextLong());
				break;
			case 3:
				System.out.println("Enter new Email ");
				dto.setEmail(sc.next());
				break;
			case 4:
				System.out.println("Enter new Password ");
				dto.setPassword(sc.next());
			default:
				System.out.println("Invalid operation...");
				break;
			}
			Transaction tr = ss.beginTransaction();
			ss.update(dto);
			tr.commit();
		} catch (Exception e) {
			System.out.println(" Worker ID is not exist... ");
			return;
		}
		System.out.println(" Worker data is succesfully modified... ");
	}

	public void details() {
		System.out.println(" Enter Worker ID ");
		int id = sc.nextInt();
		try {
			workerDTO dto=(workerDTO)ss.load(workerDTO.class, id);
			System.out.println("  KGF Worker details ... ");
			System.out.println();
			System.out.println("Worker Unique ID :" + dto.getId());
			System.out.println("Worker Name 	 :" + dto.getName());
			System.out.println("Worker Number 	 :" + dto.getNumber());
			System.out.println("Worker Email 	 :" + dto.getEmail());
			System.out.println("Worker Password	 :" + dto.getPassword());

		} catch (Exception e) {
			System.out.println();
			System.out.println(" Worker ID is not exist... ");
			return;
		}
		System.out.println();
		System.out.println();
	}
}
	

