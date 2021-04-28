package com.sample.employeedemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.employeedemo.entity.Department;
import com.sample.employeedemo.entity.Employee;
import com.sample.employeedemo.repository.EmployeeRepository;

@Service
public class EmployeeService {


	@Autowired
	EmployeeRepository employeeRepository;

	public Employee getEmployeeById(int empId) {
		return employeeRepository.findById(empId).get();

	}

	public String saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "Employee Data Saved!!";
	}

	public List<Employee> getEmployeesBasedOnDesignation(String designation){
		return employeeRepository.getEmployeesBasedOnDesignation(designation);

	}

	public List<Employee> getAllEmployees() {
		List<Employee> employeeList=new ArrayList<Employee>();
		employeeRepository.findAll().forEach(emp->employeeList.add(emp));
		return employeeList;
	}

	public List<Employee> getAllEmployeeByDepartmentId(Department deptId) {
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeRepository.getAllEmployeeByDepartmentId(deptId).forEach(employee->employeeList.add(employee));
		return employeeList;
	}


	public List<Employee> findAllEmployeeWithSalaryGreaterThan10K(){
		return 	employeeRepository.findAllEmployeeWithSalaryGreaterThan10K();
	}

	public List<Employee> getEmpWithSalGreterThan10KAndDeptID(Department deptId) {
		// TODO Auto-generated method stub
		return 	employeeRepository.getEmpWithSalGreterThan10KAndDeptID(deptId);
	}
}
