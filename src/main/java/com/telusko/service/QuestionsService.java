package com.telusko.service;

import com.telusko.entity.Questions;

import java.util.List;

public interface QuestionsService {
    List<Questions> getAllQuestions();

    List<Questions> getQuestionsByCategory(String category);

    Questions createQuestion(Questions question);

    void deleteQuestion(Long id);
}
