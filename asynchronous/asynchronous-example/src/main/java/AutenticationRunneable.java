public class AutenticationRunneable  implements Runnable{
    private static Autentication autentication;
    @Override
    public void run() {
        autentication.isAutenticate("123456","hassler");
    }

    public static void main(String[] args) {
        autentication = new Autentication();
        Runnable processAutentication =()->
                autentication.isAutenticate("123456","hassler");

        new Thread(processAutentication).start();
    }
}
