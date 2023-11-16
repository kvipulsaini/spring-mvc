package com.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pma.deo.EmployeeRepository;
import com.pma.deo.ProjectRepository;
import com.pma.dto.EmployeeProject;
import com.pma.dto.Projects;
import com.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
public class HomeController {
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {
        Map<String, Object>map = new HashMap<>();
        List<Project> projects = projectRepository.findAll();
        List<EmployeeProject> employeesProjectCount = employeeRepository.employeeProjects();
        List<Projects> projectStatus = projectRepository.Projects();
        // convert to json data
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectStatus);

        model.addAttribute("employeesProjectCount",employeesProjectCount);
        model.addAttribute("projectStatusCount", jsonString);
        model.addAttribute("projectsList",projects);
        return "main/home";

    }
}
