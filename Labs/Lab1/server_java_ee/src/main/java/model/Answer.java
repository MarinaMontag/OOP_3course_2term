package model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "questionId", "text", "correctness"})
public class Answer {
    private int id;
    private int questionId;
    private String text;
    private boolean correctness;

    public Answer() {
    }

    public Answer(int id, int questionId, String text, boolean correctness) {
        this.id = id;
        this.questionId = questionId;
        this.text = text;
        this.correctness = correctness;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrectness() {
        return correctness;
    }

    public void setCorrectness(boolean correctness) {
        this.correctness = correctness;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", questionId=" + questionId +
                ", text='" + text + '\'' +
                ", correctness=" + correctness +
                '}';
    }

}
