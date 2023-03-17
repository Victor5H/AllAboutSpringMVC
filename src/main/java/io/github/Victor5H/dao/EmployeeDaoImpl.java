package io.github.Victor5H.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import io.github.Victor5H.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	@Qualifier("template")
	JdbcTemplate template;

	public EmployeeDaoImpl() {
		super();
	}

	public EmployeeDaoImpl(JdbcTemplate template) {
		super();
		this.template = template;
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public boolean insert(Employee employee) {
		String query = "insert into employee values (?,?,?)";
		int r = template.update(query, employee.getId(), employee.getName(), employee.getEmail());
		if (r >= 1)
			return true;
		return false;
	}

	@Override
	public boolean delete(int id) {
		String query = "delete from employee where id = ?";
		int r = template.update(query, id);
		if (r >= 1)
			return true;
		return false;
	}

	@Override
	public boolean update(Employee employee) {
		String query = "update employee set name=? , email =? where id =?";
		int r = template.update(query, employee.getName(), employee.getEmail(), employee.getId());
		if (r >= 1)
			return true;
		return false;
	}

	@Override
	public List<Employee> selectAll() {
		String query = "select * from employee ";
		return template.query(query, new EmpRowMapper());
	}

	@Override
	public Employee selectOne(int id) {
		String query = "select * from employee where id = ? limit 1";
		Employee employee = null;
		try {
			employee = template.queryForObject(query, new EmpRowMapper(), id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(employee);
		return employee;
	}
}
