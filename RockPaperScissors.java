import java.util.Scanner;
public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        
        // Displaying input request and instrucitons
        System.out.println("Welcome to the game of rock-paper-scissors!\n");
        System.out.println("Please enter your choice (1 for rock, 2 for paper, 3 for scissors, 0 to exit program)");
        int userChoice = input.nextInt();
        
        // Defining wins, losses, and games played
        int wins = 0;
        int losses = 0;
        int gamesPlayed = 0;
        
        while (userChoice != 0) {
            
            // Loop for checking that user's choice is valid
            while (userChoice != 1 && userChoice != 2 && userChoice != 3 && userChoice != 0) {
                System.out.println("Your input is invalid! ");
                System.out.println("Please enter your choice (1 for rock, 2 for paper, 3 for scissors, 0 to exit program)");
                userChoice = input.nextInt();
            }
            
            // Checking for the different match possibilities: tie, win, and loss
            int computerChoice = computerChoice();
               // Tie
            if (userChoice == computerChoice) {
                System.out.println("It's a tie!" + " Neither beats the other");
            }
               // Win
            else if ((userChoice == 1 && computerChoice == 3)
                    || (userChoice == 2 && computerChoice == 1)
                    || (userChoice == 3 && computerChoice == 2)) {
                System.out.println("You win! " + choiceName(userChoice) + " beats " + choiceName(computerChoice));
                wins += 1;
            }
               // Loss
            else if ((userChoice == 1 && computerChoice == 2)
                    || (userChoice == 2 && computerChoice == 3)
                    || (userChoice == 3 && computerChoice == 1)) {
                System.out.println("You lose! " + choiceName(userChoice) + " loses to " + choiceName(computerChoice));
                losses += 1;
            }
            
            // Printing summary of game so far
            gamesPlayed += 1;
            System.out.println("You have chosen " + choiceName(userChoice) + " and the computer has chosen " + choiceName(computerChoice));
            System.out.println("\nYou have played " + gamesPlayed + " so far, "
                    + "" + " won " + wins + " games, and lost " + losses + " games");
            
            // Asking for the next user input
            System.out.println("Please enter another choice (1 for rock, 2 for paper, 3 for scissors, 0 to exit program)");
            userChoice = input.nextInt();
        }
        
        // Printing summary of the game
        System.out.println("Game over!");
        System.out.println("Total games played: " + gamesPlayed);
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        
        
    }
    
    public static int computerChoice() {
        int computerChoice = 1 + (int) (Math.random() * 3);
        return computerChoice;
    }
    
    public static String choiceName(int choiceNumber) {
        String choiceName;
        switch (choiceNumber) {
            case 1: choiceName = "Rock";
                break;
            case 2: choiceName = "Paper";
                break;
            default: choiceName = "Scissors";
        }
        return choiceName;
    }
}
