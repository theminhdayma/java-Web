package com.data.session08.controller.Bai7;

import com.data.session08.model.Bai7.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class QuizController {

    private final List<Question> questions = new ArrayList<>();

    public QuizController() {
        questions.add(new Question(1, "https://png.pngtree.com/png-clipart/20230414/original/pngtree-red-apple-fruit-realistic-transparent-png-image_9057112.png", "apple"));
        questions.add(new Question(2, "https://hoanghamobile.com/tin-tuc/wp-content/uploads/2024/05/anh-cho-hai-1.jpg", "dog"));
        questions.add(new Question(3, "https://cdn2.fptshop.com.vn/unsafe/Uploads/images/tin-tuc/168364/Originals/meme-con-meo%20(1).jpg", "cat"));
        questions.add(new Question(4, "https://suckhoedoisong.qltns.mediacdn.vn/324455921873985536/2022/12/26/chuoi-chin-16720695582281654655438.jpg", "banana"));
    }

    @GetMapping("/quiz")
    public String showQuiz(Model model, HttpSession session) {
        Question question = questions.get(new Random().nextInt(questions.size()));
        session.setAttribute("question", question);
        session.setAttribute("attempts", 0);
        model.addAttribute("question", question);
        return "Bai7/quiz";
    }

    @PostMapping("/guess")
    public String handleGuess(@RequestParam("userAnswer") String userAnswer,
                              HttpSession session,
                              Model model) {
        Question question = (Question) session.getAttribute("question");
        Integer attempts = (Integer) session.getAttribute("attempts");
        if (attempts == null) attempts = 0;

        if (userAnswer.trim().equalsIgnoreCase(question.getAnswer())) {
            model.addAttribute("message", "Đã đoán đúng!");
            model.addAttribute("correct", true);
        } else {
            attempts++;
            session.setAttribute("attempts", attempts);
            if (attempts >= 3) {
                model.addAttribute("message", "Bạn hết lượt đoán.");
                model.addAttribute("outOfAttempts", true);
            } else {
                model.addAttribute("message", "Sai rồi! Bạn còn " + (3 - attempts) + " lượt.");
            }
        }

        model.addAttribute("question", question);
        return "Bai7/quiz";
    }
}

