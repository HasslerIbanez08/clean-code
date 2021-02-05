import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import org.junit.jupiter.api.Test;


import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class RxJavaTest {
    String result = "";

    @Test
    public void createSimpleObservable() {
        Observable<String> observable = Observable.just("Hassler");
        observable.subscribe((String subscribe) -> result = subscribe);
        assertEquals(result, "Hassler");
    }

    @Test
    public void showMethodRxJavaTest() {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
        Observable<String> observable = Observable.fromArray(letters);
        observable.subscribe(
                (i) -> result += i,
                Throwable::printStackTrace,
                () -> result += "_Complete"
        );
        assertEquals(result, "abcdefghi_Complete");
    }

    @Test
    public void mapOperatorTest() {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
        Observable.fromArray(letters)
                .map(String::toUpperCase)
                .subscribe((letter) -> result += letter);
        assertEquals(result, "ABCDEFGHI");
    }

    @Test
    public void scanOperatorTest() {
        String[] letters = {"a", "b", "c"};
        Observable.fromArray(letters)
                .scan(
                        new StringBuilder(),
                        StringBuilder::append)
                .subscribe((total) -> result += total.toString());
        assertEquals(result, "aababc");
    }

    @Test
    public void groupByOperator() {
        Integer[] number = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] odd = {""};
        String[] even = {""};
        Observable.fromArray(number)
                .groupBy((i) -> i % 2 == 0 ? "even" : "odd")
                .subscribe((group) ->
                        group.subscribe((numbers) -> {
                            if (group.getKey().equals("even")) {
                                even[0] += numbers;
                            } else {
                                odd[0] += numbers;
                            }
                        }));
        assertEquals(even[0], "0246810");
        assertEquals(odd[0], "13579");
    }

    @Test
    public void showObservableCold() {
        Observable<String> observable = Observable.just("a", "b", "c", "d");
        observable.subscribe((observe) -> System.out.println("Observe one: " + observe));
        observable.subscribe((observe) -> System.out.println("Observe two: " + observe));
    }

    @Test
    public void showObservableHot() {
        ConnectableObservable<String> observable = Observable.just("a", "b", "c", "d").publish();
        observable.subscribe((observe) -> System.out.println("Observe one: " + observe));
        observable.subscribe((observe) -> System.out.println("Observe two: " + observe));
        observable.connect();

    }

    @Test
    public void showObservableHotTest() throws InterruptedException {
        String[] result = {""};
        ConnectableObservable<Long> connectableObservable = ConnectableObservable.interval(200, TimeUnit.MILLISECONDS).publish();
        connectableObservable.subscribe((i) -> result[0] += i);

        assertNotEquals(result[0], "01");
        connectableObservable.connect();
        Thread.sleep(500);
        assertEquals(result[0], "01");
    }

    @Test
    public void intervaleTest() throws InterruptedException {
        ConnectableObservable<Long> connectableObservable = Observable.interval(1, TimeUnit.SECONDS).publish();
        connectableObservable.subscribe((i) -> System.out.println("Second observable one " + i));
        connectableObservable.connect();
        Thread.sleep(5000);
        connectableObservable.subscribe((i) -> System.out.println("Second observable second " + i));
        Thread.sleep(5000);

    }
    @Test
    public void intervalExerciseChat() throws InterruptedException {
        ConnectableObservable<Long> connectableObservable = Observable.interval(1,TimeUnit.SECONDS).publish();
        System.out.println("---------------------Chat--------------------");
        connectableObservable.subscribe((i)-> {System.out.println(i==0?"User 1 :Me tienes el dinero? ":(i==1||i==2||i==3)?"User 1 : Contesta":"User 1 : oh voy personalmente a tu casa?");});
        connectableObservable.connect();
        Thread.sleep(4000);
        connectableObservable.subscribe((i) -> System.out.println(i==0?"User 2 : no voy a pagar nada y haz lo que quieras ":"si quieres aca te espero"));
        Thread.sleep(1000);

    }
}
