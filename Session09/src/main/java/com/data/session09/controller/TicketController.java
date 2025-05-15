package com.data.session09.controller;

import javax.servlet.http.HttpSession;

import com.data.session09.model.Seat;
import com.data.session09.service.SeatService;
import com.data.session09.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private SeatService seatService;

    @Autowired
    private TicketService ticketService;


    @GetMapping("/booking")
    public String showBookingPage(@RequestParam Long scheduleId,
                                  @RequestParam Long screenRoomId,
                                  Model model) {
        List<Seat> seats = seatService.getSeatsByScreenRoom(screenRoomId);
        List<Long> bookedSeats = seatService.getBookedSeatsBySchedule(scheduleId);

        model.addAttribute("seats", seats);
        model.addAttribute("bookedSeats", bookedSeats);
        model.addAttribute("scheduleId", scheduleId);
        model.addAttribute("screenRoomId", screenRoomId);
        return "booking";
    }


    @PostMapping("/book")
    public String bookTicket(@RequestParam Long scheduleId,
                             @RequestParam Long screenRoomId,
                             @RequestParam Long seatId,
                             @RequestParam Double price,
                             HttpSession session,
                             Model model) {
        Long customerId = (Long) session.getAttribute("loggedInUserId");
        if (customerId == null) {
            model.addAttribute("error", "Bạn phải đăng nhập để đặt vé.");
            return "login";
        }

        ticketService.bookTicket(customerId, scheduleId, seatId, price);

        model.addAttribute("message", "Đặt vé thành công!");
        return "redirect:/tickets/booking"
                + "?scheduleId=" + scheduleId
                + "&screenRoomId=" + screenRoomId;
    }

    @GetMapping("/book")
    public String handleGetBook(@RequestParam Long scheduleId,
                                @RequestParam Long screenRoomId) {
        return "redirect:/tickets/booking"
                + "?scheduleId=" + scheduleId
                + "&screenRoomId=" + screenRoomId;
    }
}
