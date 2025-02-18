package ml.software.microservices.order_service.service;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ml.software.microservices.order_service.dto.OrderRequest;
import ml.software.microservices.order_service.handler.ProductNotAvailableException;
import ml.software.microservices.order_service.model.Order;
import ml.software.microservices.order_service.proxy.InventoryProxy;
import ml.software.microservices.order_service.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryProxy inventoryProxy;

    public void placeOrder(OrderRequest orderRequest) throws ProductNotAvailableException {
        var isInStock = inventoryProxy.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if (isInStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());
            orderRepository.save(order);
        } else {
            throw new RuntimeException("Product " + orderRequest.skuCode() + " is out of stock for the requested quantity.");
        }

    }
}
