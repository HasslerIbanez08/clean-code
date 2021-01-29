package authenticatecase;
@FunctionalInterface
public interface AuthenticateService {
    public boolean isAuthenticate(String userName,String password) throws InterruptedException;
}
