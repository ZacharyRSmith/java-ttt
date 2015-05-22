import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game
{
    public String crnt_plyr = "X";
    private ArrayList<List<Integer>> lines = this.setLines();
    public ArrayList<Square> grid = this.build_grid();
    public boolean victory = false;

    public Game()
    {
        this.display_instruct();
    }

    private static ArrayList<Square> build_grid()
    {
        ArrayList<Square> grid = new ArrayList<Square>();

        for (int i=0; i<9; i++)
        {
            grid.add(new Square());
        }

        return grid;
    }

    private void setVictory()
    {
        for (List<Integer> line : this.lines)
        {
            System.out.println("Hello!");
            if (this.grid.get(line.get(0)).mark == this.crnt_plyr &&
                this.grid.get(line.get(1)).mark == this.crnt_plyr &&
                this.grid.get(line.get(2)).mark == this.crnt_plyr)
            {
                this.victory = true;
            }
        }
    }

    private static void display_instruct()
    {
        System.out.println(
            "Welcome to Tic-Tac-Toe.\n" +
            "You will make your move known by entering a number, 1-9.\n" +
            "number will correspond to the board position as shown below:\n" +
            "            7   |   8   |   9\n" +
            "            -----------------\n" +
            "            4   |   5   |   6\n" +
            "            -----------------\n" +
            "            1   |   2   |   3\n" +
            "Prepare yourself. Muahahaaa!! >:}} \n"
        );
    }

    public void engine()
    {
        // The board will be filled after 9 turns. If there is no victory,
        // then it is a draw.
        int turn_counter = 0;
        while (turn_counter < 9)
        {
            this.turn();

            if (this.victory)
            {
                System.out.println("Player '" + this.crnt_plyr + "', you lose! :P");
                break;
            }
            turn_counter++;
        }

        this.renderGrid();
        System.out.println("Game over.");
    }

    private Square getSquare(int squareI)
    {
        return this.grid.get(squareI - 1);
    }

    private void markSquare(Square square)
    {
        square.mark = this.crnt_plyr;
    }

    private Square promptSquare()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please select your square...");
        int squareI = keyboard.nextInt();

        if (!(1 <= squareI) || !(squareI <= 9))
        {
            System.out.println("I cannot find a square matching that input.");
            return this.promptSquare();
        }

        Square square = this.getSquare(squareI);

        if (square.mark != " ")
        {
            System.out.println("That square is already marked!");
            return this.promptSquare();
        }

        return square;
    }

    private void renderGrid()
    {
        String m1 = this.grid.get(0).mark;
        String m2 = this.grid.get(1).mark;
        String m3 = this.grid.get(2).mark;
        String m4 = this.grid.get(3).mark;
        String m5 = this.grid.get(4).mark;
        String m6 = this.grid.get(5).mark;
        String m7 = this.grid.get(6).mark;
        String m8 = this.grid.get(7).mark;
        String m9 = this.grid.get(8).mark;
        String tabLines = "_______";
        String div = tabLines + "|" + tabLines;

        System.out.println(
            "\t\t" + m7 + "\t|\t" + m8 + "\t|\t" + m9 + "\n" +
            "\t\t" + "_"+   div   + "_"+   div   + "_"+ "\n" +
            "\t\t" + m4 + "\t|\t" + m5 + "\t|\t" + m6 + "\n" +
            "\t\t" + "_"+   div   + "_"+   div   + "_"+ "\n" +
            "\t\t" + m1 + "\t|\t" + m2 + "\t|\t" + m3 + "\n"
        );
    }

    private ArrayList<List<Integer>> setLines()
    {
        ArrayList<List<Integer>> lines = new ArrayList<List<Integer>>();
        lines.add(Arrays.asList(0, 1, 2));
        lines.add(Arrays.asList(3, 4, 5));
        lines.add(Arrays.asList(6, 7, 8));
        lines.add(Arrays.asList(0, 3, 6));
        lines.add(Arrays.asList(1, 4, 7));
        lines.add(Arrays.asList(2, 5, 8));
        lines.add(Arrays.asList(0, 4, 8));
        lines.add(Arrays.asList(2, 4, 6));

        return lines;
    }

    private void switchPlayer()
    {
        if (this.crnt_plyr == "X")
        {
            this.crnt_plyr = "O";
        }
        else
        {
            this.crnt_plyr = "X";
        }
    }

    private void turn()
    {
        this.renderGrid();
        System.out.println("Player '" + this.crnt_plyr + "', your turn!");

        Square square = this.promptSquare();
        this.markSquare(square);
        this.setVictory();
        this.switchPlayer();
    }
}
