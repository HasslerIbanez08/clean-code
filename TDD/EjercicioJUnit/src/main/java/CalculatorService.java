public class CalculatorService {

    public static final String SUMA = "SUMA";
    public static final String RESTA = "RESTA";
    public static final String MULTIPLICACION = "MULTIPLICACION";
    public static final String DIVISION = "DIVISION";
    public static Calculator calculator = new Calculator();

    public  static  String selectOperation(String operation) throws Exception {
        switch (operation){
            case "+":
                return SUMA;
            case "-":
                return RESTA;
            case "*":
                return MULTIPLICACION;
            case "/":
                return DIVISION;

            default:
              throw new Exception("Operacion no encontrada");
        }
    }
    public  static  int ejecutarOperation(String operation,int x, int y) throws Exception {
        switch (operation){
            case SUMA:
                return calculator.add(x,y);
            case RESTA:
                return calculator.subtraction(x,y);
            case MULTIPLICACION:
                return calculator.multiply(x,y);
            case DIVISION:
                return calculator.divide(x,y);

            default:
                throw new Exception("Operacion no encontrada");
        }
    }
}
