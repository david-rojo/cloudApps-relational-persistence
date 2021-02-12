package com.cloudapps.relational_persistence.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.relational_persistence.model.mysql.Employee;

/**
 * 
 * @author David Rojo Antona
 *
 */

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
