package com.data.session02;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Random;

@WebServlet("/GuessServlet")
public class GuessServlet extends HttpServlet {
    private final String[] words = {
            "apple", "banana", "house", "school", "flower",
            "water", "animal", "computer", "music", "family"
    };

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String wordToGuess = words[new Random().nextInt(words.length)];
        char[] displayed = new char[wordToGuess.length()];
        boolean[] revealed = new boolean[wordToGuess.length()];

        int hintsToShow = 2;
        Random random = new Random();
        int revealedCount = 0;

        while (revealedCount < hintsToShow) {
            int index = random.nextInt(wordToGuess.length());
            if (!revealed[index]) {
                revealed[index] = true;
                revealedCount++;
            }
        }

        for (int i = 0; i < wordToGuess.length(); i++) {
            displayed[i] = revealed[i] ? wordToGuess.charAt(i) : '_';
        }

        HttpSession session = request.getSession();
        session.setAttribute("wordToGuess", wordToGuess);
        session.setAttribute("displayedWord", displayed);
        session.setAttribute("attemptsLeft", 3);

        request.getRequestDispatcher("BaiTap/Bai9.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String wordToGuess = (String) session.getAttribute("wordToGuess");
        char[] displayed = (char[]) session.getAttribute("displayedWord");
        int attemptsLeft = (Integer) session.getAttribute("attemptsLeft");

        String guess = request.getParameter("guess");

        if (guess != null && !guess.trim().isEmpty()) {
            guess = guess.trim().toLowerCase();

            if (guess.equalsIgnoreCase(wordToGuess)) {
                session.setAttribute("displayedWord", wordToGuess.toCharArray());
                request.setAttribute("message", "Bạn đã đoán đúng!");
            } else {
                attemptsLeft--;
                session.setAttribute("attemptsLeft", attemptsLeft);
                if (attemptsLeft > 0) {
                    request.setAttribute("message", "Bạn đoán sai! Còn " + attemptsLeft + " lần.");
                } else {
                    request.setAttribute("message", "Bạn đã thua sau 3 lần đoán! Từ đúng là: " + wordToGuess);
                    session.setAttribute("displayedWord", wordToGuess.toCharArray()); // hiển thị toàn bộ từ sau khi thua
                }
            }
        }

        request.getRequestDispatcher("BaiTap/Bai9.jsp").forward(request, response);
    }
}
