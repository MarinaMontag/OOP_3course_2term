package ua.knu.montag.backend.payload.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@AllArgsConstructor
@Data
@JsonPropertyOrder({"id", "text", "answers"})
public class TestQuestion {
    private Long id;
    private String text;
   private List<QuestionAnswer> answers;
}
