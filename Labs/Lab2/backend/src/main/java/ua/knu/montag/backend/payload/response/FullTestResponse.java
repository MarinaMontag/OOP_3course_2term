package ua.knu.montag.backend.payload.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Data
@JsonPropertyOrder({"id", "name", "description", "questions"})
public class FullTestResponse {
    private Long id;
    private String name;
    private String description;
    private List<TestQuestion> questions;
}
