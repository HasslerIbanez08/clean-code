package iterator;

import observer.exercise.CalculatorNumber;

public class MainExercise {
    public static void main(String[] args) {
        ExerciseIterator exerciseIterator = new ExerciseIterator(10,new CalculatorNumber(1,3));
        for (int result: exerciseIterator) {
            System.out.println("El resultado es : "+result);
        }
    }
}
