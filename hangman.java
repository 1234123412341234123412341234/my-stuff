import java.util.Scanner;

public class hangman {

	public static void main(String[] args) 
	{
		String[] list = {"arthur", "john", "dutch", "micah", "hosea"};
		String word = list[(int)(Math.random()*list.length)], guessWord = toHidden(word), guess = "", saveGuess = "";
		int wrong = 0;
		Boolean guessCorrect = false, exit = true; 
		Scanner scan = new Scanner(System.in);
		System.out.println("If you want to guess a letter please enter a single letter\nIf you wish to guess the word please enter a word with the same amount of letters as the word you are trying to guess");
		while(wrong < 6 && !guess.equals(word) && exit == true)
		{
			System.out.println(guessWord);
			System.out.println(man(wrong));
			System.out.println("This is hang man, you have " + (6 - wrong) + " more guesses. Please enter your guess.");
			guess = scan.nextLine();
			if(guess.length() == 1)
			{
				guessCorrect = false;
				saveGuess = guessWord;
				guessWord = "";
				for(int i = 0; i < word.length(); i++)
				{
					if(word.substring(i, i+1).equals(guess))
					{
						guessWord += guess;
						guessCorrect = true;
						
					}
					else if(word.substring(i, i+1).equals(saveGuess.substring(i, i+1)))
					{
						guessWord += saveGuess.substring(i, i+1);
					}
					else
					{
						guessWord += "-";
					}//end if 
				}//end loop
				if(guessWord.equals(word))
				{
					System.out.println(guessWord);
					System.out.println(man(wrong));
					exit = false;
				}//end if 
				saveGuess = guessWord;
				if(guessCorrect == true)
				{
					System.out.println("Your guess was correct.");
				}
				else
				{
					System.out.println("Your guess was wrong.");
					wrong ++;
				}
			}
			else if(guess.length() == word.length())
			{
				if(!guess.equals(word))
				{
					wrong++;
				}//end if
			}
			else
			{
				System.out.println("Please enter one letter or a word with the same amout of letters as the word you are trying to guess");
			}//end if
		}//end loop
		scan.close();
		if(wrong > 5)
		{
			System.out.println("You lost, the word was " + word);
		}
		else 
		{
			System.out.println("You won, the word was " + word);
		}//end if
	}//end main
	
	public static String man(int wrong)
	{
		if(wrong == 0)
		{
			return(" o\n/|\\\n/ \\");
		}
		else if(wrong == 1)
		{
			return(" o\n/|\\\n/");
		}
		else if(wrong == 2)
		{
			return(" o\n/|\\");
		}
		else if(wrong == 3)
		{
			return(" o\n/|");
		}
		else if(wrong == 4)
		{
			return(" o\n/");
		}
		else if(wrong == 5)
		{
			return(" o");
		}
		else
		{
			return ("");
		}//end if
	}//end man
	public static String toHidden(String word)
	{
		String hidden = "";
		for(int i = 0; i < word.length(); i++)
		{
			hidden += "-";
		}
		return hidden;
	}//end toHidden	

}
