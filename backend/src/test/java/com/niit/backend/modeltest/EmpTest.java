package com.niit.backend.modeltest;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.service.EmpService;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class EmpTest {
static EmpService EmplService;
	
	@BeforeClass
	public static void initialize() {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		context.refresh();
		System.out.println("bean intialization");
		EmplService = (EmpService) context.getBean("EmplService");
		System.out.println("succefully bean initiated");
	}
	
	//@Ignore
	@Test
	public void addEmptest() {
		
		Employee emp = new Employee();
		System.out.println("inside test");
		emp.setEmplId(1);
		emp.setFname("Logavarshan");
		emp.setEmail("Logu@outlook.com");
		emp.setPhone("9944947074");
		emp.setGender("Male");
		emp.setDesignation("Manager");
		EmplService.addEmployee(emp);
	}
	
	@Ignore
	@Test
	public void listEmployee()
	{
		List<Employee> listEmployee = EmplService.getEmployeeList();
		assertNotNull("problem in listing details:",EmplService.getEmployeeList());
		
		for(Employee emp:listEmployee)
		{
			System.out.println(emp.getEmplId()+":::"+emp.getFname()+":::"+emp.getEmail()+":::"+emp.getPhone()+":::"+emp.getGender()+":::"+emp.getDesignation());
		}
	}
	
	@Ignore
	@Test
	public void updateEmployee() {
		
		Employee emp = EmplService.getEmployee(9);
		emp.setFname("Logu");
		assertTrue("problem in updating employee:",EmplService.updateEmployee(emp));
		
	}
	
	@Ignore
	@Test
	public void deleteEmployee()
	{
		
		int emplId=9;
		System.out.println("In delete method");
		assertTrue("problem in deleting faculty:",EmplService.deleteEmployee(emplId));
		System.out.println("After delete");
		}
	


}
