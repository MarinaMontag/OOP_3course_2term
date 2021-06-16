package ua.knu.montag.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.knu.montag.backend.models.Test;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    List<Test> findAllBySubjectId(int id);
    Optional<Test> findById(long id);
    @Query(value = "SELECT MAX(id) FROM tests", nativeQuery = true)
    Long getLastCreatedTestId();
}
