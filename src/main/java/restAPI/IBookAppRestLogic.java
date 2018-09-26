package restAPI;

public interface IBookAppRestLogic {
    //Login
    //loginData can be email or username
    int Login(String loginData, String password);

    //Register
    Boolean Register(String username, String email, String password);

    //Add book


    //Move Book


    //Load Books


    //Remove Book


}
