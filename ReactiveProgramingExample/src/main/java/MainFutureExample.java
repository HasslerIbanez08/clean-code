import java.util.concurrent.*;

public class MainFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future(executorService);
        //squareCallableExample(executorService);
    }

    private static void squareCallableExample(ExecutorService executorService) throws InterruptedException, ExecutionException, TimeoutException {
        Future<Integer> future = executorService.submit(new SquareCallableExample(15));
        while (!future.isDone()){
            System.out.println("Calculating");
        }
        Integer result = future.get(100, TimeUnit.MILLISECONDS);
        System.out.println("the Result is: "+result);
        executorService.shutdown();
    }

    private static void Future(ExecutorService executorService) throws InterruptedException, ExecutionException, TimeoutException {
//        Future<Integer> future = new SquareFutureExample(executorService).calculate(4);
//        Future<Integer> future1 = new SquareFutureExample(executorService).calculate(14);
//        while (!future.isDone() && !future1.isDone()){
//            System.out.println("Calculating");
//            Thread.sleep(300);
//        }
//        Integer result = future.get(100, TimeUnit.MILLISECONDS);
//        System.out.println("the Result is: "+result);
//        Integer result1 = future1.get(100, TimeUnit.MILLISECONDS);
//        System.out.println("the Result1 is: "+result1);
//        executorService.shutdown();
    }
}
