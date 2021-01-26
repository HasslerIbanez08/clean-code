import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {
    private final Person person1 = new Person("Hassler", "Ibañez");
    private final Calculator calculator = new Calculator();

    @Test
    public void standarAssertion() {
        assertEquals(5, calculator.add(3, 2));
        assertEquals(6, calculator.multiply(3, 2),
                "El mensaje de falla opcional es el ultimo parametro");
        assertTrue('a' < 'b', () -> "Este es un mensaje ".concat(" de prueba"));
    }

    @Test
    public void groupAssertions() {
        assertAll(
                "persona",
                () -> assertEquals("Hassler", person1.getFirstName()),
                () -> assertEquals("Ibañez", person1.getLastName())
        );
    }

    @Test
    public void dependentAssertions() {
        assertAll(
                () -> {
                    String firstName = person1.getFirstName();
                    assertNotNull(firstName);
                    assertAll(
                            "first name",
                            () -> assertTrue(firstName.startsWith("H")),
                            () -> assertTrue(firstName.endsWith("r"))
                    );
                }
        );
    }
    @Test
    public void exceptionTesting(){
        Exception exception = assertThrows(ArithmeticException.class,
                ()-> calculator.divide(2,0));
        assertEquals("/ by zero",exception.getMessage());
    }
    @Test
    public void exceptionTimeOut(){
        assertTimeout(
                Duration.ofMinutes(1l),
                ()->{}
        );
    }
    @Test
    public void exceptionTimeOutResult(){
        String currentResult = assertTimeout(
                Duration.ofMinutes(1l),
                ()->{
                    return "Esto es un resultado";
                }
        );
        assertEquals("Esto es un resultado",currentResult);
    }
    @Test
    public void exceptionTimeOutMethod(){
        String currentResult = assertTimeout(
                Duration.ofMinutes(1l),
                AssertionsTest::getName
        );
        assertEquals("Hassler",currentResult);
    }
    @Test
    public void exceptionTimeOutExceded(){
        assertTimeout(
                Duration.ofMillis(10l),
                ()->{
                    Thread.sleep(100);
                }
        );
    }
    private static String getName(){
        return "Hassler";
    }

}
