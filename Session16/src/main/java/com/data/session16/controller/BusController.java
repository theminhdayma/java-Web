package com.data.session16.controller;

import com.data.session16.dto.BusDto;
import com.data.session16.model.Bus;
import com.data.session16.model.BusType;
import com.data.session16.model.Seat;
import com.data.session16.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @Autowired
    private SeatService seatService;

    @GetMapping
    public String showAllBuses(Model model) {
        model.addAttribute("buses", busService.getAllBuses());
        return "bus/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("busDto", new BusDto());
        model.addAttribute("busTypes", BusType.values());
        return "bus/add";
    }

    @PostMapping("/add")
    public String addBus(@Valid @ModelAttribute("busDto") BusDto busDto,
                         BindingResult result,
                         Model model) {
        if (result.hasErrors()) {
            model.addAttribute("busTypes", BusType.values());
            return "bus/add";
        }

        String imageUrl = UploadUtils.uploadImage(busDto.getImage());
        Bus bus = new Bus();
        bus.setLicensePlate(busDto.getLicensePlate());
        bus.setBusType(busDto.getBusType());
        bus.setRowSeat(busDto.getRowSeat());
        bus.setColSeat(busDto.getColSeat());
        bus.setTotalSeat(busDto.getRowSeat() * busDto.getColSeat());
        bus.setImage(imageUrl);

        if (busService.addBus(bus)) {
            // Khởi tạo danh sách ghế tương ứng
            int totalSeats = bus.getTotalSeat();
            for (int i = 0; i < totalSeats; i++) {
                Seat seat = new Seat();
                seat.setNameSeat("S" + (i + 1));
                seat.setBusId(bus.getId());
                seat.setStatus(false);

                double price = switch (bus.getBusType()) {
                    case NORMAL -> 100_000;
                    case VIP -> 150_000;
                    case LUXURY -> 200_000;
                };
                seat.setPrice(price);
                seatService.addSeat(seat);
            }
        }

        return "redirect:/bus";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Bus bus = busService.getBusById(id);
        if (bus == null) return "redirect:/bus";
        model.addAttribute("bus", bus);
        model.addAttribute("busTypes", BusType.values());
        return "bus/edit";
    }

    @PostMapping("/edit")
    public String updateBus(@ModelAttribute Bus bus) {
        bus.setTotalSeat(bus.getRowSeat() * bus.getColSeat());
        busService.updateBus(bus);
        return "redirect:/bus";
    }

    @GetMapping("/delete/{id}")
    public String deleteBus(@PathVariable int id) {
        busService.deleteBus(id);
        return "redirect:/bus";
    }
}
