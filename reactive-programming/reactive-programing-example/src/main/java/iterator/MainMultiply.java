package iterator;

public class MainMultiply {
    public static void main(String[] args) {
        MultiplyList multiplyList = new MultiplyList(10,5);
        for (int i:multiplyList){
            System.out.println(i);
        }
    }
}
