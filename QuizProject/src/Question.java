import java.util.ArrayList;

/**
 * An interface which describes a Question
 */
public interface Question {
	/**
	 * Initializes variable based on input from the key
	 * @param key the String[] from which to extract information
	 */
	void parseKey(ArrayList<String> key);
	/**
	 * Returns the question's type
	 * @return the qestion's type
	 */
	String getType();
	/**
	 * Returns the question's prompt
	 * @return the qestion's prompt
	 */
	String getPrompt();
	/**
	 * Returns a grade based on a given answer
	 * @param answer the given answer
	 * @return the grade
	 */
	double gradeAnswer(String answer);
}
