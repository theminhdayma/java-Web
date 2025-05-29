package com.data.session15.controller.Bai2;

import com.data.session15.model.Bai2.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {

    @GetMapping("/students")
    public String getStudents(Model model) {
        List<Student> studentList = Arrays.asList(
                new Student("SV001", "Nguyen Van A", 20, "CTK42", "a@example.com", "Hanoi", "0123456789"),
                new Student("SV002", "Tran Thi B", 21, "CTK42", "b@example.com", "HCM", "0987654321"),
                new Student("SV003", "Le Van C", 22, "CTK43", "c@example.com", "Da Nang", "0112233445")
        );

        model.addAttribute("students", studentList);
        return "Bai2/students";
    }
}
