import java.io.FileNotFoundException;


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
		
		QuizAdministrator admin = new QuizAdministrator(quiz);
	}

}
