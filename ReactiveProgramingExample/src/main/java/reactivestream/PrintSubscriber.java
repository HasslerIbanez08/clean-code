package reactivestream;

import java.util.concurrent.Flow;

public class PrintSubscriber implements Flow.Subscriber<Integer>{

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Integer item) {
        System.out.println("received item: "+item);
        this.subscription.request(1);
        Sleeper.sleep(1000);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Print subscriber complete");
    }
}
