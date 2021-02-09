public class MainRunnable implements  Runnable{
    private StoreCashier storeCashier;
    private Customer customer;
    private long initialTime;

    public MainRunnable(StoreCashier storeCashier, Customer customer, long initialTime) {
        this.storeCashier = storeCashier;
        this.customer = customer;
        this.initialTime = initialTime;
    }

    @Override
    public void run() {
        this.storeCashier.buy(customer,initialTime);
    }

    public static void main(String[] args) {
        long initialTime = System.currentTimeMillis();
        Customer customer = new Customer("Hassler",new int[]{2,2,1,5,2,3});
        Customer customer2 = new Customer("Ibañez",new int[]{4,1,4,1,1});
        StoreCashier storeCashier = new StoreCashier("Yahir");
        StoreCashier storeCashier1 = new StoreCashier("Yahir");
        Runnable processOne= ()-> storeCashier.buy(customer,initialTime);
                //new MainRunnable(storeCashier,customer,initialTime);
        Runnable processTwo= ()-> storeCashier1.buy(customer2,initialTime);
                //new MainRunnable(storeCashier1,customer2,initialTime);
        new Thread(processOne).start();
        new Thread(processTwo).start();
    }
}
