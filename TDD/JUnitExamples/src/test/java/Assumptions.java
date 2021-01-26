import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class Assumptions {
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,-4})
    public void testWithoutAssume(int source){
        try {
            Thread.sleep(source);
        }catch (InterruptedException interruptedException){
            interruptedException.getStackTrace();
        }
    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,-4})
    public void testWithAssume(int source){
        try {
            assumeTrue(source>=0);
            Thread.sleep(source);
        }catch (InterruptedException interruptedException){
            interruptedException.getStackTrace();
        }
    }
}
