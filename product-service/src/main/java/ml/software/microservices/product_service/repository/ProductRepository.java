package ml.software.microservices.product_service.repository;

import ml.software.microservices.product_service.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
