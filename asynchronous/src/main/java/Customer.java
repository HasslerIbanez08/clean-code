public class Customer {
    private String name;
    private int[] shoppingCar;

    public Customer(String name, int[] shoppingCar) {
        this.name = name;
        this.shoppingCar = shoppingCar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getShoppingCar() {
        return shoppingCar;
    }

    public void setShoppingCar(int[] shoppingCar) {
        this.shoppingCar = shoppingCar;
    }
}
