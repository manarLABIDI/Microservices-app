package ml.software.microservices.inventory.service;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ml.software.microservices.inventory.exception.ProductNotFoundException;
import ml.software.microservices.inventory.repository.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode, Integer quantity) {
        log.info(" Start -- Received request to check stock for skuCode {}, with quantity {}", skuCode, quantity);
        boolean isInStock = inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
        if (!isInStock) {
            log.warn("Product {} is out of stock!", skuCode);
            return false;
        }

        log.info("Product {} is available in stock", skuCode);
        return true;
    }
}
