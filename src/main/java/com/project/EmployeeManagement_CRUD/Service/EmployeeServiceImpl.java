package com.project.EmployeeManagement_CRUD.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.EmployeeManagement_CRUD.Dao.EmployeeRepository;
import com.project.EmployeeManagement_CRUD.Dao.UsersRepository;
import com.project.EmployeeManagement_CRUD.Model.Employee;
import com.project.EmployeeManagement_CRUD.Model.Users;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
	private PasswordEncoder passwordEncoder;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id).get();
        if (employee != null) {
            employee.setName(employeeDetails.getName());
            employee.setEmail(employeeDetails.getEmail());
            employee.setDepartment(employeeDetails.getDepartment());
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

	@Override
	public Users getUsersLogin(Users users) {
		users.setPassword(passwordEncoder.encode(users.getPassword()));
		users.setConfirmPassword(passwordEncoder.encode(users.getConfirmPassword()));
		return usersRepository.save(users);
	}
}

