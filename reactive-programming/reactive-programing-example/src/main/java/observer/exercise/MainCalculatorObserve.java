package observer.exercise;

public class MainCalculatorObserve {
    public static void main(String[] args) {

        SubjectCalculator subjectCalculator = new SubjectCalculator(new CalculatorNumber(4,2));
        new  CalculatorObserve(subjectCalculator);
        subjectCalculator.notifyObservers();
        System.out.println("------------------------------------------------");
        subjectCalculator.setState(new CalculatorNumber(5,8));
        System.out.println("------------------------------------------------");
        subjectCalculator.setState(new CalculatorNumber(5,18));
    }
}
