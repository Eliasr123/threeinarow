import java.util.Scanner;

class main {
    public static char[] grid = {'|', '1', '2', '3', '|',
            'A', '-', '-', '-', '|',
            'B', '-', '-', '-', '|',
            'C', '-', '-', '-', '|'};
    public static byte player = 0;

    public static void main(String[] args) {
        boolean gameover = false;
        for(int i = 0; i<10; i++) {
            String inputPos = Input();

            printArray();
           // System.out.print(inputPos); //debbugging for the return of the input
        }
    }

    public static void printArray() {


        for (int i = 0; i < 20; i++) {
            System.out.print(grid[i]);
            if (i == 4 || i == 9 || i == 14|| i == 19) {
                System.out.print("\n");


            }
        }
    }

    public static String Input() {
            String[] pos = {"player 1 write input", "player 2 write input" };
            System.out.print(pos[player]+ "\n");


        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.reset();
        if (player == 0) player = 1;
        else if (player == 1) player = 0;
        return input;

    }
    public static char[] Stringsplitter() {
        
    }
}
