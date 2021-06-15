package ua.knu.montag.backend.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;
@Data
public class SignupRequest {
    @NotBlank
    @Size(min = 2, max = 30)
    private String name;
    @NotBlank
    @Size(min = 2, max = 30)
    private String surname;
    @NotBlank
    @Size(min = 2, max = 50)
    private String email;
    @NotBlank
    @Size(min = 1, max = 120)
    private String password;
    private Set<String>roles;
}
