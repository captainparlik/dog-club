package com.captainparlik.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Product",
        description = "Product Information")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier", example = "1")
    private Long id;

    @Schema(description = "Product vendor code", example = "WL-2154")
    private String code;

    @Schema(description = "Product name", example = "Iphone 12 Pro Max")
    @NotNull(message = "Name is required")
    private String name;

    @Schema(description = "Product description", example = "256 gb White color", nullable = true)
    private String description;

    @Schema(description = "Url to product image", nullable = true)
    private String imageUrl;

    @Schema(description = "Product price", nullable = true, example = "22.56")
    private Float price;

    @Schema(description = "Set product visible to client or not", example = "true")
    @NotNull(message = "This field is required")
    private Boolean visible;
}
