import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;


public class ExecutorServiceExample {
    public static void main(String[] args) {
        System.out.println("The thread started");
        //fixedThread();
        //singleThread();
        //cacheThreadPool();
        autenticar("hassler","123456");
//        basicscheduleThreadPool();
//        fixedRateScheduleThreadPool();
//        fixeDelayScheduleThreadPool();
    }
    private static  void autenticar(String user,String password){
        Autentication autentication = new Autentication();

        ScheduledExecutorService executors = Executors.newScheduledThreadPool(10);
        IntStream.range(0,10).forEach(
                i -> executors.scheduleAtFixedRate(()->autentication.isAutenticate(password,user),20,10, TimeUnit.SECONDS)
        );
//        executors.shutdown();
    }
    //Grupo de subprocesos programados.
    private static void basicscheduleThreadPool(){
        ScheduledExecutorService executors = Executors.newScheduledThreadPool(10);
        IntStream.range(0,10).forEach(
                i -> executors.schedule(ExecutorServiceExample::showNameThread,20, TimeUnit.SECONDS)
        );
        System.out.println("The thread finished");
//        executors.shutdown();
    }
    private static void fixedRateScheduleThreadPool(){
        ScheduledExecutorService executors = Executors.newScheduledThreadPool(10);
        IntStream.range(0,10).forEach(
                i -> executors.scheduleAtFixedRate(ExecutorServiceExample::showNameThread,20,10, TimeUnit.SECONDS)
        );
//        executors.shutdown();
    }
    private static void fixeDelayScheduleThreadPool(){
        ScheduledExecutorService executors = Executors.newScheduledThreadPool(10);
        IntStream.range(0,10).forEach(
                i -> executors.scheduleWithFixedDelay(ExecutorServiceExample::showNameThread,20,10, TimeUnit.SECONDS)
        );
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
