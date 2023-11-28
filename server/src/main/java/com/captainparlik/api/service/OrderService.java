package com.captainparlik.api.service;

import com.captainparlik.api.model.ProductOrder;
import com.captainparlik.api.repository.ProductOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductOrderRepository productOrderRepository;

    public ProductOrder saveOrder(ProductOrder productOrder) {
        return productOrderRepository.save(productOrder);
    }
}
