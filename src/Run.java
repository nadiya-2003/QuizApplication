import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Run
{
	public static void main(String[] args) 
	{
		try
		{
		        Scanner scanner = new Scanner(System.in);
		        System.out.println("*****----------WELCOME TO QUIZ-----------****");
		        System.out.println("Enter your first name: ");
		        String firstName = scanner.nextLine();
		        System.out.println("Enter your last name: ");
		        String lastName = scanner.nextLine();
		        System.out.println("Enter your place: ");
		        String place = scanner.nextLine();
		        System.out.println("Enter your email: ");
		        String email = scanner.nextLine();
		        System.out.println("Enter your contact number: ");
		        String contactNumber = scanner.nextLine();
		        PlayerDetails player = new PlayerDetails(firstName, lastName, place, email, contactNumber);
		        Quiz quiz = new Quiz();
		        quiz.startQuiz(player, scanner);
		}
		catch(InputMismatchException e)
		{
			System.out.println("Please enter a valid Input");
		}
	}

}
