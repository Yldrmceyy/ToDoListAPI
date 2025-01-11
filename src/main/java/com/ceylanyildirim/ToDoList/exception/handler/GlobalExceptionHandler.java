package com.ceylanyildirim.ToDoList.exception.handler;

import com.ceylanyildirim.ToDoList.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
// * GlobalExceptionHandler, proje genelinde oluşan istisnaları yönetir.


@ControllerAdvice
public class GlobalExceptionHandler {

    // * BaseException türündeki hataları yakalar ve  ApiError formatına çevirir ve kullanıcıya döner

    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<ApiError> handleBaseException(BaseException exception, WebRequest request) {

        return ResponseEntity.badRequest().body(createApiError(exception.getMessage(), request));
    }


    // * Hata mesajı, path ve timestamp bilgilerini içeren bir ApiError nesnesi oluşturur.
    public <E> ApiError<E> createApiError(E message, WebRequest request) {
        ApiError<E> apiError = new ApiError<>();   // Hata bilgilerini içeren bir model
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());  // Hata durum kodu: 400

        Exception<E> exception = new Exception<>();
        exception.setCreateTime(new Date());  // Hatanın oluştuğu zaman
        exception.setPath(request.getDescription(false).substring(4)); // Hatanın oluştuğu path
        exception.setMessage(message);  // Hata mesajı

        apiError.setException(exception); // ApiError içine hatayı ekler


        return apiError;
    }
}