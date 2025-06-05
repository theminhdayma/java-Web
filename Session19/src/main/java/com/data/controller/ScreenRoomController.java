package com.data.controller;

import com.data.entity.ScreenRoom;
import com.data.service.screenroom.ScreenRoomService;
import com.data.service.seat.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rooms")
public class ScreenRoomController {

    @Autowired
    private ScreenRoomService screenRoomService;
    @Autowired
    private SeatService seatService;

    @GetMapping
    public String listActiveRooms(Model model) {
        List<ScreenRoom> rooms = screenRoomService.findAllActive();
        model.addAttribute("rooms", rooms);
        return "room/room-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("room", new ScreenRoom());
        return "room/room-form";
    }

    @PostMapping("/add")
    public String addRoom(@ModelAttribute("room") ScreenRoom room) {
        room.setStatus(true);
        screenRoomService.save(room);
        return "redirect:/rooms";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        ScreenRoom room = screenRoomService.findById(id);
        if (room == null || !room.getStatus()) {
            return "redirect:/rooms";
        }
        model.addAttribute("room", room);
        return "room/room-form";
    }

    @PostMapping("/edit")
    public String editRoom(@ModelAttribute("room") ScreenRoom updatedRoom) {
        screenRoomService.updateScreenRoom(updatedRoom);
        return "redirect:/rooms";
    }

    @GetMapping("/delete/{id}")
    public String deleteRoom(@PathVariable Long id) {
        ScreenRoom room = screenRoomService.findById(id);
        if (room != null) {
            screenRoomService.delete(room);
        }
        return "redirect:/rooms";
    }

    @GetMapping("/seats/{id}")
    public String showSeats(@PathVariable Long id, Model model) {
        if(id == null){
            return "redirect:/rooms";
        }
        model.addAttribute("room", screenRoomService.findById(id));
        model.addAttribute("seats", seatService.findByScreenRoomId(id));
        return "room/seat-list";
    }
}
