package com.data.session14.controller.Bai9;

import com.data.session14.model.Bai9.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@SessionAttributes({"transactions", "username"})
public class FinanceController {

    @ModelAttribute("transactions")
    public List<Transaction> transactions() {
        return new ArrayList<>();
    }

    @GetMapping("/finance")
    public String showFinancePage(@CookieValue(value = "username", defaultValue = "") String username,
                                  Model model) {
        model.addAttribute("username", username);
        return "Bai9/financeForm";
    }

    @PostMapping("/finance")
    public String addTransaction(@RequestParam String description,
                                 @RequestParam double amount,
                                 @RequestParam String type,
                                 @RequestParam String username,
                                 @ModelAttribute("transactions") List<Transaction> transactions,
                                 HttpServletResponse response,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {

        transactions.add(new Transaction(description, amount, type));
        model.addAttribute("transactions", transactions);
        model.addAttribute("username", username);

        Cookie cookie = new Cookie("username", username);
        cookie.setMaxAge(30 * 24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);

        redirectAttributes.addFlashAttribute("message", "Thêm giao dịch thành công!");
        return "redirect:/financeList";
    }

    @GetMapping("listFinance")
    public String showTransactionList(@ModelAttribute("transactions") List<Transaction> transactions,
                                      Model model) {
        model.addAttribute("transactions", transactions);
        return "Bai9/financeList";
    }

    @GetMapping("/listFinance/delete/{index}")
    public String deleteTransaction(@PathVariable int index,
                                    @ModelAttribute("transactions") List<Transaction> transactions,
                                    RedirectAttributes redirectAttributes) {
        if (index >= 0 && index < transactions.size()) {
            transactions.remove(index);
            redirectAttributes.addFlashAttribute("message", "Xóa giao dịch thành công!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Chỉ số giao dịch không hợp lệ!");
        }
        return "redirect:/financeList";
    }
}
