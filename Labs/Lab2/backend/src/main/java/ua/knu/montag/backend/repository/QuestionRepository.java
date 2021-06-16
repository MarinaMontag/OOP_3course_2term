package ua.knu.montag.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.knu.montag.backend.models.Question;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByTestId(Long id);
    @Query(value = "SELECT MAX(id) FROM questions", nativeQuery = true)
    Long getLastCreatedQuestionId();

    @Override
    Optional<Question> findById(Long id);
}
