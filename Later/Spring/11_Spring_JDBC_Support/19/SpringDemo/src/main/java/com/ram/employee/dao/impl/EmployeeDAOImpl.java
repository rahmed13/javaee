package com.ram.employee.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.ram.employee.dao.EmploeyeeDAO;
import com.ram.employee.model.Employee;

public class EmployeeDAOImpl implements EmploeyeeDAO
{
	private SimpleJdbcInsert simpleJdbcInsert;

	public void setDataSource(DataSource dataSource)
	{
		this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
				.withTableName("EMPLOYEE")
				.usingGeneratedKeyColumns("EMPLOYEE_ID");
	}

	public void insert(Employee employee)
	{

		SqlParameterSource parameters = new BeanPropertySqlParameterSource(
				employee);
		Number newEmployeeId = simpleJdbcInsert
				.executeAndReturnKey(parameters);
		System.out.println("newEmployeeId = " + newEmployeeId);

	}
}
