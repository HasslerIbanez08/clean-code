package observer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subject {
    List<Observer> observers;
    private String state;

    public Subject(String state) {
        this.observers = new LinkedList<Observer>();
        setState(state);
        this.notifyObservers();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }
    public void registerObserver(Observer... observers){
        this.observers.addAll(Arrays.asList(observers));
    }
    public void  notifyObservers(){
        for (Observer observer:observers){
            observer.update();
        }
    }
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
}
