package observer.exercise;

import observer.Observer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubjectCalculator {
    List<ObserverCalculator> observers;
    private CalculatorNumber state;

    public SubjectCalculator(CalculatorNumber state) {
        this.observers = new LinkedList<ObserverCalculator>();
        this.setState(state);
        this.notifyObservers();
    }

    public CalculatorNumber getState() {
        return state;
    }

    public void setState(CalculatorNumber state) {
        this.state = state;
        notifyObservers();
    }
    public void registerObserver(CalculatorObserve observers){
        this.observers.addAll(Arrays.asList(observers));
    }
    public void  notifyObservers(){
        for (ObserverCalculator observer:observers){
            observer.update();
        }
    }
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
}
