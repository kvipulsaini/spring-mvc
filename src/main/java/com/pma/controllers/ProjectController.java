package com.pma.controllers;

import com.pma.deo.EmployeeRepository;
import com.pma.deo.ProjectRepository;
import com.pma.entities.Employee;
import com.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("projects")
public class ProjectController {

    @Autowired
    ProjectRepository proRep;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public String displayProjects(Model model){
        List<Project> proejcts = proRep.findAll();
        model.addAttribute("projectsList",proejcts);
        return "projects/list-projects";

    }


    @RequestMapping("/new")
    public String displayProjectForm(Model model){

        Project aProject = new Project();
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("project",aProject);
        model.addAttribute("allEmployees",employees);
        return "projects/new-project";

    }

    @PostMapping("/save")
    public String createProject(Project project, Model model){
    // saving projects in database
        proRep.save(project);
        return "redirect:/projects/";
    }
}
