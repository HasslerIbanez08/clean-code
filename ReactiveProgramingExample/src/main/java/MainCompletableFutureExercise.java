import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MainCompletableFutureExercise {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Calculator calculator = new Calculator();
        System.out.println("------ Inicio calculadora -----");
        CompletableFuture<Integer> completableSum = CompletableFuture.completedFuture(calculator.add(20,15));
        System.out.println("El resultado de la suma: "+completableSum.get());
        CompletableFuture<Integer> completableSubtraction= completableSum.thenApplyAsync((resultado)-> calculator.subtraction(resultado,10));
        System.out.println("la resta del resultado de la suma es : "+completableSubtraction.get());
        CompletableFuture<Integer> completableMultiply= completableSubtraction.thenApplyAsync((resultado)-> calculator.multiply(resultado,resultado));
        System.out.println("la multiplicacion del resultado de la resta es : "+completableMultiply.get());
        CompletableFuture<Integer> completableDivide= completableSubtraction.thenApplyAsync((resultado)-> calculator.divide(resultado,resultado));
        System.out.println("la divicion del resultado de la multiplicacion es : "+completableMultiply.get());
        CompletableFuture<String> futureCopyright = CompletableFuture.supplyAsync(()->"----- Copyright-----")
                .thenApply((mensaje)-> mensaje + " Hassler ")
                .thenApply((mensaje)-> mensaje + "ibañez");
        System.out.println(futureCopyright.get());
    }
}
