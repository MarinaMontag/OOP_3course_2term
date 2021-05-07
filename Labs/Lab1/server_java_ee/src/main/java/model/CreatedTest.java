package model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;
@JsonPropertyOrder({"testInfo", "questions"})
public class CreatedTest {
    private Test testInfo;
    private List<Question>questions;

    public CreatedTest() {
        questions = new ArrayList<>();
    }

    public CreatedTest(Test testInfo, List<Question> questions) {
        this.testInfo = testInfo;
        this.questions = questions;
    }

    public Test getTestInfo() {
        return testInfo;
    }

    public void setTestInfo(Test testInfo) {
        this.testInfo = testInfo;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "CreatedTest{" +
                "testInfo=" + testInfo +
                ", questions=" + questions +
                '}';
    }
}
