package io.github.Victor5H.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.Victor5H.dao.EmployeeDao;
import io.github.Victor5H.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public boolean insertEmp(Employee employee) {

		return employeeDao.insert(employee);
	}

	@Override
	public boolean deleteEmp(int id) {

		return employeeDao.delete(id);
	}

	@Override
	public boolean updateEmp(Employee employee) {

		return employeeDao.update(employee);
	}

	@Override
	public Employee selectEmpById(int id) {

		return employeeDao.selectOne(id);
	}

	@Override
	public List<Employee> selectAllEmp() {

		return employeeDao.selectAll();
	}

}
