import java.util.ArrayList;
import java.util.NoSuchElementException;


public class TextQuestion implements Question {
	public static final String TYPE ="T";
	private String myPrompt;
	private String myAnswer;
	
	/**
	 * Constructs a new text question
	 * @param input contains question prompt and answer
	 */
	public TextQuestion(ArrayList<String> input)
	{
		parseKey(input);
	}
	
	/**
	 * Initializes variable based on input from the key
	 * @param key the String[] from which to extract information
	 */
	public void parseKey(ArrayList<String> key) 
	{
		if(key.size() != 2)
			throw new NoSuchElementException();
		myPrompt = key.get(0);
		myAnswer = key.get(1);
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
		if(answer.equals(myAnswer))
			return 1;
		else
			return 0;
	}

}
