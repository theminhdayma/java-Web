package com.data.session07.controller.Bai10;

import com.data.session07.model.Bai10.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final List<Course> courseList = new ArrayList<>();
    private int nextId = 1;

    @GetMapping
    public String listCourses(Model model) {
        model.addAttribute("courses", courseList);
        return "Bai10/listCourse";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("course", new Course());
        return "Bai10/addCourse";
    }

    @PostMapping("/add")
    public String addCourse(@ModelAttribute Course course, RedirectAttributes redirectAttributes) {
        course.setId(nextId++);
        courseList.add(course);
        redirectAttributes.addFlashAttribute("message", "Thêm khóa học thành công!");
        return "redirect:/courses";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable int id, RedirectAttributes redirectAttributes) {
        courseList.removeIf(course -> course.getId() == id);
        redirectAttributes.addFlashAttribute("message", "Xóa khóa học thành công!");
        return "redirect:/courses";
    }
}
