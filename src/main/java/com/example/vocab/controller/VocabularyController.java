package com.example.vocab.controller;
import com.example.vocab.entity.Vocabulary;
import com.example.vocab.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VocabularyController {

    @Autowired
    private VocabularyService vocabularyService;

    @GetMapping("/")
    public String home(Model model) {
        Vocabulary vocab = vocabularyService.getRandomVocabulary();
        model.addAttribute("vocab", vocab);
        return "index";
    }

//    @PostMapping("/check")
//    public String checkAnswer(@RequestParam("answer") String answer, @RequestParam("english") String english, Model model) {
//        if (answer.trim().equalsIgnoreCase(english.trim())) {
//            model.addAttribute("message", "Ting Ting!");
//        } else {
//            model.addAttribute("message", "Try again!");
//        }
//        Vocabulary vocab = vocabularyService.getRandomVocabulary();
//        model.addAttribute("vocab", vocab);
//        return "index";
//    }
    @PostMapping("/check")
    public String checkAnswer(@RequestParam("answer") String answer, @RequestParam("english") String english, Model model) {
        boolean isCorrect = answer.trim().equalsIgnoreCase(english.trim());
        model.addAttribute("message", isCorrect ? "Ting Ting!" : "Try again!");
        Vocabulary vocab = vocabularyService.getRandomVocabulary();
        model.addAttribute("vocab", vocab);
        return "index";
    }
}

