package model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import exception.ServerException;

import java.util.List;
@JsonPropertyOrder({"questionList"})
public class QuestionList {
    private List<Question>questionList;

    public QuestionList() {
    }

    public QuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public List<Question> getQuestions() {
        return questionList;
    }

    public void setQuestions(List<Question> questionList) {
        this.questionList = questionList;
    }

    @Override
    public String toString() {
        return "QuestionList{" +
                "questionList=" + questionList +
                '}';
    }
}
