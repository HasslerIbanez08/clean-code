package reactorproject.reactive;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ReactorProjectTest {

    @Test
    public void simpleStreamProjectReactorTest(){
        List<Integer> elements = new ArrayList<>();
        Flux.just(1,2,3,6,4,5)
            .log()
            .subscribe(elements::add);
        assertThat(elements).containsExactly(1,2,3,6,4,5);
    }

    @Test
    public void simpleStreamProjectReactorTestMono(){
        List<Integer> elements = new ArrayList<>();
        Mono.just(1)
                .log()
                .subscribe(elements::add);
        assertThat(elements).containsExactly(1);
    }

    @Test
    public void showInternalFunctionTest(){
        List<Integer> elements = new ArrayList<>();
        Flux.just(1,2,3,6,4,5)
                .log()
        .subscribe(new Subscriber<Integer>() {
            private Subscription s;
            private int onNextAmount;
            @Override
            public void onSubscribe(Subscription s) {
                this.s = s;
                s.request(2);
            }

            @Override
            public void onNext(Integer integer) {
                elements.add(integer);
                onNextAmount++;
                if(onNextAmount % 2 ==0){
                    s.request(2);
                }
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onComplete() {

            }
        });
        assertThat(elements).containsExactly(1,2,3,6,4,5);
    }

    @Test
    public void mapTest(){
        List<Integer> elements = new ArrayList<>();
        Flux.just(1,2,3,6,4,5)
                .map((i)-> i *3)
                .log()
                .subscribe(elements::add);
        assertThat(elements).containsExactly(3, 6, 9, 18, 12, 15);
    }

    @Test
    public void parallelTest(){
        List<Integer> elements = new ArrayList<>();
        Flux.just(1,2,3,6,4,5)
                .map((i)-> i *3)
                .subscribeOn(Schedulers.parallel())
                .log()
                .subscribe(elements::add);
        assertThat(elements).containsExactly(3, 6, 9, 18, 12, 15);
    }

    @Test
    public void fluxHotTest(){
        ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
            while (true){
                fluxSink.next(System.currentTimeMillis());
            }
        }).publish();
        publish.subscribe(System.out::println);
        publish.subscribe(System.out::println);
        publish.log();
    }

}
