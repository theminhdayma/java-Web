package com.data.controller;

import com.data.entity.Customer;
import com.data.entity.Order;
import com.data.service.CustomerService;
import com.data.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/profile")
    public String profilePage(@RequestParam(defaultValue = "0") int page,
                              Model model,
                              HttpSession session) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            return "redirect:/login";
        }

        model.addAttribute("customer", customer);

        int pageSize = 5;
        List<Order> orders = orderService.findByCustomerIdPaginated(customer.getId(), page, pageSize);
        int totalPages = orderService.countPagesByCustomerId(customer.getId(), pageSize);

        model.addAttribute("orders", orders);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "profile";
    }

    @PostMapping("/profile/update")
    public String updateCustomer(@ModelAttribute("customer") Customer updatedCustomer,
                                 HttpSession session) {
        Customer current = (Customer) session.getAttribute("customer");
        if (current == null) {
            return "redirect:/login";
        }

        updatedCustomer.setId(current.getId());
        updatedCustomer.setRole(current.getRole());
        updatedCustomer.setStatus(current.getStatus());
        customerService.updateCustomer(updatedCustomer);

        session.setAttribute("customer", updatedCustomer);
        return "redirect:/profile";
    }

    @PostMapping("/order/cancel/{id}")
    public String cancelOrder(@PathVariable("id") int orderId,
                              HttpSession session) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            return "redirect:/login";
        }

        orderService.cancelOrder(orderId, customer.getId());
        return "redirect:/profile";
    }
}

