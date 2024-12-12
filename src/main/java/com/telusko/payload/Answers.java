package com.telusko.payload;

import lombok.Data;
import lombok.RequiredArgsConstructor;


public class Answers {
    private Long id;
    private String answer;

    public Answers(Long id, String answer) {
        this.id = id;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

}
