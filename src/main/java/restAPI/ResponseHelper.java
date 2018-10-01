package restAPI;

import com.google.gson.Gson;
import models.Book;
import shared.dto.BaseResultDto;
import shared.dto.result.AddBookResultDto;
import shared.dto.result.BoolResultDto;
import shared.dto.result.LoadBooksResultDto;
import shared.dto.result.LoginResultDto;

import java.util.ArrayList;

public class ResponseHelper {
    private ResponseHelper() {
    }

    private static final Gson gson = new Gson();

    public static String getErrorResponseString() {
        BaseResultDto response = new BaseResultDto();
        response.setSuccess(false);
        return gson.toJson(response);
    }

    public static String getBoolResultDtoString(boolean check){
        BoolResultDto response = new BoolResultDto(check);
        response.setSuccess(true);
        return gson.toJson(response);
    }

    public static String getLoginResultDtoString(int userId){
        LoginResultDto response = new LoginResultDto(userId);
        response.setSuccess(true);
        return gson.toJson(response);
    }

    public static String getAddBookResultDtoString(Book book){
        AddBookResultDto response = new AddBookResultDto(book);
        response.setSuccess(true);
        return gson.toJson(response);
    }

    public static String getLoadBooksResultDtoString(ArrayList<Book> books){
        LoadBooksResultDto response = new LoadBooksResultDto(books);
        response.setSuccess(true);
        return gson.toJson(response);
    }
}
