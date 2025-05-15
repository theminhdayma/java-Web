package com.data.session04.Bai9;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "SeatServlet", value = "/SeatServlet")
public class SeatServlet extends HttpServlet {
    private List<Seat> seats;

    @Override
    public void init() {
        seats = new ArrayList<>();
        seats.add(new Seat("A1", "Ghế A1", 100000, false));
        seats.add(new Seat("A2", "Ghế A2", 100000, true));
        seats.add(new Seat("A3", "Ghế A3", 100000, false));
        seats.add(new Seat("A4", "Ghế A4", 120000, false));
        seats.add(new Seat("A5", "Ghế A5", 90000, true));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("seats", seats);
        request.getRequestDispatcher("BaiTap/Bai9/Bai9.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] selectedSeatIds = req.getParameterValues("selectedSeats");

        double total = 0;
        String message;

        if (selectedSeatIds == null || selectedSeatIds.length == 0) {
            message = "Vui lòng chọn ghế trước khi thanh toán!";
        } else {
            for (String seatId : selectedSeatIds) {
                for (Seat seat : seats) {
                    if (seat.getId().equals(seatId)) {
                        total += seat.getPrice();
                        break;
                    }
                }
            }
            message = "Tổng số tiền bạn cần thanh toán là: " + total + " VNĐ";
        }

        req.setAttribute("seats", seats);
        req.setAttribute("message", message);
        req.getRequestDispatcher("BaiTap/Bai9/Bai9.jsp").forward(req, resp);
    }
}
