import com.usercases.Calculator;
import com.usercases.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MockitoExampleTest {
    Person person ;
    @BeforeAll
    public void beforeAll(){
        person = new Person("Hassler",25);
    }
    @Test
    public void playTest(){
        Person personMocki = Mockito.spy(person);
//       Mockito.when(personMocki.runInGround("ground"))
//                .thenReturn(true);
        Mockito.doReturn(true)
                .when(personMocki)
                .runInGround("ground");
        assertTrue(personMocki.isPlay());
    }
    @Test
    public void correctSunTest() {
        Calculator calculatorMock = Mockito.spy(Calculator.class);
        Mockito.when(calculatorMock.add(2,3))
                .thenReturn(6);
        assertEquals(6,calculatorMock.add(1,3));
    }
}
