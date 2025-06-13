package com.project.EmployeeManagement_CRUD.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.EmployeeManagement_CRUD.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

