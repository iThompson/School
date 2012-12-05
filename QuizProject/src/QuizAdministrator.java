import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Prompts the user with questions from the given Quiz
 */
public class QuizAdministrator {
	private Quiz mQuiz;
	
	/**
	 * Creates the QuizAdministrator with the Quiz which will be administered
	 * @param quiz The Quiz which will be administered
	 */
	public QuizAdministrator(Quiz quiz)
	{
		mQuiz = quiz;
	}
	
	/**
	 * Prompts the user for answers to all the questions, and returns the score
	 * @return The score, from 0 to 1
	 */
	public double giveQuiz()
	{
		Scanner sc = new Scanner(System.in);
		int numQuestions = mQuiz.getQuestions().size();
		double score = 0;
		for (Question question : mQuiz.getQuestions())
		{
			boolean validAnswer = false;
			while (!validAnswer)
			{
				System.out.println(question.getPrompt());
				String response = sc.nextLine();
				try
				{
					score += question.gradeAnswer(response);
					validAnswer = true;
				}
				catch (InputMismatchException e)
				{
					System.out.println(e.getMessage());
					System.out.println();
					validAnswer = false;
				}
			}
			System.out.println();
		}		
		sc.close();
		
		return score / numQuestions;
	}
}
