package ua.knu.montag.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.knu.montag.backend.models.Subject;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    @Query(
            value = "SELECT * FROM subjects",
            nativeQuery = true)
    List<Subject>findAll();
    @Override
    Optional<Subject> findById(Integer integer);
}
