package com.telusko.controller;

import com.telusko.entity.Quiz;
import com.telusko.payload.Answers;
import com.telusko.payload.QuestionsDto;
import com.telusko.service.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("create")
    public ResponseEntity<?> createQuiz(
            @RequestParam String category,
            @RequestParam Integer numQ,
            @RequestParam String title){

        Quiz quiz = quizService.createQuiz(category, numQ, title);

        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<?> getQuizQuestions(@PathVariable Long id){
         List<QuestionsDto> quizQuestions =quizService.getQuizQuestions(id);
         return new ResponseEntity<>(quizQuestions, HttpStatus.OK);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<?> submitQuiz(@PathVariable Long id, @RequestBody List<Answers> answers){
        Integer ressult = quizService.calculateRessult(id, answers);
        return new ResponseEntity<>(ressult, HttpStatus.OK);
    }
}
