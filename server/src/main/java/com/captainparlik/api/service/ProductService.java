package com.captainparlik.api.service;

import com.captainparlik.api.model.Product;
import com.captainparlik.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAllByVisibleTrue();
    }

    public Product findById(Long id) {
            return productRepository.findByIdAndVisibleTrue(id).orElseThrow();
    }
}
