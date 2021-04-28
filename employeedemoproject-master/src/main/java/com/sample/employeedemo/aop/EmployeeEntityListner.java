package com.sample.employeedemo.aop;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sample.employeedemo.entity.Employee;

public class EmployeeEntityListner {
private static Log log = LogFactory.getLog(EmployeeEntityListner.class);
    
    @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(Employee employee) {
            log.info("[Employee AUDIT] About to update/delete user: " + employee.getName());
    }
    
    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyUpdate(Employee employee) {
        log.info("[Employee AUDIT] add/update/delete complete for user: " + employee.getName());
    }
    
    @PostLoad
    private void afterLoad(Employee employee) {
        log.info("[Employee AUDIT] user loaded from database: " + employee.getName());
    }

}
