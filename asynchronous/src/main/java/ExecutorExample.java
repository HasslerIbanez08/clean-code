
import  java.util.concurrent.Executor;

public class ExecutorExample {
    public static void main(String[] args) {
        Executor executor = new Invoker();
        executor.execute(new ExecutorRunnable());
        executor.execute(new ExecutorRunnable());
        executor.execute(new ExecutorRunnable());
    }
}

