package model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;
@JsonPropertyOrder({"testList"})
public class TestList {
    List<Test>testList;

    public TestList() {
        testList=new ArrayList<>();
    }

    public TestList(List<Test> testList) {
        this.testList = testList;
    }

    public List<Test> getTestList() {
        return testList;
    }

    public void setTestList(List<Test> testList) {
        this.testList = testList;
    }
}
