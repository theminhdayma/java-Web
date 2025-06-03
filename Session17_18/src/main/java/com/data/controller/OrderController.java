package com.data.controller;

import com.data.entity.Order;
import com.data.entity.ProductCart;
import com.data.entity.Status;
import com.data.service.CartService;
import com.data.service.OrderService;
import com.data.service.ProductService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/checkout")
    public String checkoutForm(Model model, HttpSession session) {
        Integer customerId = (Integer) session.getAttribute("customerId");
        if (customerId == null) {
            return "redirect:/login";
        }

        List<ProductCart> cartItems = cartService.findByCustomerId(customerId);
        double total = 0;

        for (ProductCart item : cartItems) {
            var product = productService.findById(item.getProductId());
            item.setProductId(product.getId());
            total += product.getPrice() * item.getQuantity();
        }

        Order order = new Order();
        order.setTotalMoney(total);
        model.addAttribute("order", order);
        model.addAttribute("total", total);

        return "checkout";
    }

    @PostMapping("/checkout")
    public String handleCheckout(@ModelAttribute("order") Order order,
                                 HttpSession session,
                                 Model model) {
        Integer customerId = (Integer) session.getAttribute("customerId");
        if (customerId == null) {
            return "redirect:/login";
        }

        order.setCustomerId(customerId);
        order.setStatus(Status.PENDING);

        orderService.save(order);

        model.addAttribute("message", "Đặt hàng thành công!");
        return "cart";
    }
}
