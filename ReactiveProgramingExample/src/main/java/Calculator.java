public class Calculator
{
    private int solution;

    public Calculator()
    {
        solution = 0;
    }

    public int add(int x, int y)
    {
        return x + y;
    }
    public int subtraction(int x, int y)
    {
        return x - y;
    }
    public int multiply(int x, int y)
    {
        return x * y;
    }
    public int divide(int x, int y)
    {
        solution = x / y;
        return solution;
    }
}

