import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class) -- forma Alfabetica
//@TestMethodOrder(MethodOrderer.DisplayName.class) -- segun display
//@TestMethodOrder(MethodOrderer.Random.class) -- ordanacion aleatoria
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
@IndicativeSentencesGeneration(separator = "->",generator = DisplayNameGenerator.Simple.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AnotationsTest {
    @BeforeAll
    public  void initAll(){
        System.out.println("Me ejecutor antes de todo");
    }
    @BeforeEach
    public void init(){
        System.out.println("Me ejecutor antes de cada uno");
    }
   // @Test
    /*{
        includeTags 'Prioritario'
        excludeTags 'Prioritario'
    }*/
    @Tag("Prioritario")
    @DisplayName("\uD83D\uDE00 Test 1")
    @Order(1)
    @RepeatedTest(value=3,name = "{displayName} {currentRepetition}/{totalRepetitions}")
    public void succedingTest(){
        System.out.println("Ejecuto test 1");
    }
    @Test
    @Order(2)
    @Timeout(100000)
    //@Disabled("Test deshabilitado")
    public void succedingTest2(){
        System.out.println("Ejecuto test 2");
    }
    Calculator calculator = new Calculator();
    Palindromes palindromes = new Palindromes();
    @TestFactory
    public Collection<DynamicTest> dynamicTests(){
        return Arrays.asList(
                DynamicTest.dynamicTest(
                        "Test dinamico 1",()-> assertTrue(palindromes.isPalindrome("madam"))
                ),
                DynamicTest.dynamicTest("TestDinamico2",()->assertEquals(5,calculator.add(3,2)))
        );
    }
    @TestFactory
    public Iterator<DynamicTest> dynamicTestsIterator(){
        return Arrays.asList(
                DynamicTest.dynamicTest(
                        "Test dinamico 1",()-> assertTrue(palindromes.isPalindrome("madam"))
                ),
                DynamicTest.dynamicTest("TestDinamico2",()->assertEquals(5,calculator.add(3,2)))
        ).iterator();
    }
    @TestFactory
    public DynamicTest[] dynamicTestsArrays(){
        return new DynamicTest[]{
                DynamicTest.dynamicTest(
                        "Test dinamico 1",()-> assertTrue(palindromes.isPalindrome("madam"))
                ),
                DynamicTest.dynamicTest("TestDinamico2",()->assertEquals(5,calculator.add(3,2)))
        };
    }
    @TestFactory
    public Stream<DynamicTest> dynamicTestsStreams(){
        return Stream.of("mom","madam","dad","radar")
            .map(text-> DynamicTest.dynamicTest(
                    "Test dinamico 1",()-> assertTrue(palindromes.isPalindrome(text))
            ));
    }

    @AfterEach
    public void tearDown(){
        System.out.println("Me ejecuto despues de cada metodo de prueba");
    }
    @AfterAll
    public void tearDownAll(){
        System.out.println("Me ejecuto despues de todos");
    }
    //@Nested -> Esta anotacion significa que la clase prueba es anidada o interna y
    // puede compartir configuracion o el estao o una instancia de clasu adjunta
    // -> No se puede usar before All o afterAll dentro de estas clases.

}
