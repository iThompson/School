import java.util.ArrayList;


public class SingleChoiceQuestion implements Question {

	public static final String TYPE ="S";
	private String myPrompt;
	private String myAnswer;
	
	/**
	 * Constructs a new single choice question
	 * @param input contains question prompt and answer
	 */
	public SingleChoiceQuestion(ArrayList<String> input)
	{
		parseKey(input);
	}
	
	/**
	 * Initializes variable based on input from the key
	 * @param key the String[] from which to extract information
	 */
	public void parseKey(ArrayList<String> key) {
		myPrompt = key.get(0);
		myAnswer = key.get(1);
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
		if (myAnswer.equals(answer))
			return 1;
		else 
			return 0;
	}

}
