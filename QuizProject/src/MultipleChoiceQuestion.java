import java.util.ArrayList;
import java.util.NoSuchElementException;


public class MultipleChoiceQuestion implements Question {
	private String myPrompt;
	private ArrayList<String> myAnswers;
	public static final String TYPE = "M";
	private int maxScore;
	
	/**
	 * Constructs a new multiple choice question
	 * @param input contains question prompt and answer
	 */
	public MultipleChoiceQuestion(ArrayList<String> input)
	{
		parseKey(input);
	}
	
	/**
	 * Initializes variable based on input from the key
	 * @param key the String[] from which to extract information
	 */
	public void parseKey(ArrayList<String> key) {
		maxScore = key.size()-1;
		if(key.size() < 2)
			throw new NoSuchElementException();
		myPrompt = key.get(0);
		for(int i = 1; i < key.size(); i++)
			myAnswers.add(key.get(i));
	}

	/**
	 * Returns the question's type
	 * @return the question's type
	 */
	public String getType() 
	{
		return TYPE;
	}

	/**
	 * Returns the question's prompt
	 * @return the qestion's prompt
	 */
	public String getPrompt() 
	{
		return myPrompt;
	}

	/**
	 * Returns a grade based on a given answer
	 * @param answer the given answer
	 * @return the grade
	 */
	public double gradeAnswer(String answer) 
	{
		String[] answers =answer.split(" ");
		double score = 0;
		for(int i =0; i< answers.length; i++)
		{
			if(myAnswers.contains(answers[i]));
			score ++;
		}
		return score / maxScore;
	}

}
