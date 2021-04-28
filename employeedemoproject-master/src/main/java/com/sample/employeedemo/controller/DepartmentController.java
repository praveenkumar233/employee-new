package com.sample.employeedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.employeedemo.entity.Department;
import com.sample.employeedemo.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	
	@PutMapping("/Department")
	public String updateDepartmentName(@RequestBody Department department) {
		return departmentService.updateDepartmentName(department);
	}
	
	@PostMapping("/Department")
	public String saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/Department")
	public List<Department> getAllDepartment(){
		return departmentService.getAllDepartment();
	}
}
