package com.hcl.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.hcl.beans.Employee;
import com.hcl.config.RowMapperImpl;

@Component
public class EmployeeDaoImpl implements EmployeeDao{
	@Autowired
	JdbcTemplate jdbcTemplate;
	public int insert(Employee employee) {
		String insertQuery="insert into employee values(?,?,?)";
		int count=jdbcTemplate.update(insertQuery,employee.getName(),employee.getAge(),employee.getGender());
		
		return count;
	}

	public int updates(Employee employee) {
		String updateQuery="update employee set age=?,gender=? where name=?";
		int count=jdbcTemplate.update(updateQuery,employee.getAge(),employee.getGender(),employee.getName());
		
		return count;
	}

	public List<Employee> getAllRecords() {
		String selectQuery="Select * from employee";
		List<Employee> list=jdbcTemplate.query(selectQuery, new RowMapperImpl());
		return list;
	}

	public int delete(String name) {
		String deleteQuery="delete from employee where name=?";
		int count=jdbcTemplate.update(deleteQuery,name);
		return count;
	}

	public Employee getEmployee(String name) {
		String selectEmployeeQuery="select * from employee where name=?";
		Employee emp=jdbcTemplate.queryForObject(selectEmployeeQuery,new RowMapperImpl(),name); 
		return emp;
	}

}
