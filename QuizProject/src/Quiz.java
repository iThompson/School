import java.util.List;
import java.util.ArrayList;


public class Quiz {
	private ArrayList<Question> mQuestions;
	
	public Quiz()
	{
		mQuestions = new ArrayList<Question>();
	}
	
	public void addQuestion(Question q)
	{
		mQuestions.add(q);
	}
	
	public List<Question> getQuestions()
	{
		return mQuestions;
	}
}
