package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qid")
    private int qid;

    @Column(name = "question_text")
    private String questionText;

    public Question(int qid) {
		super();
		this.qid = qid;
	}

	public Question() {
        // default constructor
    }

    public Question(String questionText) {
        this.questionText = questionText;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    @Override
    public String toString() {
        return "Question{" +
                "qid=" + qid +
                ", questionText='" + questionText + '\'' +
                '}';
    }
}

