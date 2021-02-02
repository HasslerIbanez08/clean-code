import java.util.concurrent.*;

public class MainCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String name=null;
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
            if(name==null){
                throw new RuntimeException("Error.. ");
            }
            return "Hi "+name;
        }).exceptionally(
                ex->{
                    System.out.println("Errp");
                    return "Failerd";
                }
        );
                //.handle((success,error)-> success!=null?success:"There is an error");

        System.out.println(completableFuture.get());
    }

//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->3*3);
//        CompletableFuture<Integer> future = completableFuture.thenApplyAsync((nine)-> nine / 3);
//        System.out.println(future.get());
//        executorService.shutdown();
//    }
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<String> completableFutures = new CompletableFuture<>();
//        CompletableFuture<CompletableFuture<String>> completableText = completableFutures.thenApply(MainCompletableFuture::firstName);
//
//        CompletableFuture<String> completableFutureString = completableFutures.thenCompose(MainCompletableFuture::firstName);
//        System.out.println(completableFutureString.get());
//
//
//        CompletableFuture<String> completableFuture =
//                CompletableFuture.supplyAsync(() -> "Hola");
//        CompletableFuture<String> greetingFuture = completableFuture.thenCompose(MainCompletableFuture::firstName)
//                .thenCompose(MainCompletableFuture::lastName);
//        System.out.println(greetingFuture.get());
//    }

    public static CompletableFuture<String> firstName(String word) {
        return CompletableFuture.supplyAsync(() -> word.concat(" Hassler"));
    }

    public static CompletableFuture<String> lastName(String word) {
        return CompletableFuture.supplyAsync(() -> word.concat(" Ibañez"));
    }

//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        //completableFuture1();
//        SquareFutureExample squareFutureExample = new SquareFutureExample();
//        //Future<Integer> completableFuture = CompletableFuture.supplyAsync(()->3*3);
////        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->System.out.println(10));
////        System.out.println("El result is : "+completableFuture.get());
//        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->3*3);
//        CompletableFuture<Integer> future = completableFuture.thenApply((nine)->{
//            return nine/3;
//        });
//        CompletableFuture<String> futureGreat = CompletableFuture.supplyAsync(()->"Hi")
//                .thenApply((mensaje)-> mensaje + " Hassler ");
//        System.out.println("Este es el result: "+future.get());
//        System.out.println("Este es el result: "+futureGreat.get());
//        CompletableFuture<Void> voidAccept = completableFuture.thenAccept((nine)-> System.out.println("El numero accept es "+ nine));
//        //
//
//        //Interface de tipo consumer
//    }

    private static void completableFuture1() throws InterruptedException, ExecutionException {
        SquareFutureExample squareFutureExample = new SquareFutureExample();
        //Future<Integer> completableFuture = squareFutureExample.calculate(4);
        Future<Integer> completableFuture = CompletableFuture.completedFuture(4 * 4);
        System.out.println("El result is : " + completableFuture.get());
    }
}
