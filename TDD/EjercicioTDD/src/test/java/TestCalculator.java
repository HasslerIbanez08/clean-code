import org.junit.jupiter.api.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCalculator {

    public static final String RAIZ = "RAIZ";
    Calculator calculator;
    CalculatorService calculatorService;

    @BeforeAll
    public void init() {
        calculator = new Calculator();
        calculatorService = new CalculatorService();
    }

    @TestFactory
    public Stream<DynamicTest> selectionOperations() throws Exception {
        return Stream.of("+", "-", "*", "/")
                .map(operation ->
                    DynamicTest.dynamicTest("Test operation",
                            () -> assertNotNull(calculatorService.selectOperation(operation)))
                );
    }

    @Test
    public void selectionOperationsException() {
        Exception exception = assertThrows(Exception.class, () -> calculatorService.selectOperation("("));
        assertEquals("Operacion no encontrada", exception.getMessage());
    }

    @Test
    public void ejecutarOperationsException() {
        Exception exception = assertThrows(Exception.class, () -> calculatorService.selectOperation(RAIZ));
        assertEquals("Operacion no encontrada", exception.getMessage());
    }
}
