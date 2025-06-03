package com.data.controller;

import com.data.entity.Customer;
import com.data.entity.Order;
import com.data.entity.Product;
import com.data.entity.Status;
import com.data.service.CustomerService;
import com.data.service.OrderService;
import com.data.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class DashboardController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        Customer user = (Customer) session.getAttribute("user");
        if (user == null || !"admin".equals(user.getRole())) {
            return "redirect:/login";
        }

        model.addAttribute("totalUsers", customerService.getAllCustomers().size());
        model.addAttribute("totalProducts", productService.getAllProduct().size());
        model.addAttribute("totalOrders", orderService.getAllOrder().size());
        model.addAttribute("totalRevenue", orderService.getAllOrder()
                .stream().mapToDouble(Order::getTotalMoney).sum());

        return "dashboard";
    }

    @GetMapping("/userManager")
    public String userManager(HttpSession session, Model model,
                              @RequestParam(value = "search", required = false) String search) {
        Customer user = (Customer) session.getAttribute("user");
        if (user == null || !"admin".equals(user.getRole())) {
            return "redirect:/login";
        }

        List<Customer> customers = (search != null && !search.isEmpty())
                ? customerService.searchCustomerByName(search)
                : customerService.getAllCustomers();

        model.addAttribute("customers", customers);
        model.addAttribute("search", search);
        return "userManager";
    }

    @PostMapping("/lockCustomer")
    public String lockCustomer(@RequestParam("id") int id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            customerService.lockCustomer(customer);
        }
        return "redirect:/admin/userManager";
    }

    @PostMapping("/unlockCustomer")
    public String unlockCustomer(@RequestParam("id") int id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            customerService.unlockCustomer(customer);
        }
        return "redirect:/admin/userManager";
    }

    @GetMapping("/productManager")
    public String productManager(HttpSession session, Model model,
                                 @RequestParam(value = "minPrice", required = false) Double minPrice,
                                 @RequestParam(value = "maxPrice", required = false) Double maxPrice) {
        Customer user = (Customer) session.getAttribute("user");
        if (user == null || !"admin".equals(user.getRole())) {
            return "redirect:/login";
        }

        List<Product> products;

        if (minPrice != null && maxPrice != null) {
            products = productService.filterProductByPrice(minPrice, maxPrice);
        } else {
            products = productService.getAllProduct();
        }

        model.addAttribute("products", products);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        return "productManager";
    }

    @GetMapping("/orderManager")
    public String orderManager(HttpSession session, Model model,
                               @RequestParam(value = "recipientName", required = false) String recipientName,
                               @RequestParam(value = "status", required = false) Status status) {
        Customer user = (Customer) session.getAttribute("user");
        if (user == null || !"admin".equals(user.getRole())) {
            return "redirect:/login";
        }

        List<Order> orders;

        if (recipientName != null && !recipientName.isEmpty()) {
            orders = orderService.searchOrderByRecipientName(recipientName);
        } else if (status != null) {
            orders = orderService.FilterOrderByStatus(status);
        } else {
            orders = orderService.getAllOrder();
        }

        model.addAttribute("orders", orders);
        model.addAttribute("recipientName", recipientName);
        model.addAttribute("status", status);
        return "orderManager";
    }
}
