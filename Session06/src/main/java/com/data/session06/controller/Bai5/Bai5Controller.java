package com.data.session06.controller.Bai5;

import java.io.*;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Bai5Controller", value = "/Bai5Controller")
public class Bai5Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/Bai5/bai5.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userChoice = request.getParameter("choice");
        String[] choices = {"búa", "kéo", "lá"};
        Random rand = new Random();
        String computerChoice = choices[rand.nextInt(choices.length)];
        String result = determineWinner(userChoice, computerChoice);
        request.setAttribute("userChoice", userChoice);
        request.setAttribute("computerChoice", computerChoice);
        request.setAttribute("result", result);
        request.getRequestDispatcher("views/Bai5/result.jsp").forward(request, response);
    }

    private String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "Hòa!";
        }
        switch (userChoice) {
            case "búa":
                return computerChoice.equals("kéo") ? "Bạn thắng!" : "Máy tính thắng!";
            case "lá":
                return computerChoice.equals("búa") ? "Bạn thắng!" : "Máy tính thắng!";
            case "kéo":
                return computerChoice.equals("giấy") ? "Bạn thắng!" : "Máy tính thắng!";
            default:
                return "Lựa chọn không hợp lệ!";
        }
    }
}