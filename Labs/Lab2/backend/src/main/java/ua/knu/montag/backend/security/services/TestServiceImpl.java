package ua.knu.montag.backend.security.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.knu.montag.backend.models.Answer;
import ua.knu.montag.backend.models.Question;
import ua.knu.montag.backend.models.Subject;
import ua.knu.montag.backend.models.Test;
import ua.knu.montag.backend.payload.FullTest;
import ua.knu.montag.backend.payload.QuestionAnswer;
import ua.knu.montag.backend.payload.TestQuestion;
import ua.knu.montag.backend.repository.TestRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestServiceImpl implements TestService{
    private final TestRepository repository;
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final SubjectService subjectService;

    public TestServiceImpl(TestRepository repository, QuestionService questionService,
                           AnswerService answerService, SubjectService subjectService) {
        this.repository = repository;
        this.questionService = questionService;
        this.answerService = answerService;
        this.subjectService = subjectService;
    }

    @Override
    @Transactional
    public List<Test> getTestsBySubjectId(int id) {
        return repository.findAllBySubjectId(id);
    }

    @Override
    @Transactional
    public FullTest getTestById(long id) {
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
        return new FullTest(test.getId(), test.getSubject().getId(), test.getName(),
                test.getDescription(), testQuestions);
    }

    @Override
    @Transactional
    public void addTest(FullTest test) {
        Subject subject = subjectService.getSubjectById(test.getSubjectId());
        Test testInfo = new Test(subject, test.getName(), test.getDescription());
        repository.save(testInfo);
        long testId = repository.getLastCreatedTestId();
        Test createdTest = repository.findById(testId)
                .orElseThrow(() -> new RuntimeException("No test found with id: "+testId));
        for(TestQuestion tq: test.getQuestions()){
            questionService.addQuestion(tq, createdTest);
            long questionId = questionService.getLastCreatedQuestionId();
            Question createdQuestion = questionService.getQuestionById(questionId);
            for(QuestionAnswer qa: tq.getAnswers()){
                answerService.addAnswer(qa, createdQuestion);
            }
        }
    }
}
