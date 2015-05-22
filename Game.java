import java.util.ArrayList;

public class Game
{
    public String crnt_plyr = "X";
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
}
