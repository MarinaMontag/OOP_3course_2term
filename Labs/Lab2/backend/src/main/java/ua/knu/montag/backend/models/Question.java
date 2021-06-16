package ua.knu.montag.backend.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "questions")
@NoArgsConstructor
@Data
@ToString
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;
    @NotBlank
    @Size(max = 150)
    private String text;

    public Question(Test test, @NotBlank @Size(max = 150) String text) {
        this.test = test;
        this.text = text;
    }
}
