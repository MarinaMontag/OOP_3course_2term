package ua.knu.montag.backend.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import ua.knu.montag.backend.models.Subject;

import java.util.List;
@AllArgsConstructor
@Data
public class SubjectResponse {
    private List<Subject>subjects;
}
