package authenticatecase;

public class Authenticate implements AuthenticateService{

    public static final String USER_NAME = "hassler";
    public static final String PASSWORD = "123456";

    @Override
    public boolean isAuthenticate(String userName, String password) throws InterruptedException {
        Thread.sleep(2);
        return (userName.equals(USER_NAME) && password.equals(PASSWORD));
    }
}
