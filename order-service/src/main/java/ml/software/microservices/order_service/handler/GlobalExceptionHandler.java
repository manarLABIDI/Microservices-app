package ml.software.microservices.order_service.handler;


import ml.software.microservices.order_service.exception.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotAvailableException.class)
    public ResponseEntity<ExceptionResponse> handleProductNotFoundException(ProductNotAvailableException ex) {
        return  ResponseEntity
                .status(NOT_FOUND)
                .body(
                        ExceptionResponse.builder()
                                .error(ex.getMessage())
                                .build()
                );
    }
}
