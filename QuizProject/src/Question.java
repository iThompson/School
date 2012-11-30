import java.util.ArrayList;


public interface Question {
	void parseKey(ArrayList<String> key);
	String getType();
	String getPrompt();
	double gradeAnswer(String answer);
}
