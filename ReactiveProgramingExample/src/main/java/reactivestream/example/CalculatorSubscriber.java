package reactivestream.example;

import observer.exercise.CalculatorNumber;
import reactivestream.Sleeper;

import java.util.concurrent.Flow;


public class CalculatorSubscriber implements Flow.Subscriber<Integer> {
    private Flow.Subscription subscription;


    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Integer item) {
        System.out.println("El resultado es "+item);
        subscription.request(1);
        //Sleeper.sleep(1000);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("---------La calculadora ha finalizado-----");
    }
}
