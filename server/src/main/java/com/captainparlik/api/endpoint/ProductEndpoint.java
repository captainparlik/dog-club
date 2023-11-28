package com.captainparlik.api.endpoint;

import com.captainparlik.api.model.Product;
import com.captainparlik.api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client/product")
@RequiredArgsConstructor
public class ProductEndpoint {

    private final ProductService productService;

    @GetMapping
    public List<Product> getProduct() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id);
    }
}
