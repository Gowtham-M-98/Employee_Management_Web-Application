package com.project.EmployeeManagement_CRUD.Service;

import java.util.List;

import com.project.EmployeeManagement_CRUD.Model.Employee;
import com.project.EmployeeManagement_CRUD.Model.Users;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
	Users getUsersLogin(Users users);
}

