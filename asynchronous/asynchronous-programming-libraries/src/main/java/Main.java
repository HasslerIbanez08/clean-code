import authenticatecase.Authenticate;
import authenticatecase.AuthenticateService;
import calculatorcase.Calculator;
import com.ea.async.Async;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static{
        Async.init();
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Guava
        String name ="hassler";
        String password ="123456";
        AuthenticateService authenticateService = new Authenticate();
        ExecutorService threadPool = Executors.newCachedThreadPool();
        ListeningExecutorService service = MoreExecutors.listeningDecorator(threadPool);
        ListenableFuture<Boolean> autenticar = service.submit(() -> authenticateService.isAuthenticate(name,password));
        Calculator calculator = new Calculator();
        while (!autenticar.isDone()){
            System.out.println("---------------------------------------------- Cargando.. --------------------------------------------------");
        }
        if(autenticar.get()){
            System.out.println("---------------------------------------------- Usuario autenticado: "+name+" "+password +" .. --------------");
            CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()-> calculator.add(4,2));
            int suma = Async.await(completableFuture);
            System.out.println("---------------------------------------------- Resultado de la suma es: "+suma+" ---------------------------");
            CompletableFuture<Integer> resta = CompletableFuture.supplyAsync(()-> calculator.subtraction(4,2));
            int restaR = Async.await(resta);
            System.out.println("---------------------------------------------- Resultado de la resta es: "+restaR+" ------------------------");
            CompletableFuture<Integer> mulplicar = CompletableFuture.supplyAsync(()-> calculator.subtraction(4,2));
            int multiplicarR = Async.await(mulplicar);
            System.out.println("---------------------------------------------- Resultado de la multiplicacion es: "+multiplicarR+" ---------");
            CompletableFuture<Integer> division = CompletableFuture.supplyAsync(()-> calculator.subtraction(4,2));
            int divisionR = Async.await(division);
            System.out.println("---------------------------------------------- Resultado de la division es: "+divisionR+" ------------------");

        }else{
            System.out.println("---------------------------------------------- Error usuario no existe .. ----------------------------------");
        }

    }
}
