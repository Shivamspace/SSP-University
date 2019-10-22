package jorge.rv.quizzz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jorge.rv.quizzz.model.Question;
import jorge.rv.quizzz.model.Quiz;

@Repository("QuestionRepository")
public interface QuestionRepository extends JpaRepository<Question, Long> {
	int countByQuiz(Quiz quiz);

	int countByQuizAndIsValidTrue(Quiz quiz);
	


	List<Question> findByQuizOrderByOrderAsc(Quiz quiz);
	
	@Query(value="select * from((SELECT * FROM question where difficulty='HARD'  limit 10)\r\n" + 
			"union (SELECT * FROM test.question where difficulty='MEDIUM'   limit 10)\r\n" + 
			"Union (SELECT * FROM test.question where difficulty='EASY'  limit 10)) AS T1  where quiz_id =?1 order by rand();",nativeQuery = true)
	List<Question> findByQuizAndIsValidTrueOrderByOrderAsc1(int quiz);
}
