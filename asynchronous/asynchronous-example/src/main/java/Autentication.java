public class Autentication implements FunctionalInterfacesAutenticacion {
    @Override
    public boolean isAutenticate(String password, String user)  {

        boolean autenticate = password.equals("123456") && user.equals("hassler");
        System.out.println("El usuario tiene este estado de autentication: ".concat(autenticate+""));
        return autenticate;
    }
}
