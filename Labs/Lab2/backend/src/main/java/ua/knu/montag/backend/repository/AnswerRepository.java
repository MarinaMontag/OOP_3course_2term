package ua.knu.montag.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.knu.montag.backend.models.Answer;
import ua.knu.montag.backend.models.Question;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findAllByQuestionId(long id);
    @Query(value = "SELECT MAX(id) FROM answers", nativeQuery = true)
    Long getLastCreatedAnswerId();
}
