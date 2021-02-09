package observer.exercise;

public class CalculatorObserve extends ObserverCalculator {
    public CalculatorObserve(SubjectCalculator subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update() {
        CalculatorNumber calculatorNumberState = subject.getState();
        System.out.println("------- Calculator Observe--------"+" de los numeros1: "+calculatorNumberState.getNumber1()+" y numeros2: "+calculatorNumberState.getNumber2());
        System.out.println("La suma es: "+add(calculatorNumberState.getNumber1(),calculatorNumberState.getNumber2()));
        System.out.println("La resta es: "+subtraction(calculatorNumberState.getNumber1(),calculatorNumberState.getNumber2()));
        System.out.println("La multiplicacion es: "+multiply(calculatorNumberState.getNumber1(),calculatorNumberState.getNumber2()));
        System.out.println("La división es: "+divide(calculatorNumberState.getNumber1(),calculatorNumberState.getNumber2()));
    }

    private int add(int x, int y)
    {
        return x + y;
    }
    private int subtraction(int x, int y)
    {
        return x - y;
    }
    private int multiply(int x, int y)
    {
        return x * y;
    }
    private int divide(int x, int y)
    {
        return x/y;
    }
}
