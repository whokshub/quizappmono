package com.telusko.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionsDto {

    private Long id;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String questionTitle;

    public QuestionsDto(Long id, String option1, String option2, String option3, String option4, String questionTitle) {
        this.id = id;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.questionTitle = questionTitle;
    }

    public Long getId() {
        return id;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }
}
