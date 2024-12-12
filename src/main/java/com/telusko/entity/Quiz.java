package com.telusko.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "quiz")
public class Quiz {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  @JsonProperty("id")
  private Long id;

  @Column(name = "title", nullable = false)
  @JsonProperty("title")
  private String title;

  @ManyToMany
  @JoinTable(name = "quiz_questions", joinColumns = @JoinColumn(name = "quiz_id"),inverseJoinColumns = @JoinColumn(name = "questions_id"))
  @JsonProperty("questoins")
  private List<Questions> questions;

  public void setTitle(String title) {
    this.title = title;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setQuestions(List<Questions> questions) {
    this.questions = questions;
  }

  public List<Questions> getQuestions() {
    return questions;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }
}