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

    public void engine()
    {
        // The board will be filled after 9 turns. If there is no victory,
        // then it is a draw.
        for (int turn_counter=0; turn_counter<9; turn_counter++)
        {
            this.turn();

            if (this.victory)
            {
                System.out.println("Player '" + this.crnt_plyr + "', you lose! :P");
                break;
            }
        }

//         this.renderGrid();
        System.out.println("Game over.");
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

    private void turn()
    {
        this.renderGrid();
        System.out.println("Player '" + this.crnt_plyr + "', your turn!");

//         Square square = this.prompt_square();
//         this.mark_square(square);
//         this.check_victory(square);
//         this.switch_player();
    }
}
