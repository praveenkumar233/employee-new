package com.sample.employeedemo.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sample.employeedemo.aop.EmployeeEntityListner;

import lombok.Data;

@Entity
@EntityListeners(EmployeeEntityListner.class)
@Data
@Table(name="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer employeeId;

	private String name;

	private Double salary;

	private Integer managerId;
	
	//Designation Enum used
	private Designation designation;

	@ManyToOne
	@JoinColumn(name="departmentId")
	private Department departmentId;
}
