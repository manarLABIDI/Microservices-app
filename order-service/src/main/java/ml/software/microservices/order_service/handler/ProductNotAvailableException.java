package ml.software.microservices.order_service.handler;

public class ProductNotAvailableException extends RuntimeException {

    public ProductNotAvailableException(String msg) { super(msg);}


}
