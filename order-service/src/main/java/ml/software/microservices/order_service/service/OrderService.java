package ml.software.microservices.order_service.service;


import lombok.RequiredArgsConstructor;
import ml.software.microservices.order_service.dto.OrderRequest;
import ml.software.microservices.order_service.model.Order;
import ml.software.microservices.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());
        orderRepository.save(order);
    }
}
