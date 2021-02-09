package reactivestream.example;

import observer.exercise.CalculatorNumber;
import reactivestream.PowProcessor;
import reactivestream.PrintSubscriber;
import reactivestream.Sleeper;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.IntStream;

public class MainExercise {
    public static void main(String[] args) {
        SubmissionPublisher<CalculatorNumber> submissionPublisher = new SubmissionPublisher<>();
        //Transformacion o intemediario que hace una transformacion de los datos
        Flow.Processor<CalculatorNumber,Integer> powProcessor = new CalculatorProcessor();
        // Consumidor de la fuente
        Flow.Subscriber<Integer> printSubscriber = new CalculatorSubscriber();
        // Se suscribe a la fuente de flujo de datos
        submissionPublisher.subscribe(powProcessor);
        //powProceso luego de procesar los datos, se convierte tambien en una fuente de fluj de datps
        //para poder proporcionar el consumidor
        powProcessor.subscribe(printSubscriber);
        submissionPublisher.submit(new CalculatorNumber(1,8));
        Sleeper.sleep(2000);

        submissionPublisher.close();
    }
}
