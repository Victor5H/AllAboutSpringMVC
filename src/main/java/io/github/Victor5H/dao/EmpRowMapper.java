package io.github.Victor5H.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import io.github.Victor5H.model.Employee;

public class EmpRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setId(rs.getInt(1));
		employee.setName(rs.getString(2));
		employee.setEmail(rs.getString(3));
		return employee;
	}
}
