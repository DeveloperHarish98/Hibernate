package org.jspiders.worker.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "WorkersList")
public class workerDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Worker_ID")
	private int id;
	@Column(name = "Wname", nullable = false)
	private String name;
	@Column(name = "Wnumber",nullable=false, unique = true)
	private long number;
	@Column(name = "Wemail", nullable = false, unique = true)
	private String email;
	@Column(name = "Wpassword", nullable = false)
	private String password;

	public workerDTO() {
		
	}
//	public workerDTO(String name, long number, String email, String password) {
//		super();
//		
//		this.name = name;
//		this.number = number;
//		this.email = email;
//		this.password = password;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
