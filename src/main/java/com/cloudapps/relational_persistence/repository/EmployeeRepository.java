package com.cloudapps.relational_persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.relational_persistence.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
