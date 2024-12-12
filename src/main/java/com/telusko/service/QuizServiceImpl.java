package com.telusko.service;

import com.telusko.entity.Questions;
import com.telusko.entity.Quiz;
import com.telusko.payload.Answers;
import com.telusko.payload.QuestionsDto;
import com.telusko.repository.QuestionsRepository;
import com.telusko.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {


    private QuizRepository quizRepository;
    private QuestionsRepository questionsRepository;
    public QuizServiceImpl(QuizRepository quizRepository, QuestionsRepository questionsRepository) {
        this.quizRepository = quizRepository;
        this.questionsRepository = questionsRepository;
    }

    @Override
    public Quiz createQuiz(String category, Integer numQ, String title) {

        List<Questions> randomQuestionsByCategory = findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(randomQuestionsByCategory);

        Quiz save = quizRepository.save(quiz);
        return save;
    }

    @Override
    public List<QuestionsDto> getQuizQuestions(Long id) {
        Optional<Quiz> byId = quizRepository.findById(id);
        if(byId.isPresent()){
            List<Questions> questionsFromDB = byId.get().getQuestions();
            List<QuestionsDto> questionsDtos = new ArrayList<>();
            for (Questions q : questionsFromDB){

                QuestionsDto qd = new QuestionsDto(
                        q.getId(),
                        q.getOption1(),
                        q.getOption2(),
                        q.getOption3(),
                        q.getOption4(),
                        q.getQuestionTitle());
                questionsDtos.add(qd);
            }
            return questionsDtos;
        }else {
            return null;
        }
    }

    @Override
    public Integer calculateRessult(Long id, List<Answers> answers) {

        Quiz quiz = quizRepository.findById(id).get();
        List<Questions> questions = quiz.getQuestions();
        int score = 0;
        int i = 0;
        for(Answers ans : answers) {
            if(ans.getAnswer().equals(questions.get(i).getRightAnswer())){
                score++;
            }
            i++;
        }
        return score;
    }

    public List<Questions> findRandomQuestionsByCategory(String category, int numQ) {
        List<Questions> questions = questionsRepository.findByCategory(category);
        Collections.shuffle(questions); // Randomize the list in Java
        return questions.stream().limit(numQ).toList(); // Limit the results
    }

}
