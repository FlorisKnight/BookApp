package restAPI;

import com.google.gson.Gson;
import models.Book;
import shared.dto.request.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/bookapp")
public class BookAppRestResponse implements IBookAppRestReponse{
    private static IBookAppRestLogic logic;
    private Gson gson = new Gson();
    public static void setRestLogic(IBookAppRestLogic logic) {
        BookAppRestResponse.logic = logic;
    }

    @POST
    @Path("/player/login")
    @Consumes("application/json")
    @Produces("application/json")
    public Response Login(String data) {
        LoginRequestDto loginRequestDto = gson.fromJson(data, LoginRequestDto.class);
        if (loginRequestDto == null){
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }

        int userId = logic.Login(loginRequestDto.getLoginData(), loginRequestDto.getPassword());

        return Response.status(200).entity(ResponseHelper.getLoginResultDtoString(userId)).build();
    }

    @POST
    @Path("/player/register")
    @Consumes("application/json")
    @Produces("application/json")
    public Response Register(String data) {
        RegisterRequestDto registerRequestDto = gson.fromJson(data, RegisterRequestDto.class);
        if (registerRequestDto == null) {
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }

        boolean check = logic.Register(registerRequestDto.getUsername(), registerRequestDto.getEmail(), registerRequestDto.getPassword());
        return Response.status(200).entity(ResponseHelper.getBoolResultDtoString(check)).build();
    }

    @POST
    @Path("/player/addbook")
    @Consumes("application/json")
    @Produces("application/json")
    public Response AddBook(String data) {
        AddBookRequestDto addBookRequestDto = gson.fromJson(data,AddBookRequestDto.class);
        if (addBookRequestDto == null){
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }

        Book book = logic.AddBook(addBookRequestDto.getName(),addBookRequestDto.getAuthor());
        return Response.status(200).entity(ResponseHelper.getAddBookResultDtoString(book)).build();
    }

    @PUT
    @Path("/player/movebook")
    @Consumes("application/json")
    @Produces("application/json")
    public Response MoveBook(String data) {
        MoveBookRequestDto moveBookRequestDto = gson.fromJson(data, MoveBookRequestDto.class);
        if (moveBookRequestDto == null){
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }

        boolean check = logic.MoveBook(moveBookRequestDto.getBookId(),moveBookRequestDto.getUserId(),moveBookRequestDto.getListId());
        return Response.status(200).entity(ResponseHelper.getBoolResultDtoString(check)).build();
    }

    @GET
    @Path("/player/loadbooks")
    @Consumes("application/json")
    @Produces("application/json")
    public Response LoadBooks(String data) {
        LoadBooksRequestDto loadBooksRequestDto = gson.fromJson(data,LoadBooksRequestDto.class);
        if (loadBooksRequestDto == null){
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }

        ArrayList<Book> books = logic.LoadBooks(loadBooksRequestDto.getUserId());
        return Response.status(200).entity(ResponseHelper.getLoadBooksResultDtoString(books)).build();
    }

    @DELETE
    @Path("/player/removebook")
    @Consumes("application/json")
    public Response RemoveBook(String data) {
        RemoveBookRequestDto removeBookRequestDto = gson.fromJson(data,RemoveBookRequestDto.class);
        if (removeBookRequestDto == null){
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }

        logic.RemoveBook(removeBookRequestDto.getBookId(),removeBookRequestDto.getUserId());
        return Response.status(200).entity(ResponseHelper.getBoolResultDtoString(true)).build();
    }
}
