import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class QuizReader {
	private String mFile;
	
	public QuizReader(String file)
	{
		mFile = file;
	}
	
	public Quiz parseKey() throws NoSuchElementException, FileNotFoundException
	{
		Scanner sc = new Scanner(new File(mFile));
		Quiz quiz = new Quiz();
		
		while(sc.hasNextLine())
		{
			String type = sc.nextLine();
			Question question;
			boolean choiceQuestion = false;
			if (type.equals("M"))
			{
				question = new MultipleChoiceQuestion();
				choiceQuestion = true;
			}
			else if (type.equals("N"))
			{
				question = new NumberQuestion();
			}
			else if (type.equals("S"))
			{
				question = new SingleChoiceQuestion();
				choiceQuestion = true;
			}
			else if (type.equals("T"))
			{
				question = new TextQuestion();
			}
			else
			{
				throw new NoSuchElementException("Did not get a valid question type");
			}

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
				throw new NoSuchElementException("Unexpected end of file reached");
			}
			
			question.parseKey(key);
			
			quiz.addQuestion(question);
		}
		return quiz;
	}
}
