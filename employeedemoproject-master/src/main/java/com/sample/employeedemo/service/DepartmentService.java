package com.sample.employeedemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.employeedemo.entity.Department;
import com.sample.employeedemo.repository.DepartmentRepository;

@Service
public class DepartmentService {

	
	@Autowired
	DepartmentRepository departmentRepository;
	
	public String updateDepartmentName(Department department) {
		Department updateDepartment=departmentRepository.findById(department.getId()).get();
		updateDepartment.setName(department.getName());
		departmentRepository.save(updateDepartment);
		return "Department Name Updated!!";
	}

	
	public String saveDepartment(Department department) {
		
		departmentRepository.save(department);
		return "Department Saved!!";
	}
	
	public List<Department> getAllDepartment(){
		List<Department> department = new ArrayList<Department>();
		departmentRepository.findAll().forEach(dep->department.add(dep));
		return department;
	}
}
