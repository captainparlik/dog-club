package com.captainparlik.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firsName;

    private String lastName;

    private String phone;

    private String city;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Product> products;

    private DeliveryMethod deliveryMethod;

    private PaymentMethod paymentMethod;

    private OrderStatus orderStatus = OrderStatus.CREATED;
}
