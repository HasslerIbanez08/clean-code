public class MainThread {
    public static void main(String[] args) {
                long initialTime = System.currentTimeMillis();
        Customer customer = new Customer("Hassler",new int[]{2,2,1,5,2,3});
        Customer customer2 = new Customer("Ibañez",new int[]{4,1,4,1,1});

        StoreCashierThread storeCashier = new StoreCashierThread("Yahir",customer,initialTime);
        StoreCashierThread storeCashier1 = new StoreCashierThread("Yahir",customer2,initialTime);
        storeCashier.start();
        storeCashier1.start();
    }
}
