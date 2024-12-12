package com.telusko.service;

import com.telusko.entity.Quiz;
import com.telusko.payload.Answers;
import com.telusko.payload.QuestionsDto;

import java.util.List;

public interface QuizService {
    Quiz createQuiz(String category, Integer numQ, String title);

    List<QuestionsDto> getQuizQuestions(Long id);

    Integer calculateRessult(Long id, List<Answers> answers);
}
