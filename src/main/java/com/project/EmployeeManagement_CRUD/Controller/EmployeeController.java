
package com.project.EmployeeManagement_CRUD.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.EmployeeManagement_CRUD.Model.Employee;
import com.project.EmployeeManagement_CRUD.Model.Users;
import com.project.EmployeeManagement_CRUD.Service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
    private EmployeeService employeeService;
	
	@GetMapping("/allEmployees")
	public String viewHomePage(Model model) {
	    model.addAttribute("employees", employeeService.getAllEmployees());
	    return "index";
	}

	@PostMapping("/getUsersLogin")
	public String getUsersLogin(Users users) {
		employeeService.getUsersLogin(users);
		return "home";
	}
		
	@GetMapping("/addEmployee")
	public String showNewEmployeeForm(Model model) {
	    Employee employee = new Employee();
	    model.addAttribute("employee", employee);
	    return "form";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
	    employeeService.saveEmployee(employee);
	    return "redirect:/allEmployees";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
	    Employee employee = employeeService.getEmployeeById(id);
	    model.addAttribute("employee", employee);
	    return "employeeEdit";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {
	    employeeService.deleteEmployee(id);
	    return "redirect:/allEmployees";
	}

}
