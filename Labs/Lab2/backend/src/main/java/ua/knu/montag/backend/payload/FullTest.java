package ua.knu.montag.backend.payload;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@JsonPropertyOrder({"id", "subjectId", "name", "description", "questions"})
public class FullTest {
    private Long id;
    private Integer subjectId;
    private String name;
    private String description;
    private List<TestQuestion> questions;
}
