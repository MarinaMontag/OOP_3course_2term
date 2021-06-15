package ua.knu.montag.backend.security.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.knu.montag.backend.models.Answer;
import ua.knu.montag.backend.models.Question;
import ua.knu.montag.backend.models.Test;
import ua.knu.montag.backend.payload.response.FullTestResponse;
import ua.knu.montag.backend.payload.response.QuestionAnswer;
import ua.knu.montag.backend.payload.response.TestQuestion;
import ua.knu.montag.backend.repository.TestRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestServiceImpl implements TestService{
    private final TestRepository repository;
    private final QuestionService questionService;
    private final AnswerService answerService;

    public TestServiceImpl(TestRepository repository, QuestionService questionService,
                           AnswerService answerService) {
        this.repository = repository;
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @Override
    @Transactional
    public List<Test> getTestsBySubjectId(int id) {
        return repository.findAllBySubjectId(id);
    }

    @Override
    @Transactional
    public FullTestResponse getTestById(long id) {
        Test test = repository.findById(id).orElseThrow(() -> new RuntimeException("Test not found"));
        List<Question> questions = questionService.getQuestionsByTestId(test.getId());
        List<TestQuestion> testQuestions = new ArrayList<>();
        for(Question question: questions){
            List<Answer> answers = answerService.getAnswersByQuestionId(question.getId());
            List<QuestionAnswer> questionAnswers = new ArrayList<>();
            for(Answer answer: answers){
                QuestionAnswer questionAnswer =
                        new QuestionAnswer(answer.getId(), answer.getText(), answer.getCorrectness());
                questionAnswers.add(questionAnswer);
            }
            TestQuestion testQuestion =
                    new TestQuestion(question.getId(), question.getText(), questionAnswers);
            testQuestions.add(testQuestion);
        }
        return new FullTestResponse(test.getId(), test.getName(), test.getDescription(), testQuestions);
    }
}
