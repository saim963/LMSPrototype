package com.SStech.LMSPrototype.controllers;

import ch.qos.logback.core.net.server.Client;
import com.SStech.LMSPrototype.models.Student;
import com.SStech.LMSPrototype.models.StudentDto;
import com.SStech.LMSPrototype.repositories.StudentRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepo repo;

    @GetMapping
    public String getStudents(Model model) {
        List<Student> students = repo.getStudents();
        model.addAttribute("students", students);
        return "students/index";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        StudentDto studentDto = new StudentDto();
        model.addAttribute("studentDto", studentDto);
        return "students/create";
    }

    @PostMapping("/create")
    public String createStudent(
            @Valid
            @ModelAttribute StudentDto studentDto,
            BindingResult result
    ) {
        if (repo.getStudent(studentDto.getEmail()) != null) {
            result.addError(
                    new FieldError("studentDto", "email", studentDto.getEmail(),
                            false, null, null, "Email address is already used")
            );
        }
        if (result.hasErrors()) {
            return "students/create";
        }

        Student student = new Student();
        student.setName(studentDto.getName());
        student.setContactNo(studentDto.getContactNo());
        student.setEmail(studentDto.getEmail());
        student.setSeatNo(studentDto.getSeatNo());
        student.setShift(studentDto.getShift());
        student.setPaymentStatus(studentDto.getPaymentStatus());
        student.setStartDate(studentDto.getStartDate());

        repo.createStudent(student);

        return "redirect:/students";
    }
}