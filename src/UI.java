import java.util.Scanner;

/**
 * Created by alexs on 7/10/2016.
 */
class UI extends Grid
{

    private Player[] p = new Player[2];
    private Scanner in = new Scanner(System.in);

    private static void cls()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    void game()
    {
        cls();
        p[0] = new Player();
        p[1] = new Player();
        System.out.print("Bienvenido al juego\nDigite el nombre del primer jugador: ");
        p[0].setName(getString());
        while (Character.isDigit(p[0].getSign()))
        {
            System.out.println("Ingrese un nombre valido, sin números o caracteres especiales");
            p[0].setName(getString());
        }
        cls();
        System.out.print("Ahora que el segundo jugador digite su nombre: ");
        p[1].setName(getString());
        while (Character.isDigit(p[1].getSign()))
        {
            System.out.println("Ingrese un nombre valido, sin números o caracteres especiales");
            p[1].setName(getString());
        }
        if (p[0].getSign() == p[1].getSign())
        {
            System.out.println("Ambos nombres empiezan igual, " + p[1].getName() + " usaras: \u2588 como tu marca.");
            p[1].setSign('\u2588');
            in.nextLine();
        }
        cls();
        fillGrid();
        for (int i = 0, t = 0; i < 9; i++)
        {
            printGrid();
            System.out.println(p[t].getName() + " digite el numero de la casilla donde quiere marcar: ");
            while (!checkBox(getString().charAt(0), p[t].getSign())) //if the box wasn't checked
                System.out.println("Intenta otra vez.");
            p[t].setChecks(p[t].getChecks() + 1); //keep track of times that player checked
            if (checkWinner(p[t]))
            {
                cls();
                System.out.println("Felicidades has ganado " + p[t].getName() + "!.");
                in.nextLine();
                break;
            }
            if (i == 8)
            {
                cls();
                System.out.println("Felicidades es un empate!");
                in.nextLine();
            }
            if (t == 1) //decide player
                t = 0;
            else
                t = 1;
            cls();
        }
        System.out.println("Gracias por jugar ;)");
        in.nextLine();
        System.out.println("Desearia jugar otra vez?\nSi o No: ");
        if (getString().toUpperCase().charAt(0) == 'S')
            game();
    }

    private String getString()
    {
        String line = in.nextLine();
        if (line.isEmpty())
            return getString();
        return line;
    }
}
