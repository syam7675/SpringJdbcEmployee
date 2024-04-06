package com.hcl.config;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hcl.beans.Employee;

public class RowMapperImpl implements RowMapper<Employee> {

	public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		
		Employee emp=new Employee();
		emp.setName(resultSet.getString(1));
		emp.setAge(resultSet.getInt(2));
		emp.setGender(resultSet.getString(3));
		return emp;
	}

}
