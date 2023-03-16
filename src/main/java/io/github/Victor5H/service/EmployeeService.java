package io.github.Victor5H.service;

import java.util.List;

import io.github.Victor5H.model.Employee;

public interface EmployeeService {
	boolean insertEmp(Employee employee);

	boolean deleteEmp(int id);

	boolean updateEmp(Employee employee);

	Employee selectEmpById(int id);

	List<Employee> selectAllEmp();
}
