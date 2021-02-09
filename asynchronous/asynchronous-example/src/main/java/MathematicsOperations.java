public class MathematicsOperations {
    public Long factorial(int number){
        Long factorial =1l;
        for (int i=2;i<=number;i++){
            factorial *= i;
        }
        return  factorial;
    }
}
