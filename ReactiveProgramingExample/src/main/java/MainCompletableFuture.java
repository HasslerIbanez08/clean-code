import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MainCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //completableFuture1();
        SquareFutureExample squareFutureExample = new SquareFutureExample();
        //Future<Integer> completableFuture = CompletableFuture.supplyAsync(()->3*3);
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->System.out.println(10));
//        System.out.println("El result is : "+completableFuture.get());
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->3*3);
        CompletableFuture<Integer> future = completableFuture.thenApply((nine)->{
            return nine/3;
        });
        CompletableFuture<String> futureGreat = CompletableFuture.supplyAsync(()->"Hi")
                .thenApply((mensaje)-> mensaje + " Hassler ");
        System.out.println("Este es el result: "+future.get());
        System.out.println("Este es el result: "+futureGreat.get());
        CompletableFuture<Void> voidAccept = completableFuture.thenAccept((nine)-> System.out.println("El numero accept es "+ nine));
        //

        //Interface de tipo consumer
    }

    private static void completableFuture1() throws InterruptedException, ExecutionException {
        SquareFutureExample squareFutureExample = new SquareFutureExample();
        //Future<Integer> completableFuture = squareFutureExample.calculate(4);
        Future<Integer> completableFuture = CompletableFuture.completedFuture(4*4);
        System.out.println("El result is : "+completableFuture.get());
    }
}
