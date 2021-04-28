package com.sample.employeedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.employeedemo.entity.Department;
import com.sample.employeedemo.entity.Employee;
import com.sample.employeedemo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/Employee/{id}")
	public Employee getEmployeeById(@PathVariable(name = "id") int empId) {
		return employeeService.getEmployeeById(empId);
	}
	
	@GetMapping("/Employee")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployees();
		
	}
	
	@GetMapping("/EmployeeBasedOnDepartment/{id}")
	public List<Employee> getAllEmployeeByDepartmentId(@PathVariable(name = "id") int deptId){
		Department department=new Department();
		department.setId(deptId);
		return employeeService.getAllEmployeeByDepartmentId(department);
	}
	
	@GetMapping("/EmployeeWithSalaryGreaterThan10K")
	public List<Employee> findAllEmployeeWithSalaryGreaterThan10K(){
		return employeeService.findAllEmployeeWithSalaryGreaterThan10K();
	}
	
	@GetMapping("/EmployeeWithSalaryGreaterThan10KInDept/{id}")
	public List<Employee> getEmpWithSalGreterThan10KAndDeptID(@PathVariable(name = "id") int deptId){
		Department department=new Department();
		department.setId(deptId);
		return employeeService.getEmpWithSalGreterThan10KAndDeptID(department);
		
	}
	
	@GetMapping("/EmployeeBasedOnDesignation/{designation}")
	public List<Employee> getEmployeesBasedOnDesignation(@PathVariable(name = "designation") String designation){
		return employeeService.getEmployeesBasedOnDesignation(designation);
		
	}
	
	@PostMapping("/Employee")
	public String saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
}
