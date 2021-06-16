package ua.knu.montag.backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tests")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;
    @NotBlank
    @Size(max = 50)
    private String name;
    @Size(max = 150)
    private String description;

    public Test(Subject subject, @NotBlank @Size(max = 50) String name, @Size(max = 150) String description) {
        this.subject = subject;
        this.name = name;
        this.description = description;
    }
}
