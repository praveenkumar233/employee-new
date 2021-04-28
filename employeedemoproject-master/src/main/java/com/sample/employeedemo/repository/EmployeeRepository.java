package com.sample.employeedemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sample.employeedemo.entity.Department;
import com.sample.employeedemo.entity.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Integer>{
	
	@Query("SELECT e FROM Employee e WHERE e.salary>=10000 ORDER BY e.name ASC")
	public List<Employee> findAllEmployeeWithSalaryGreaterThan10K();
	
	@Query("SELECT e FROM Employee e WHERE e.salary>=10000 AND e.departmentId=?1 ORDER BY e.salary DESC")
	public List<Employee> getEmpWithSalGreterThan10KAndDeptID(Department deptId);

	@Query("SELECT e FROM Employee e WHERE e.designation=?1")
	public List<Employee> getEmployeesBasedOnDesignation(String designation);

	@Query("SELECT e FROM Employee e WHERE e.departmentId=?1")
	public List<Employee> getAllEmployeeByDepartmentId(Department deptId);



}
