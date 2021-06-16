package ua.knu.montag.backend.payload;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@JsonPropertyOrder({"id", "text", "correctness"})
public class QuestionAnswer {
    private Long id;
    private String text;
    private boolean correctness;
}
