package observer.exercise;


import observer.exercise.SubjectCalculator;

public abstract class ObserverCalculator {
    public abstract void update();
    protected SubjectCalculator subject;
}
