package com.pma.controllers;

import com.pma.deo.EmployeeRepository;
import com.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public String displayEmployees(Model model){
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employeesList",employees);
        return "employees/list-employees";

    }
    @GetMapping("/new")
    public String displayEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "employees/new-employee";

    }

    @PostMapping("/save")
    public String createEmployee(@Valid Employee employee, Model model){
        employeeRepository.save(employee);
        return "redirect:/employees/new";
    }

    @GetMapping("/update")
    public String displayEmployeeUpdateForm(@RequestParam("id") long theId, Model model){
        Employee theEmp = employeeRepository.findByEmployeeId(theId);
        model.addAttribute("employee", theEmp);
        return "employees/new-employee";
    }

    @GetMapping("delete")
    public String deleteEmployee(@RequestParam("id") long theId, Model model){
        Employee theEmp = employeeRepository.findByEmployeeId(theId);
        employeeRepository.deleteById(theId);
        return "redirect:/employees";
    }
}
