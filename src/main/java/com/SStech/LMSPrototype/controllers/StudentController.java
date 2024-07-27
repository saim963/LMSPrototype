package com.SStech.LMSPrototype.controllers;

import ch.qos.logback.core.net.server.Client;
import com.SStech.LMSPrototype.models.Student;
import com.SStech.LMSPrototype.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepo repo;

    @GetMapping
    public String getStudents(Model model){
        List<Student> students = repo.getStudents();
        model.addAttribute("students",students);
        return "students/index";
    }
}
