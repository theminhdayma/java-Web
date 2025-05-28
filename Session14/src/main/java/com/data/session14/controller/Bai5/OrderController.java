package com.data.session14.controller.Bai5;

import com.data.session14.model.Bai5.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private List<Order> getOrderList(HttpSession session) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        if (orders == null) {
            orders = new ArrayList<>();
            session.setAttribute("orders", orders);
        }
        return orders;
    }

    @GetMapping
    public String listOrders(HttpSession session, Model model) {
        model.addAttribute("orders", getOrderList(session));
        return "Bai5/order-list";
    }

    // Hiển thị form thêm đơn hàng mới
    @GetMapping("/add")
    public String addOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "Bai5/order-add";
    }

    // Xử lý thêm đơn hàng
    @PostMapping("/add")
    public String addOrder(@ModelAttribute Order order, HttpSession session) {
        List<Order> orders = getOrderList(session);
        orders.add(order);
        session.setAttribute("orders", orders);
        return "redirect:/orders";
    }

    // Hiển thị form sửa đơn hàng theo orderId
    @GetMapping("/edit/{orderId}")
    public String editOrderForm(@PathVariable String orderId, HttpSession session, Model model) {
        List<Order> orders = getOrderList(session);
        for (Order order : orders) {
            if (order.getOrderId().equals(orderId)) {
                model.addAttribute("order", order);
                return "Bai5/order-edit";
            }
        }
        return "redirect:/orders";
    }

    @PostMapping("/edit")
    public String editOrder(@ModelAttribute Order updatedOrder, HttpSession session) {
        List<Order> orders = getOrderList(session);
        for (Order order : orders) {
            if (order.getOrderId().equals(updatedOrder.getOrderId())) {
                order.setProductName(updatedOrder.getProductName());
                order.setQuantity(updatedOrder.getQuantity());
                break;
            }
        }
        session.setAttribute("orders", orders);
        return "redirect:/orders";
    }

    // Xóa đơn hàng theo orderId
    @GetMapping("/delete/{orderId}")
    public String deleteOrder(@PathVariable String orderId, HttpSession session) {
        List<Order> orders = getOrderList(session);
        orders.removeIf(order -> order.getOrderId().equals(orderId));
        session.setAttribute("orders", orders);
        return "redirect:/orders";
    }
}

