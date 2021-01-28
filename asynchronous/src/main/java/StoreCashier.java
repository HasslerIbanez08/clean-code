public class StoreCashier {
    private String nameCashier;

    public StoreCashier(String nameCashier) {
        this.nameCashier = nameCashier;
    }

    public void buy(Customer customer, long timeStamp) {
        System.out.println("The cashier ".concat(this.nameCashier).concat(" the begins to process the purchase of the customer ")
         .concat(customer.getName())
        .concat(" In the time: "+((System.currentTimeMillis()-timeStamp)/1000)));
        for (int i=0;i<customer.getShoppingCar().length;i++){
            this.waitBySeconds(customer.getShoppingCar()[i]);
            System.out.println("The product processed "+ (i+1) + "Time "+((System.currentTimeMillis()-timeStamp)/1000));
        }
        System.out.println("The cashier ".concat(nameCashier).concat("  has finished to process ".concat(customer.getName()))
        .concat("time "+System.currentTimeMillis()));
    }
    private void waitBySeconds(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        }catch (InterruptedException exception){
            Thread.currentThread().interrupt();
        }
    }
}
