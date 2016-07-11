/**
 * Created by alexs on 7/10/2016.
 */
class Player
{

    private char sign;
    private String name;
    private int checks;

    char getSign()
    {
        return sign;
    }

    void setSign(char sign)
    {
        this.sign = sign;
    }

    String getName()
    {
        return name;
    }

    void setName(String name)
    {
        this.name = name;
        setSign(name.charAt(0));
    }

    int getChecks()
    {
        return checks;
    }

    void setChecks(int checks)
    {
        this.checks = checks;
    }
}
