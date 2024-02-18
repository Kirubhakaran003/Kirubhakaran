package com.gl.Employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Employee {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// Id is auto incremented
	
	private int Id;
	private String employeeName;
	private String employeeAddress;
	private String employeePhone;
	private float employeeSalary;
	public int getId() {
		return Id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public float getEmployeeSalary() {
		return employeeSalary;
	}
	public void setId(int id) {
		Id = id;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public void setEmployeeSalary(float employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public Employee(int id, String employeeName, String employeeAddress, String employeePhone, float employeeSalary) {
		super();
		Id = id;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeePhone = employeePhone;
		this.employeeSalary = employeeSalary;
	}
	
	//creating empty constructor
	public Employee() {}
	
	//creating constructor without id
	public Employee(String employeeName, String employeeAddress, String employeePhone, float employeeSalary) {
		super();
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeePhone = employeePhone;
		this.employeeSalary = employeeSalary;
	}
	
	
	
}
