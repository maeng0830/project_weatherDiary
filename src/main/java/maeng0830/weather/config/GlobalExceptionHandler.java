package maeng0830.weather.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 해당 에러일 때 작동
    @ExceptionHandler(Exception.class) // 모든 exception에 대해 동작
    public Exception handleAllException() {
        System.out.println("error from GlobalException");
        return new Exception();
    }
}
