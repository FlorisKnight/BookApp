package restAPI;

import javax.ws.rs.core.Response;

public interface IBookAppRestReponse {
    Response Login(String data);

    Response Register(String data);

    Response AddBook(String data);

    Response MoveBook(String data);

    Response LoadBooks(String data);

    Response RemoveBook(String data);
}
