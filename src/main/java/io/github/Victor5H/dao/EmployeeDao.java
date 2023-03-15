package io.github.Victor5H.dao;

import java.util.List;

import io.github.Victor5H.model.Employee;

public interface EmployeeDao {
	boolean insert(Employee employee);

	boolean delete(int id);

	boolean update(Employee employee);

	List<Employee> selectAll();

	Employee selectOne(int id);
}
