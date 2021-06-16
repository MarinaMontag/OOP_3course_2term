package ua.knu.montag.backend.payload;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@AllArgsConstructor
@Data
@JsonPropertyOrder({"id", "text", "answers"})
public class TestQuestion {
    private Long id;
    private String text;
   private List<QuestionAnswer> answers;
}
