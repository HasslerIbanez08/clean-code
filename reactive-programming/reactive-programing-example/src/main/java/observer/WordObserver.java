package observer;

public class WordObserver extends Observer{
    public WordObserver(Subject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("CountWord :"+wordCount());
    }
    private int wordCount(){
        String state = this.subject.getState();
        return state.split(" ").length;
    }
}
