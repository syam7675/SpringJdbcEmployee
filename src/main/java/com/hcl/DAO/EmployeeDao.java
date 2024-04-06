package com.hcl.DAO;

import java.util.List;

import com.hcl.beans.Employee;

public interface EmployeeDao {
	
	public int insert(Employee employee);
	public int updates(Employee employee);
	public List<Employee> getAllRecords();
	public int delete(String name);
	public Employee getEmployee(String name);

}
