/**
 * Created by alexs on 7/10/2016.
 */
class Grid
{

    private char[][] grid = new char[3][3];

    void fillGrid()
    {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                grid[i][j] = (char) ('1' + i * 3 + j);
    }

    void printGrid()
    {
        for (int i = 0; i < 3; i++)
        {
            if (i == 0)
                for (int p = 0; p < 3; p++)
                {
                    if (p == 0)
                        System.out.print("\u250c");
                    System.out.print("---");
                    if (p == 2)
                        System.out.println("\u2510");
                    else
                        System.out.print("\u252c");
                }
            if (0 < i && i < 3)
                for (int p = 0; p < 3; p++)
                {
                    if (p == 0)
                        System.out.print("\u251c");
                    System.out.print("---");
                    if (p == 2)
                        System.out.println("\u2524");
                    else
                        System.out.print("\u253c");
                }
            for (int p = 0; p < 3; p++)
            {
                System.out.print("\u2502 " + grid[i][p] + " ");
                if (p == 3 - 1)
                    System.out.println("\u2502");
            }
            if (i == 2)
            {
                for (int p = 0; p < 3; p++)
                {
                    if (p == 0)
                        System.out.print("\u2514");
                    System.out.print("---");
                    if (p == 2)
                        System.out.println("\u2518");
                    else
                        System.out.print("\u2534");
                }
            }
        }
    }

    boolean checkBox(char n, char c)
    {
        if (n <= '9')
        {
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (grid[i][j] == n)
                    {
                        grid[i][j] = c;
                        return true;
                    }
            return false;
        }
        return false;
    }

    boolean checkWinner(Player p)
    {
        int k = 0;
        while (p.getChecks() >= 3 && k < 3)
        {
            int cont[] = {0, 0, 0, 0};
            for (int i = 0; i < 3 && k < 3; i++)
            {
                if (grid[i][k] == p.getSign()) //columns
                {
                    ++cont[0];
                    if (cont[0] == 3)
                        return true;
                }
                if (grid[k][i] == p.getSign()) //rows
                {
                    ++cont[1];
                    if (cont[1] == 3)
                        return true;
                }
                if (grid[i][i] == p.getSign()) //diagonal
                {
                    ++cont[2];
                    if (cont[2] == 3)
                        return true;
                }
                if (grid[i][2 - i] == p.getSign()) //inverse diagonal
                {
                    ++cont[3];
                    if (cont[3] == 3)
                        return true;
                }
            }
            k++;
        }
        return false;
    }
}
