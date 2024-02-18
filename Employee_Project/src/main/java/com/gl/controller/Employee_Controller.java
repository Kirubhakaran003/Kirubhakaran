package com.gl.controller;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.Employee.Employee;

@Controller
public class Employee_Controller {
	@RequestMapping("/")
	public String index_page() {
		return "index";
	}

	@RequestMapping("/Employee_Page")
	public String empPage(Model data) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		try {
			Query q1 = session.createQuery("from Employee");
			List<Employee> employees = q1.getResultList();
			data.addAttribute("employees", employees);

		} catch (Exception ex) {
			System.out.println("hibernate error" + ex.getMessage());
		}
		return "Employee_Page";
	}

	@RequestMapping("/Add_Record")
	public String add_record() {
		return "Add_Record";

	}

	@PostMapping("/Add_details")
	public String addDetails(@RequestParam String employeeName, @RequestParam String employeeAddress,
			@RequestParam String employeePhone, @RequestParam float employeeSalary, Model data) {

		// session factory
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();
		try {
			Transaction tx = session.beginTransaction();

			Employee e1 = new Employee(employeeName, employeeAddress, employeePhone, employeeSalary);

			session.save(e1);

			Query q1 = session.createQuery("from Employee");
			List<Employee> employees = q1.getResultList();
			data.addAttribute("employees", employees);

			tx.commit();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		// After adding the employee details the return index page(1st page)
		return "Employee_Page";
	}

	@GetMapping("/update-form-employee")
	public String updateEmployee(@RequestParam int Id, Model data) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		try {
			Employee updateEmp = session.get(Employee.class, Id);
			data.addAttribute("employees", updateEmp);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return "Update_Page";
	}

	@PostMapping("/Update_Pages")
	public String updateSaveEmp(@RequestParam int Id, @RequestParam String employeeName,
			@RequestParam String employeeAddress, @RequestParam String employeePhone,
			@RequestParam float employeeSalary, Model data) {

		// session factory
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		try {
			Transaction tx = session.beginTransaction();

			Employee e1 = new Employee(Id, employeeName, employeeAddress, employeePhone, employeeSalary);
			session.update(e1);

			Query q1 = session.createQuery("from Employee");
			List<Employee> employees = q1.getResultList();
			data.addAttribute("employees", employees);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		// After updating the employee details the return index page(1st page)
		return "Employee_Page";
	}

	@GetMapping("/delete-employee")
	public String deleteCar(@RequestParam int Id, Model data) {

		// session factory
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		try {
			Transaction tx = session.beginTransaction();

			Employee deleteEmp = new Employee(Id, "", "", "", 0);
			session.delete(deleteEmp);

			Query q1 = session.createQuery("from Employee");
			List<Employee> employees = q1.getResultList();
			data.addAttribute("employees", employees);
			tx.commit();

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return "Employee_Page";
	}
}
