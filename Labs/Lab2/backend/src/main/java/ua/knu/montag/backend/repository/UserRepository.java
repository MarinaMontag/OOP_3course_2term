package ua.knu.montag.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.knu.montag.backend.models.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
    Boolean existsByEmail(String email);
}
