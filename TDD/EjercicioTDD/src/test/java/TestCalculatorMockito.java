import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCalculatorMockito {

    CalculatorService calculatorService;
    Calculator calculatorMock;
    private static final String TEST = "test";

    @BeforeAll
    public void init(){
        calculatorService = new CalculatorService();
        calculatorMock = Mockito.spy(Calculator.class);
    }
    @Test
    public  void operationSum() throws Exception {
        Mockito.doReturn(5)
                .when(calculatorMock)
                .add(3,2);
        assertEquals(5,calculatorService.ejecutarOperation(CalculatorService.SUMA,3,2));

        Mockito.when(calculatorMock.add(3,2))
                .thenReturn(5);
        assertEquals(5,calculatorService.ejecutarOperation(CalculatorService.SUMA,3,2));
    }
    @Test
    public  void operationRest() throws Exception {
        Mockito.doReturn(2)
                .when(calculatorMock)
                .add(4,2);
        assertEquals(2,calculatorService.ejecutarOperation(CalculatorService.RESTA,4,2));

        Mockito.when(calculatorMock.subtraction(4,2))
                .thenReturn(2);
        assertEquals(2,calculatorService.ejecutarOperation(CalculatorService.RESTA,4,2));
    }
    @Test
    public  void operationMultiply() throws Exception {
        Mockito.doReturn(4)
                .when(calculatorMock)
                .add(2,2);
        assertEquals(4,calculatorService.ejecutarOperation(CalculatorService.MULTIPLICACION,2,2));

        Mockito.when(calculatorMock.subtraction(2,2))
                .thenReturn(4);
        assertEquals(4,calculatorService.ejecutarOperation(CalculatorService.MULTIPLICACION,2,2));
    }
    @Test
    public  void operationDivide() throws Exception {
        Mockito.doReturn(1)
                .when(calculatorMock)
                .add(2,2);
        assertEquals(1,calculatorService.ejecutarOperation(CalculatorService.DIVISION,2,2));

        Mockito.when(calculatorMock.subtraction(2,2))
                .thenReturn(1);
        assertEquals(1,calculatorService.ejecutarOperation(CalculatorService.DIVISION,2,2));
    }
}
