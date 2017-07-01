package com.acad.spring4Assignment3.customer.model;

import java.io.Serializable;

public class Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int custId;
	String name;
	int age;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(int custId, String name, int age) {
		super();
		this.custId = custId;
		this.name = name;
		this.age = age;
	}


	public long getCustId() {
		return custId;
	}


	public void setCustId(int custId) {
		this.custId = custId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
	
	
	

}
