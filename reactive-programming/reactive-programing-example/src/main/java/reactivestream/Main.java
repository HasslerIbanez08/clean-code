package reactivestream;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // Es un productor o fuente de flujo de datos
        SubmissionPublisher<Integer> submissionPublisher = new SubmissionPublisher<>();
        //Transformacion o intemediario que hace una transformacion de los datos
        Flow.Processor<Integer,Integer> powProcessor = new PowProcessor();
        // Consumidor de la fuente
        Flow.Subscriber<Integer> printSubscriber = new PrintSubscriber();
        // Se suscribe a la fuente de flujo de datos
        submissionPublisher.subscribe(powProcessor);
        //powProceso luego de procesar los datos, se convierte tambien en una fuente de fluj de datps
        //para poder proporcionar el consumidor
        powProcessor.subscribe(printSubscriber);
        IntStream.range(0,20).parallel().forEach((i)->{
            //enviar la informacion, se le pasa al procesador
            submissionPublisher.submit(i);
            Sleeper.sleep(2000);
        });
        submissionPublisher.close();
    }
}
