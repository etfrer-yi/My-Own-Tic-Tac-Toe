import java.util.Scanner;
public class TicTacToeFinal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Defining the grid, a placeholder for player choice, a boolean for whether game ends, and a tally for game count
        // The tally for game count is useful in that depending on whether the game count is odd or even, it's one player or the other player's turn
        char[][] gridPawnLocations = new char[3][3];
        char playerChoice = 'a';
        boolean gameEnd = false;
        int gameCount = 0;
  
        while (!gameEnd) {
            
            // Depending on whether odd or even, game count dictates whether it's X's turn or O's turn
            if (gameCount % 2 == 0) {
                System.out.println("It's player X's turn!");
                playerChoice = 'X';
            }
            else if (gameCount % 2 != 0) {
                System.out.println("It's player O's turn!");
                playerChoice = 'O';  
            }
            
            // We define booleans for whether the row & column inputs of the user are valid, and another boolean 
            // for whether the location on the board has already been taken by a previous move
            // all booleans are initialized to false to enter the while loop(s) that check for their validity
            boolean rowInputInRange = false;
            boolean columnInputInRange = false;
            boolean locationNotTaken = false;
            
            // Outer while loop for checking that asks for input as long as the inputted [row,column] position has already taken
            // This outer loop includes two inner loops, each checking for a valid row and column input
            while (!locationNotTaken) {
                
                int rowInput = 0;
                int colInput = 0;
                
                // Asking for row input
                /* NOTE: it is true that I could ask for the row input within the while loop itself.
                However, the problem is that the outer loop checks for whether location is already
                taken. If the location is already taken, and we go back to the beginning of the loop,
                the user has to be asked to enter another row input*/
                System.out.println("Enter row input (i): ");
                rowInput = input.nextInt();
                
                // Inner loop checking that row input is valid
                while (!rowInputInRange) {
                     
                    // Error message or passing to the next error detection
                    if (rowInput < 0 || rowInput > 2) {
                        System.out.println("Error: row input not in range");   
                        
                         // Redemanding for row input
                        System.out.println("Enter row input (i): ");
                        rowInput = input.nextInt();
                    }
                    else {
                        rowInputInRange = true;
                    }
                }               
                
                // Asking for column input
                System.out.println("Enter column input (j): ");
                colInput = input.nextInt();
                
                // Inner loop checking that column input is valid
                while (!columnInputInRange) {

                    // Error message or passing to the next error detection
                    if (colInput < 0 || colInput > 2) {
                        System.out.println("Error: column input not in range");  
                        // Redemanding for column input
                        System.out.println("Enter column input (j): ");
                        colInput = input.nextInt();
                    }
                    else {
                        columnInputInRange = true;
                    }
                }              
                
                // After getting valid row and column inputs, check if that position on the game board has already been taken
                // If position is already taken, go back to the beginning of the outer while loop 
                if (gridPawnLocations[rowInput][colInput] == '\u0000') {
                    gridPawnLocations[rowInput][colInput] = playerChoice;
                    locationNotTaken = true;
                }
                else if (gridPawnLocations[rowInput][colInput] != '\u0000'){
                    System.out.println("Error: grid location already taken");
                    System.out.println("Input another value");
                }
            }             
            
            // Setting the tic-tac-toe table
            System.out.println("The game currently looks like this: ");
            System.out.println("-------------");
            
            // Outer for loop for the each row, inner for loop for each case in each row
            for (int i = 0; i < gridPawnLocations.length; i++) {
                System.out.print("|");
                for (int j = 0; j < gridPawnLocations[0].length; j++) {
                    if (gridPawnLocations[i][j] == '\u0000') {
                        System.out.print("   |");
                    }
                    else if (gridPawnLocations[i][j] != '\u0000') {
                        System.out.print(" " + gridPawnLocations[i][j] + " |");
                    }
                }
                System.out.println("");
                System.out.println("-------------");
            }
            
            // Determining winning condition: if a line of three pawns formed for either 'X' or 'O'
            if  (( // Diagonal of three pawns formed
                (gridPawnLocations[0][0] == 'X' && gridPawnLocations[1][1] == 'X' && gridPawnLocations[2][2] == 'X') ||
                (gridPawnLocations[2][0] == 'X' && gridPawnLocations[1][1] == 'X' && gridPawnLocations[0][2] == 'X') ||
                 
                 // Row of three pawns formed
                (gridPawnLocations[0][0] == 'X' && gridPawnLocations[0][1] == 'X' && gridPawnLocations[0][2] == 'X') ||
                (gridPawnLocations[1][0] == 'X' && gridPawnLocations[1][1] == 'X' && gridPawnLocations[1][2] == 'X') ||
                (gridPawnLocations[2][0] == 'X' && gridPawnLocations[2][1] == 'X' && gridPawnLocations[2][2] == 'X') ||
                 
                // Column of three pawns formed
                (gridPawnLocations[0][0] == 'X' && gridPawnLocations[1][0] == 'X' && gridPawnLocations[2][0] == 'X') || 
                (gridPawnLocations[0][1] == 'X' && gridPawnLocations[1][1] == 'X' && gridPawnLocations[2][1] == 'X') || 
                (gridPawnLocations[0][2] == 'X' && gridPawnLocations[1][2] == 'X' && gridPawnLocations[2][2] == 'X')
                ) ||
                       
                ( // Diagonal of three pawns formed
                (gridPawnLocations[0][0] == 'O' && gridPawnLocations[1][1] == 'O' && gridPawnLocations[2][2] == 'O') ||
                (gridPawnLocations[2][0] == 'O' && gridPawnLocations[1][1] == 'O' && gridPawnLocations[0][2] == 'O') ||
                 
                 // Row of three pawns formed
                (gridPawnLocations[0][0] == 'O' && gridPawnLocations[0][1] == 'O' && gridPawnLocations[0][2] == 'O') ||
                (gridPawnLocations[1][0] == 'O' && gridPawnLocations[1][1] =='O' && gridPawnLocations[1][2] == 'O') ||
                (gridPawnLocations[2][0] == 'O' && gridPawnLocations[2][1] == 'O' && gridPawnLocations[2][2] == 'O') ||
                 
                // Column of three pawns formed
                (gridPawnLocations[0][0] == 'O' && gridPawnLocations[1][0] == 'O' && gridPawnLocations[2][0] == 'O') || 
                (gridPawnLocations[0][1] == 'O' && gridPawnLocations[1][1] == 'O' && gridPawnLocations[2][1] == 'O') || 
                (gridPawnLocations[0][2] == 'O' && gridPawnLocations[1][2] == 'O' && gridPawnLocations[2][2] == 'O')
                )) {
                
                gameEnd = true;
                System.out.println("GAME ENDED");
            }
            
            // If game not ended, add 1 to gameCount
            else {
                gameCount++;             
            }
           
        }
    }   
}

