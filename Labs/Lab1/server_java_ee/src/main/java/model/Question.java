package model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"id", "testId", "text", "answerList"})
public class Question {
    private int id;
    private int testId;
    private String text;
    private List<Answer> answerList;

    public Question() {
        answerList=new ArrayList<>();
    }

    public Question(int id, int testId, String text) {
        this.id = id;
        this.testId = testId;
        this.text = text;
        answerList=new ArrayList<>();
    }

    public Question(int id, int testId, String text, List<Answer> answerList) {
        this.id = id;
        this.testId = testId;
        this.text = text;
        this.answerList = answerList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", testId=" + testId +
                ", text='" + text + '\'' +
                ", answerList=" + answerList +
                '}';
    }
}
