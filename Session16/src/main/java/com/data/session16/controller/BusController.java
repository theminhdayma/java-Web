package com.data.session16.controller;

import com.data.session16.model.Bus;
import com.data.session16.model.BusType;
import com.data.session16.service.BusService;
import com.data.session16.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @Autowired
    private SeatService seatService;

    // ✅ Hiển thị danh sách tất cả các xe buýt
    @GetMapping
    public String listBus(Model model) {
        List<Bus> list = busService.getAll();
        model.addAttribute("listBuses", list);
        return "list_buses";
    }

    // ✅ Hiển thị form thêm mới xe buýt
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("bus", new Bus());
        return "add_bus";
    }

    // ✅ Xử lý thêm mới xe buýt và tạo ghế
    @PostMapping("/add")
    public String addBus(@ModelAttribute("bus") Bus bus) {
        // Tính tổng ghế
        int totalSeat = bus.getRowSeat() * bus.getColSeat();
        bus.setTotalSeat(totalSeat);

        // Lưu xe buýt
        busService.addBus(bus);

        // Tự động tạo ghế cho xe buýt
        int seatNumber = 1;
        int price;

        switch (bus.getBusType()) {
            case "NORMAL":
                price = 100000;
                break;
            case "VIP":
                price = 150000;
                break;
            case "LUXURY":
                price = 200000;
                break;
            default:
                price = 100000;
        }

        for (int i = 0; i < bus.getRowSeat(); i++) {
            for (int j = 0; j < bus.getColSeat(); j++) {
                Seat seat = new Seat();
                seat.setNameSeat("R" + (i + 1) + "C" + (j + 1));
                seat.setBusId(bus.getId());
                seat.setPrice(price);
                seat.setStatus("AVAILABLE");

                seatService.addSeat(bus.getId(), seatNumber++, seat.getNameSeat(), price);
            }
        }

        return "redirect:/bus";
    }

    // ✅ Hiển thị form cập nhật xe buýt
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Bus bus = busService.findById(id);
        if (bus != null) {
            model.addAttribute("bus", bus);
            return "update_bus";
        } else {
            return "redirect:/bus";
        }
    }

    // ✅ Xử lý cập nhật xe buýt
    @PostMapping("/update")
    public String updateBus(@ModelAttribute("bus") Bus bus) {
        bus.setTotalSeat(bus.getRowSeat() * bus.getColSeat());
        busService.updateBus(bus);
        return "redirect:/bus";
    }

    // ✅ Xóa xe buýt theo ID
    @GetMapping("/delete/{id}")
    public String deleteBus(@PathVariable("id") int id) {
        busService.deleteBus(id);
        seatService.deleteSeatsByBusId(id); // Xóa ghế liên quan nếu cần
        return "redirect:/bus";
    }
}
