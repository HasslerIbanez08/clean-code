import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareFutureExample {

    public Future<Integer> calculate(int input){
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        Executors.newFixedThreadPool(2)
        .submit(()->{
            try {
                Thread.sleep(1000);
                completableFuture.complete(input * input);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });
       return completableFuture;
    }
}
