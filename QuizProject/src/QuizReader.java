import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * A class to handle parsing the answer key
 * @author Ian Thompson
 */
public class QuizReader {
	private String mFile;
	
	/**
	 * Creates the QuizReader, given the path to the key
	 * @param file The path to the key
	 */
	public QuizReader(String file)
	{
		mFile = file;
	}
	
	/**
	 * Returns whether the given Question type is a ChoiceQuestion
	 * @param type The question type
	 * @return Whether it is a ChoiceQuestion
	 */
	private boolean isChoiceQuestion(String type)
	{
		if (type.equals("M"))
		{
			return true;
		}
		else if (type.equals("N"))
		{
			return false;
		}
		else if (type.equals("S"))
		{
			return true;
		}
		else if (type.equals("T"))
		{
			return false;
		}
		else
		{
			throw new NoSuchElementException("Did not get a valid question type");
		}
	}
	
	/**
	 * Creates a Question, given the type and key
	 * @param type The type of the Question
	 * @param key The Question's answer key
	 * @return The Question
	 */
	private Question createQuestion(String type, ArrayList<String> key)
	{
		if (type.equals("M"))
		{
			return new MultipleChoiceQuestion(key);
		}
		else if (type.equals("N"))
		{
			return new NumberQuestion(key);
		}
		else if (type.equals("S"))
		{
			return new SingleChoiceQuestion(key);
		}
		else if (type.equals("T"))
		{
			return new TextQuestion(key);
		}
		else
		{
			throw new NoSuchElementException("Did not get a valid question type");
		}
	}

	/**
	 * Parses the key file and returns a Quiz
	 * @return The Quiz described by the key file
	 * @throws InputMismatchException When a syntax error in the key is found
	 * @throws FileNotFoundException When the key file doesn't exist
	 */
	public Quiz parseKey() throws InputMismatchException, FileNotFoundException
	{
		Scanner sc = new Scanner(new File(mFile));
		Quiz quiz = new Quiz();
		
		while(sc.hasNextLine())
		{
			String type = sc.nextLine();
			boolean choiceQuestion = isChoiceQuestion(type);

			ArrayList<String> key = new ArrayList<String>();
			try
			{
				if (choiceQuestion)
				{ // Question descriptor runs until newline
					String line = sc.nextLine();
					while(!(line.equals("")))
					{
						key.add(line);
						line = sc.nextLine();
					}
				}
				else
				{
					key.add(sc.nextLine()); // Question text
					key.add(sc.nextLine()); // Answer
				}
			}
			catch (NoSuchElementException e)
			{
				sc.close();
				throw new InputMismatchException("Unexpected end of file reached");
			}
			
			quiz.addQuestion(createQuestion(type, key));
		}
		sc.close();
		return quiz;
	}
}
