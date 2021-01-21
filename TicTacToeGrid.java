import java.util.Scanner;
public class TicTacToeGrid {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter an input (1-9)");
        int placeHolder = input.nextInt();
        
        for (int i = 0; i <= 2; i++) {
            System.out.println("---------------------");
            System.out.println("");
            if (i == ((placeHolder -1) / 3)) {
                System.out.println("   |    |    |    |");
                for (int j = 0; j <= 4; j++) {
                    if (j < placeHolder % 3 || j > placeHolder % 3) {
                        System.out.print("  |  ");
                    }
                    else if (((placeHolder % 3 !=0) && (j == placeHolder % 3)) || ((placeHolder % 3 == 0) && (j == 3))) {
                        System.out.print("O");
                    }
                }
                System.out.println("");
                System.out.print("   |    |    |    |");
                System.out.println("");
            }
            
            else {
                for (int j = 0; j <= 2; j++) {
                    System.out.println("   |    |    |    |");
                }
            }
        }
    }
}

