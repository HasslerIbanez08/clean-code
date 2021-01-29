import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;


public class ExecutorServiceExample {
    public static void main(String[] args) {
        System.out.println("The thread started");
        //fixedThread();
        //singleThread();
        //cacheThreadPool();
        autenticar("hassler","123456");
    }
    private static  void autenticar(String user,String password){
        ExecutorService executors = Executors.newCachedThreadPool();
        Autentication autentication = new Autentication();

        executors.execute(()->autentication.isAutenticate(password,user));
        executors.shutdown();
    }
    //CacheThreadPoolExecutor Ejecutor de grupo de subprocesos en cache
    private static void cacheThreadPool(){
        ExecutorService executors = Executors.newCachedThreadPool();
        IntStream.range(0,10).forEach(
                i ->{
                    executors.execute(ExecutorServiceExample::showNameThread);
                }
        );
        System.out.println("The thread finished");
        executors.shutdown();
    }
    //Ejecutador SingleThreadPoolExecutor
    private static void singleThread(){
        ExecutorService executors = Executors.newSingleThreadExecutor();
        IntStream.range(0,10).forEach(
                i ->{
                    executors.execute(ExecutorServiceExample::showNameThread);
                }
        );
        System.out.println("The thread finished");
        executors.shutdown();
    }

    //Ejecutador de grupo de subprocesos fijos.
      private static void fixedThread() {
        ExecutorService executors = Executors.newFixedThreadPool(3);
        IntStream.range(0,10).forEach(
                i ->{
                  executors.execute(ExecutorServiceExample::showNameThread);
                }
        );
        System.out.println("The thread finished");
        executors.shutdown();
    }

    public static  void showNameThread(){
        System.out.println("Nombre del hilo : "+Thread.currentThread().getName());
    }
}
