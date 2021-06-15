package ua.knu.montag.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.knu.montag.backend.models.ERole;
import ua.knu.montag.backend.models.Role;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);
}
