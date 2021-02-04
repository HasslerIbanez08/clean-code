package iterator;

import observer.exercise.CalculatorNumber;
import reactivestream.example.Calculator;

import java.util.Iterator;
import java.util.function.Consumer;

public class ExerciseIterator implements Iterable<Integer>{

    private int position;
    private int size;
    private CalculatorNumber calculatorNumber;

    public ExerciseIterator(int size, CalculatorNumber calculatorNumber) {
        this.size = size;
        this.calculatorNumber = calculatorNumber;
    }

    @Override
    public Iterator<Integer> iterator() {
        int size = this.size;
        Iterator<Integer> iterator = new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return (position<size);
            }

            @Override
            public Integer next() {
                position++;
                Calculator calculator = new Calculator();
                return calculator.add(calculatorNumber.getNumber1(),calculatorNumber.getNumber2());
            }
        };
        return iterator;
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {

    }
}
