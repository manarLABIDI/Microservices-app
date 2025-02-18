package ml.software.microservices.order_service.controller;


import lombok.RequiredArgsConstructor;
import ml.software.microservices.order_service.dto.OrderRequest;
import ml.software.microservices.order_service.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequest orderRequest) {
        try {
            orderService.placeOrder(orderRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("Order placed successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body( e.getMessage());
        }
    }
}
