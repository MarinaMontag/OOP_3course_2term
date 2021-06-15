package ua.knu.montag.backend.payload.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@JsonPropertyOrder({"id", "text", "correctness"})
public class QuestionAnswer {
    private Long id;
    private String text;
    private boolean correctness;
}
