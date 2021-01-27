import java.util.concurrent.*;

public class MathematicsMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MathematicsOperations mathematicsOperations = new MathematicsOperations();
        int numero =10;
        //Thread
//        Thread thread = new Thread(()->{
//            System.out.println("El factorial del numero ".concat("25 es: ").concat(mathematicsOperations.factorial(25)+""));
//        });
//        thread.start();
        //Future Task
//        ExecutorService threatPool = Executors.newCachedThreadPool();
//        Future<Long>  futuretask = threatPool.submit(()->mathematicsOperations.factorial(10));
//        while (!futuretask.isDone()){
//            System.out.println("Futuretask is not finished");
//        }
//        Long result = futuretask.get();
//        System.out.println("El resultado ".concat(result+""));
//        threatPool.shutdown();
         // CompetableFuture
          CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync(()->mathematicsOperations.factorial(numero));
          while (!completableFuture.isDone()){
              System.out.println("CompletableFuture is not finished");
          }
          Long result = completableFuture.get();
          System.out.println("El resultado es : "+result);
    }
}
