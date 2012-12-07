import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

/**
 * A multiple choice question with more than one correct answer
 */
public class MultipleChoiceQuestion implements Question {
	private String myPrompt;
	private ArrayList<String> myAnswers;
	private ArrayList<String> myCorrectAnswers;
	public static final String TYPE = "M";
	private int maxScore;
	
	/**
	 * Constructs a new multiple choice question
	 * @param input contains question prompt and answer
	 */
	public MultipleChoiceQuestion(ArrayList<String> input)
	{
		myAnswers = new ArrayList<String>();
		myCorrectAnswers = new ArrayList<String>();
		parseKey(input);
	}
	
	/**
	 * Initializes variable based on input from the key
	 * @param key the String[] from which to extract information
	 */
	public void parseKey(ArrayList<String> key) {
		if(key.size() < 2)
			throw new NoSuchElementException();
		
		for(int i = 1; i < key.size(); i++)
		{
			String line = key.get(i);
			String answer = line.substring(2).trim();
			String type = line.substring(0, 1);
			if (type.equals("+"))
			{
				myCorrectAnswers.add(answer);
			}
			else if (!(type.equals("-")))
			{
				throw new NoSuchElementException("Got invalid record in MC Question");
			}
			myAnswers.add(answer);
		}
		maxScore = myAnswers.size();
		
		myPrompt = key.get(0);
		for (String answer : myAnswers)
		{
			myPrompt += "\n" + answer;
		}
	}

	/**
	 * Returns the question's type
	 * @return the qestion's type
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
		String[] responses =answer.split(" ");
		// Initial score = # of incorrect answers
		int score = myAnswers.size() - myCorrectAnswers.size();
		
		for (String response : responses)
		{
			if (!myAnswers.contains(response))
			{
				throw new InputMismatchException(response + " is not one of the answers");
			}
			if (myCorrectAnswers.contains(response))
			{
				score++;
			}
			else
			{
				score--;
			}
		}
		return (double) score / maxScore;
	}

}
