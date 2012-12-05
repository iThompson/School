import java.io.FileNotFoundException;
import java.util.InputMismatchException;

/**
 * Tests the Quiz classes by loading a quiz and giving it to the user
 */
public class QuizTester
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		QuizReader reader = new QuizReader("quiz1.txt");
		Quiz quiz;
		try
		{
			quiz = reader.parseKey();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Could not find answer key!");
			return;
		}
		catch (InputMismatchException e)
		{
			System.out.println(e.getMessage());
			return;
		}
		
		QuizAdministrator admin = new QuizAdministrator(quiz);
		double score = admin.giveQuiz();
		System.out.println("Your score is " + score * 100 + "%");
	}

}
