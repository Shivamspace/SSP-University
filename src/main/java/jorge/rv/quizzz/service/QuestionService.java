package jorge.rv.quizzz.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import jorge.rv.quizzz.exceptions.ResourceUnavailableException;
import jorge.rv.quizzz.exceptions.UnauthorizedActionException;
import jorge.rv.quizzz.model.Answer;
import jorge.rv.quizzz.model.Question;
import jorge.rv.quizzz.model.Quiz;

public interface QuestionService {
	Question save(Question question) throws UnauthorizedActionException;

	Question find(Long id) throws ResourceUnavailableException;


	List<Question> findQuestionsByQuiz(Quiz quiz);


	List<Question> findValidQuestionsByQuiz(int quiz);
	


	Question update(Question question) throws ResourceUnavailableException, UnauthorizedActionException;

	void delete(Question question) throws ResourceUnavailableException, UnauthorizedActionException;

	Boolean checkIsCorrectAnswer(Question question, Long answer_id);

	void setCorrectAnswer(Question question, Answer answer);

	Answer getCorrectAnswer(Question question);

	Answer addAnswerToQuestion(Answer answer, Question question);

	int countQuestionsInQuiz(Quiz quiz);

	int countValidQuestionsInQuiz(Quiz quiz);
}
