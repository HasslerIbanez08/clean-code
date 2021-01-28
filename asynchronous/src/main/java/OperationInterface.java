@FunctionalInterface
public interface OperationInterface {
    public double operation(double x,double y);
    public default String nameOperation(){
        return "";
    };
}
