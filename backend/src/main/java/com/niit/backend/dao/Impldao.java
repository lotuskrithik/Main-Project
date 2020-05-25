package com.niit.backend.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Impldao implements Empdao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> getEmployeeList() {
		
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	@Override
	public Employee getEmployee(int emplId) {
		
		return (Employee)sessionFactory.getCurrentSession().createQuery("from Employee where emplId="+emplId).uniqueResult();
	}

	@Override
	public boolean addEmployee(Employee emp) {
		try
		{
			sessionFactory.getCurrentSession().save(emp);
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		try
		{
			sessionFactory.getCurrentSession().update(emp);
			return true;
		}
		catch(Exception e) {
			return false;
			
		}

	}

	@Override
	public boolean deleteEmployee(int emplId) {
		
		try
		{
			sessionFactory.getCurrentSession().delete(findbyId(emplId));
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}

	@Override
	public Employee findbyId(int emplId) {
		
		return (Employee)sessionFactory.getCurrentSession().createQuery("from Employee where emplId="+emplId).uniqueResult();
	}

	@Override
	public List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployee(int emplId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findbyId(int emplId) {
		// TODO Auto-generated method stub
		return null;
	}

}
