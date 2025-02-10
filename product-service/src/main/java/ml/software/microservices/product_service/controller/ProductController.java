package ml.software.microservices.product_service.controller;


import lombok.RequiredArgsConstructor;
import ml.software.microservices.product_service.dto.ProductRequest;
import ml.software.microservices.product_service.dto.ProductResponse;
import ml.software.microservices.product_service.product.Product;
import ml.software.microservices.product_service.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
   private final  ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody ProductRequest productRequest){
       return productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}
