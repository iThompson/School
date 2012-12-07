import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

/**
 * A multiple choice question with only 1 correct answer
 */
public class SingleChoiceQuestion implements Question {

	public static final String TYPE ="S";
	private String myPrompt;
	private ArrayList<String> myAnswers;
	private String myCorrectAnswer;
	
	/**
	 * Constructs a new single choice question
	 * @param input contains question prompt and answer
	 */
	public SingleChoiceQuestion(ArrayList<String> input)
	{
		myCorrectAnswer = null;
		myAnswers = new ArrayList<String>();
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
				if (myCorrectAnswer != null)
				{
					throw new InputMismatchException("Got multiple answers in SC Question");
				}
				
				myCorrectAnswer = answer;
			}
			else if (!(type.equals("-")))
			{
				throw new InputMismatchException("Got invalid record in MC Question");
			}
			myAnswers.add(answer);
		}
		
		myPrompt = key.get(0);
		for (String answer : myAnswers)
		{
			myPrompt += "\n" + answer;
		}
	}

	/**
	 * Returns the question's type
	 * @return the question's type
	 */
	public String getType() {
		return TYPE;
	}

	/**
	 * Returns the question's prompt
	 * @return the qestion's prompt
	 */
	public String getPrompt() {
		return myPrompt;
	}

	/**
	 * Returns a grade based on a given answer
	 * @param answer the given answer
	 * @return the grade
	 */
	public double gradeAnswer(String answer) {
		if (!myAnswers.contains(answer))
		{
			throw new InputMismatchException(answer + " is not a valid answer");
		}
		if (myCorrectAnswer.equals(answer))
			return 1;
		else 
			return 0;
	}

}
