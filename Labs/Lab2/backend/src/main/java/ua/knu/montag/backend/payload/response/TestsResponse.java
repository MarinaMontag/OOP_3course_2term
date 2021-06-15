package ua.knu.montag.backend.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import ua.knu.montag.backend.models.Test;

import java.util.List;
@AllArgsConstructor
@Data
public class TestsResponse {
    private List<Test> tests;
}
