import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class TestCalculator {

    public static final String RAIZ = "RAIZ";
    static Calculator calculator;

    @BeforeAll
    public static void init() {
        calculator = new Calculator();
    }

    @Test
    public Stream<DynamicTest> selectionOperations() throws Exception {
        return Stream.of("+", "-", "*", "/")
                .map(operation -> {
                    return DynamicTest.dynamicTest("Test operation",
                            () -> assertNotNull(CalculatorService.selectOperation(operation)));
                });
    }

    @Test
    public void selectionOperationsException() {
        Exception exception = assertThrows(Exception.class, () -> CalculatorService.selectOperation("("));
        assertEquals("Operacion no encontrada", exception.getMessage());
    }

    @Test
    public Stream<DynamicTest> ejecutarOperations() throws Exception {
        return Stream.of(CalculatorService.SUMA, CalculatorService.RESTA, CalculatorService.MULTIPLICACION, CalculatorService.DIVISION)
                .map(operation -> {
                    return DynamicTest.dynamicTest("Test operation ejecutar",
                            () -> assertNotEquals(0,CalculatorService.ejecutarOperation(operation,3,2)));
                });
    }
    @Test
    public void ejecutarOperationsException() {
        Exception exception = assertThrows(Exception.class, () -> CalculatorService.selectOperation(RAIZ));
        assertEquals("Operacion no encontrada", exception.getMessage());
    }
}
