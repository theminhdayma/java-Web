package com.data.controller;

import com.data.dto.CustomerDto;
import com.data.entity.Customer;
import com.data.entity.Role;
import com.data.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/addCustomer")
    public String showAddForm(Model model) {
        model.addAttribute("customer", new CustomerDto());
        return "register";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@Valid @ModelAttribute("customer") CustomerDto customerDto,
                              BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        Customer customer = new Customer();
        customer.setUsername(customerDto.getUsername());
        customer.setPassword(customerDto.getPassword());
        customer.setEmail(customerDto.getEmail());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setRole(Role.USER);
        customer.setStatus(true);

        boolean isAdded = customerService.addCustomer(customer);
        if (isAdded) {
            model.addAttribute("message", "Đăng ký thành công. Vui lòng đăng nhập!");
            return "login";
        } else {
            model.addAttribute("message", "Đăng ký thất bại!");
            return "register";
        }
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {
        Customer customer = customerService.login(username, password);
        if (customer != null) {
            session.setAttribute("customerId", customer.getId());
            session.setAttribute("username", customer.getUsername());
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng.");
            return "login";
        }
    }

}
