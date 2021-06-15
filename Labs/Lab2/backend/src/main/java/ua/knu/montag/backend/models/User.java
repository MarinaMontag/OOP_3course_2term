package ua.knu.montag.backend.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "users",
uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 30)
    private String name;
    @NotBlank
    @Size(max = 30)
    private String surname;
    @NotBlank
    @Size(max = 120)
    private String password;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String name, String surname, String email, String password){
        this.name=name;
        this.surname=surname;
        this.email = email;
        this.password = password;
    }
}
