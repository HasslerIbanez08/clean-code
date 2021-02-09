package observer;

import observer.Observer;
import observer.Subject;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CaseObserver extends Observer {
    public CaseObserver(Subject subject){
        this.subject = subject;
        this.subject.registerObserver(this);
    }
    @Override
    public void update() {
        System.out.println("LowerCase: "+countLowerCase());
        System.out.println("UpperCase: "+countUpperCase());
    }
    private int countLowerCase(){
        String state = subject.getState();
        long count=Stream.iterate(0,integer -> integer+1)
                .limit(state.length())
                .map(state::charAt)
                .filter(Character::isLowerCase)
                .count();
        return Integer.parseInt(count+"");
    }
    private int countUpperCase(){
        String state = subject.getState();
        long count=Stream.iterate(0,integer -> integer+1)
                .limit(state.length())
                .map(state::charAt)
                .filter(Character::isUpperCase)
                .count();
        return Integer.parseInt(count+"");
    }
}
