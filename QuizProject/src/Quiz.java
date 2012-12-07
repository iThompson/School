import java.util.List;
import java.util.ArrayList;

/**
 * Represents a Quiz, and contains questions
 */
public class Quiz {
	private ArrayList<Question> mQuestions;
	
	/**
	 * Creates an empty quiz
	 */
	public Quiz()
	{
		mQuestions = new ArrayList<Question>();
	}
	
	/**
	 * Adds a Question to this quiz
	 * @param q The Question to add
	 */
	public void addQuestion(Question q)
	{
		mQuestions.add(q);
	}
	
	/**
	 * Returns the list of questions
	 * @return The list of questions
	 */
	public List<Question> getQuestions()
	{
		return mQuestions;
	}
}
