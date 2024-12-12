package com.telusko.service;

import com.telusko.entity.Questions;
import com.telusko.repository.QuestionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsServiceImpl implements QuestionsService {

    private QuestionsRepository questionsRepository;

    public QuestionsServiceImpl(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    @Override
    public List<Questions> getAllQuestions() {
        List<Questions> all = questionsRepository.findAll();

        System.out.println(all);

        return all;
    }

    @Override
    public List<Questions> getQuestionsByCategory(String category) {

        List<Questions> byCategory = questionsRepository.findByCategory(category);
        return  byCategory;

    }

    @Override
    public Questions createQuestion(Questions question) {
        Questions save = questionsRepository.save(question);
        return save;
    }

    @Override
    public void deleteQuestion(Long id) {
        questionsRepository.deleteById(id);
    }
}
