package model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "subjectId", "name", "description"})
public class Test {
    private int id;
    private int subjectId;
    private String name;
    private String description;

    public Test() {
    }

    public Test(int subjectId, String name, String description) {
        this.subjectId = subjectId;
        this.name = name;
        this.description = description;
    }

    public Test(int id, int subjectId, String name, String description) {
        this.id = id;
        this.subjectId = subjectId;
        this.name = name;
        this.description = description;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", subjectId=" + subjectId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
