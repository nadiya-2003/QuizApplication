import java.util.InputMismatchException;
import java.util.Scanner;

public class Quiz
{
    private Questions[] questions;
    private boolean[] lifelinesUsed; 

    public Quiz() 
    {
        this.questions = initializeQuestions();
        this.lifelinesUsed = new boolean[]{false, false}; 
    }

    public void startQuiz(PlayerDetails player, Scanner scanner)
    {
    	try
    	{
        System.out.println("Are you ready to take the quiz? (yes/no)");
        String response = scanner.nextLine();
        if (!response.equals("yes"))
        {
            System.out.println("You have chosen to exit the game,Toodles!");
            return;
        }

        System.out.println("Rules of the game:");
        System.out.println("1. You will be asked multiple choice questions.");
        System.out.println("1. You will .");
        System.out.println("2. For each question, you can choose an answer.");
        System.out.println("3. You have two lifelines: 50-50 and Audience Poll.");
        System.out.println("4. Lifelines can only be used once.");
        System.out.println("5. If you answer incorrectly, the game ends with the points you've won.");

        for (Questions question : questions)
        {
            System.out.println("\n" + question.getQuestion());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++)
            {
                System.out.println((i + 1) + ". " + options[i]);
            }

           
            System.out.println("Choose your answer (1-4) or type 'lifeline' to use a lifeline:");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("lifeline"))
            {
                useLifeline(scanner, question);
                System.out.println("Now choose your answer (1-4):");
                choice = scanner.nextLine();
                
               
                	
            }

            int answer = Integer.parseInt(choice) - 1;

            if (answer == question.getCorrectOption())
            {
                player.addPoints(question.getReward());
                System.out.println("Correct! You have won: " + player.getTotalPoints() + " points.");
            } 
            else 
            {
                System.out.println("Wrong answer! You leave with: " + player.getTotalPoints() + " points.");
                return;
            }
        }

        System.out.println("Congratulations! You completed the quiz and won: " + player.getTotalPoints() + " points.");
    }
    	catch(InputMismatchException e1)
    	{
    		System.out.println("Please enter a valid Input");
    	}
    }
    private void useLifeline(Scanner scanner, Questions question)
    {
        if (lifelinesUsed[0] && lifelinesUsed[1]) 
        {
            System.out.println("No lifelines remaining. Choose an answer.");
            return; 
        }

        System.out.println("Available lifelines:");
        if (!lifelinesUsed[0]) System.out.println("1. 50-50");
        if (!lifelinesUsed[1]) System.out.println("2. Audience Poll");

        System.out.print("Choose a lifeline: ");
        int lifelineChoice = Integer.parseInt(scanner.nextLine());

        if (lifelineChoice == 1 && !lifelinesUsed[0]) 
        {
            lifelinesUsed[0] = true;

            String[] options = question.getOptions();
            int correctOption = question.getCorrectOption();
            String[] incorrectOptions = new String[options.length - 1];

           
            int index = 0;
            for (int i = 0; i < options.length; i++) 
            {
                if (i != correctOption)
             {
                    incorrectOptions[index++] = options[i];
             }
            }

            
          String removedOption1 = incorrectOptions[0];
           String removedOption2 = incorrectOptions[1];


            System.out.println("50-50 lifeline used. Two incorrect options have been removed.");
           
           
  
            System.out.println("Remaining options: ");
            for (int i = 0; i < options.length; i++)
            {
                if (i == correctOption || (i != correctOption && !options[i].equals(removedOption1) && !options[i].equals(removedOption2)))
                {
                    System.out.println((i + 1) + ". " + options[i]);
                }
                
            }
         
        } 
        else if (lifelineChoice == 2 && !lifelinesUsed[1]) 
        {
            lifelinesUsed[1] = true;
         
          
            String[] options = question.getOptions();
            int correctOption = question.getCorrectOption();

            int[] pollResults = new int[options.length];
            pollResults[correctOption] = 70;  

          
            int remainingPercentage = 30;
            for (int i = 0; i < pollResults.length; i++) {
                if (i != correctOption) {
                    pollResults[i] = remainingPercentage / (options.length - 1);  
                }
            }

          
            System.out.println("Audience Poll results:");
            for (int i = 0; i < options.length; i++)
            {
                System.out.println((i + 1) + ". " + options[i] + " - " + pollResults[i] + "%");
            }
            System.out.println("You have left with only one lifeline i.e  50-50");
        } 
        else
        {
            System.out.println("Invalid choice or lifeline already used.");
        }
    }

    private Questions[] initializeQuestions() 
    {
        return new Questions[] 
        		{
        		new Questions("Question 1 : Who is known as Chase Master", new String[]
        				{"Virat Kohli", "Rohit Sharma", "MS Dhoni", "Sachin Tendulkar"}, 0, 100),
        		new Questions("Question 2 :What is the National Animal", new String[]
        				{"Lion", "Tiger", "Elephant", "Giraffe"}, 1, 100),
        		new Questions("Question 3 :Order of Rainbow", new String[]
        				{"VIBYGOR", "VBIYGOR", "VIBGYOR", "VYOIGYR"}, 2, 100),
        		new Questions("Question 4:A Holy Book RAMAYANAM was written by ", new String[]
        				{"Nannaya", "Thikana", "Valmiki", "Ved Vyasa"}, 2, 100),
        		new Questions("Question 5 :Who is the youngest Chess GrandMaster in India  ", new String[]
        				{"Abhimanyu Mishra", "Gukesh Dommaraju", "Sergey karjakin", "Raunak Sadhwani"}, 1, 100),
        		new Questions("Question 6 :Who wrote 'Romeo and Juliet'?", new String[] 
        				{"Shakespeare", "Dickens", "Hemingway", "Austen"}, 0, 100),
        		new Questions("Question 7 :who is the prime minister of India", new String[] 
        				{"Ronald Trump", "Narendra Modi", "Draupadi murmu", "venkaaiah naidu"}, 1, 100),
        		new Questions("Question 8 :which state is also know as God's Own  Country", new String[] 
        				{"AndhraPradesh", "Telanga", "Maharashtra", "Kerala"}, 3, 100),
        		new Questions("Question 9 :what is the 10th element in Periodic table", new String[] 
        				{"Hydrogen", "Berilium", "Oxygen", "neon"}, 3, 100),
        		new Questions("Question 10 :who is the founder of Java", new String[] 
        				{"Dennis Ritche", "GauidoVanRossum" ,"James Gosling","BjarneStroutStrup"}, 2, 100),
        		
        };
    }
}
