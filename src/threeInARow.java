

import java.util.Scanner;
class ThreeInARow {
    private static char[] grid = {'|', '1', '2', '3', '|',
                                 'A', '-', '-', '-', '|',
                                 'B', '-', '-', '-', '|',
                                 'C', '-', '-', '-', '|'};
    private static char[] inputArray = {' ',' '};
    private static String inputPos;
    private static byte player = 0;
 //   private static boolean valid = false;
    private static boolean gameOver = false;

    private static int pos = 0;

    public static void main(String[] args) {
        printArray();
        while (!gameOver) {

            inputPos = input();

            inputArray = inputPos.toCharArray();

            calcPos();
          boolean valid = validator();
            if(valid) {
                placeTile();
                checkWinner();
                if (player == 0) player = 1;
                else if (player == 1) player = 0;
                System.out.print("\n\n\n\n\n\n\n\n");
                printArray();


            }
            if (!(new String(grid).contains("-"))) {
                gameOver = true;
                System.out.print("The game was a Draw!");
            }
            // System.out.print(inputPos); //debugging for the return of the input
        }
    }

    private static void printArray() {

        int out = 0;
        for (int i = 0; i < 20; i++) {
            if(grid[i] == '-' || grid[i] == 'X' || grid[i] == 'O') {
                out++;
                System.out.print("[" + grid[i] + "]");
            }else if(grid[i] == '1' || grid[i] == '2' || grid[i] == '3') {
                System.out.print(" " + grid[i] + " ");
            }else{
                System.out.print(grid[i]);
            }

            if (i == 4 || i == 9 || i == 14 || i == 19) {
                System.out.print("\n");


            }




        }
       // System.out.print(out); // debugging for number of possible placements until draw.
        if(out == 0) gameOver = true;
    }

    private static String input() {
        String[] pos = {"player 1 write input", "player 2 write input"};
        System.out.print(pos[player] + "\n");


        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.reset();

        return input;

    }
    private static boolean validator() {
        boolean valid;
        if(inputPos.length() == 2 && grid[pos] == '-') {
            valid = true;
        }
        else if(inputPos.length() == 1) {
            valid = false;
        }
        else valid = false;
        return valid;
    }
    private static void placeTile() {
        if (player == 0) {
            grid[pos] = 'O';
        }
        else {
            grid[pos] = 'X';
        }
       // System.out.print(pos); // for debugging
    }
    private static void calcPos() {

        if(inputArray[0] == 'a') {
            pos = 5 + Character.getNumericValue(inputArray[1]);

        }
        else if(inputArray[0] == 'b') {
            pos = 10 + Character.getNumericValue(inputArray[1]);
        }
        else if(inputArray[0] == 'c') {
            pos = 15 + Character.getNumericValue(inputArray[1]);
        }

    }

    private static void checkWinner() {
        char[] playerTile = {'O','X'};
        int[][] winCombinations = {{6,7,8},{11,12,13},{16,17,18},{6,12,18},{8,12,16},{6,11,16},{7,12,17},{8,13,18}};
        for(int i =0; i < 8;i++) {
            //System.out.println(" " + i); // for debugging the for loop
            if ((grid[winCombinations[i][0]] == playerTile[player])
                    && (grid[winCombinations[i][1]] == playerTile[player])
                    && (grid[winCombinations[i][2]] == playerTile[player])){
                gameOver = true;
                player++;
                System.out.println("the winner is player " + player + "!");
                break;
            }
        }
    }
}
