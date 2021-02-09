package reactivestream.example;

import observer.exercise.CalculatorNumber;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class CalculatorProcessor extends SubmissionPublisher<Integer> implements Flow.Processor<CalculatorNumber,Integer> {
    private Flow.Subscription subscription;



    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(CalculatorNumber item) {
        submit(new Calculator().add(item.getNumber1(),item.getNumber2()));
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Calculadora procesando..");
        close();
    }
}
