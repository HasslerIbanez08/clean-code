public class FunctionalInterfaces {
    public static void main(String[] args) {
        OperationInterface operationInterface =(x,y)->x+y;
        System.out.println(operationInterface.operation(4,8));
    }
}
