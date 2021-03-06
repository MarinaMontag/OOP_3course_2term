package ua.knu.montag.backend.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "subjects",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "name")
        })
@NoArgsConstructor
@Data
@ToString
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Size(max = 30)
    private String name;
}
