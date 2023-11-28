package com.captainparlik.api.endpoint;

import com.captainparlik.api.model.ProductOrder;
import com.captainparlik.api.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client/order")
@RequiredArgsConstructor
public class ProductOrderEndpoint {

    private final OrderService orderService;

    @PostMapping
    public ProductOrder addOrder(@RequestBody ProductOrder productOrder) {
        return orderService.saveOrder(productOrder);
    }
}
