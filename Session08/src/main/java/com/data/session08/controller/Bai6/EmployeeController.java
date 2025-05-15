package com.data.session08.controller.Bai6;

import com.data.session08.model.Bai6.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employeeList = new ArrayList<>();

    @GetMapping
    public String showEmployeeList(Model model) {
        model.addAttribute("employees", employeeList);
        return "Bai6/listEmployee";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "Bai6/addEmployee";
    }

    @PostMapping
    public String addEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        employeeList.add(employee);
        model.addAttribute("successMessage", "Thêm nhân viên thành công!");
        model.addAttribute("employees", employeeList);
        return "Bai6/listEmployee";
    }
}

