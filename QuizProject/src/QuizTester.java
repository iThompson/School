
public class QuizTester
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		QuizReader reader = new QuizReader("quiz1.txt");
		Quiz quiz = reader.parseKey();

	}

}
