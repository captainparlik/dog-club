package com.captainparlik.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Schema(title = "Order", description = "Client orders")
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier", example = "1")
    private Long id;

    @Schema(description = "Client first name", example = "John")
    @NotNull(message = "First name is required")
    private String firstName;

    @Schema(description = "Client last name", example = "Dou")
    @NotNull(message = "Last name is required")
    private String lastName;

    @Schema(description = "Client phone number", example = "0503241444")
    @NotNull(message = "Phone number is required")
    private String phone;

    @Schema(description = "Client city", example = "New-York")
    private String city;

    @Schema(description = "Client products")
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Product> product;

    @Schema(description = "Delivery Methods", example = "NOVA_POST")
    @NotNull(message = "Delivery Method is required")
    private DeliveryMethod deliveryMethod;

    @Schema(description = "Client payment methods", example = "POST")
    @NotNull(message = "Payment Method is required")
    private PaymentMethod paymentMethod;

    @Schema(description = "Order status", example = "CREATED", defaultValue = "CREATED")
    private OrderStatus orderStatus = OrderStatus.CREATED;
}
