package ua.knu.montag.backend.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(length = 7)
    private ERole name;

    public Role(ERole name) {
        this.name = name;
    }
}
