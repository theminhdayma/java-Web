package com.data.session08.controller.Bai8_9_10;

import com.data.session08.model.Bai8_9_10.Seeds;
import com.data.session08.model.Bai8_9_10.User;
import com.data.session08.model.Bai8_9_10.WarehouseSeeds;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class GameController {
    private List<Seeds> seedList = new ArrayList<>();
    private Map<String, List<WarehouseSeeds>> warehouseMap = new HashMap<>();
    private Map<String, Map<Integer, Seeds>> farmMap = new HashMap<>();
    private List<User> users = new ArrayList<>();
    private int userIdCounter = 1;

    public GameController() {
        seedList.add(new Seeds(1, "Cà chua", 1000, "https://favri.org.vn/images/anh_tinkhoahoc/Ca_chua.jpg"));
        seedList.add(new Seeds(2, "Bắp cải", 1500, "https://image.tienphong.vn/w890/Uploaded/2025/rkznae/2019_12_16/cai_bap_1416685665757_42_4_422_521_crop_1416685674608_IAHA.jpg"));
        seedList.add(new Seeds(3, "Ớt", 2000, "https://hongngochospital.vn/wp-content/uploads/2013/11/doi-tuong-khong-nen-an-ot-1.jpg"));
    }

    @GetMapping("/game")
    public String home(HttpSession session) {
        return (session.getAttribute("user") == null) ? "redirect:/login" : "Bai8_9_10/home";
    }

    @GetMapping("/register")
    public String showRegister() {
        return "Bai8_9_10/register";
    }

    @PostMapping("/register")
    public String handleRegister(@RequestParam String username, @RequestParam String password, @RequestParam String email, HttpSession session) {
        User user = new User();
        user.setId(userIdCounter++);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        users.add(user);
        session.setAttribute("user", user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "Bai8_9_10/login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                session.setAttribute("user", u);
                return "redirect:/game";
            }
        }
        return "Bai8_9_10/login";
    }

    @GetMapping("/shop")
    public ModelAndView showShop(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return new ModelAndView("redirect:/login");
        ModelAndView mav = new ModelAndView("Bai8_9_10/shop");
        mav.addObject("seeds", seedList);
        mav.addObject("user", user);
        return mav;
    }

    @PostMapping("/buy")
    public String buySeed(@RequestParam int seedId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";

        Seeds selected = seedList.stream().filter(s -> s.getId() == seedId).findFirst().orElse(null);
        if (selected != null && user.getBalance() >= selected.getPrice()) {
            user.setBalance(user.getBalance() - selected.getPrice());
            List<WarehouseSeeds> userWarehouse = warehouseMap.computeIfAbsent(user.getUsername(), k -> new ArrayList<>());
            WarehouseSeeds item = userWarehouse.stream().filter(ws -> ws.getSeeds().getId() == seedId).findFirst().orElse(null);
            if (item == null) {
                WarehouseSeeds newItem = new WarehouseSeeds();
                newItem.setId(seedId);
                newItem.setSeeds(selected);
                newItem.setQuantity(1);
                userWarehouse.add(newItem);
            } else {
                item.setQuantity(item.getQuantity() + 1);
            }
        }

        return "redirect:/shop";
    }

    @GetMapping("/warehouse")
    public ModelAndView showWarehouse(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return new ModelAndView("redirect:/login");
        List<WarehouseSeeds> warehouse = warehouseMap.getOrDefault(user.getUsername(), new ArrayList<>());
        ModelAndView mav = new ModelAndView("Bai8_9_10/warehouse");
        mav.addObject("warehouseSeeds", warehouse);
        return mav;
    }

    @GetMapping("/farm")
    public ModelAndView showFarm(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return new ModelAndView("redirect:/login");

        Map<Integer, Seeds> plots = farmMap.computeIfAbsent(user.getUsername(), k -> {
            Map<Integer, Seeds> newMap = new HashMap<>();
            for (int i = 1; i <= 20; i++) newMap.put(i, null);
            return newMap;
        });

        List<WarehouseSeeds> warehouse = warehouseMap.getOrDefault(user.getUsername(), new ArrayList<>());
        ModelAndView mav = new ModelAndView("Bai8_9_10/farm");
        mav.addObject("plots", plots);
        mav.addObject("warehouseSeeds", warehouse);
        return mav;
    }

    @PostMapping("/plant")
    public String plantSeed(@RequestParam int plotNumber, @RequestParam int seedId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";

        List<WarehouseSeeds> warehouse = warehouseMap.getOrDefault(user.getUsername(), new ArrayList<>());
        WarehouseSeeds seedInStock = warehouse.stream()
                .filter(ws -> ws.getSeeds().getId() == seedId && ws.getQuantity() > 0)
                .findFirst().orElse(null);

        if (seedInStock == null) return "redirect:/farm";

        Map<Integer, Seeds> plots = farmMap.get(user.getUsername());
        if (plots.get(plotNumber) == null) {
            plots.put(plotNumber, seedInStock.getSeeds());
            seedInStock.setQuantity(seedInStock.getQuantity() - 1);
        }

        return "redirect:/farm";
    }
}
