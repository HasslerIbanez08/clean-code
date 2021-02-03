package observer;

public class MainObserver {
    public static void main(String[] args) {
        Subject subject = new Subject("Cristiano Ronaldo");
        new LengthObserver(subject);
        new CaseObserver(subject);
        new WordObserver(subject);
        subject.notifyObservers();

        System.out.println("--------------------------------------");
        subject.setState("Leonel messi la pulga");
        System.out.println("--------------------------------------");
        subject.setState("Falcao el tigre");


    }
}
