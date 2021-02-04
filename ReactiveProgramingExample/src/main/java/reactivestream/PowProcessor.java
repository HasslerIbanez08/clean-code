package reactivestream;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class PowProcessor extends SubmissionPublisher<Integer> implements Flow.Processor<Integer,Integer> {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription=subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Integer item) {
        submit(item * item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Pow processor complete");
        close();
    }
}
