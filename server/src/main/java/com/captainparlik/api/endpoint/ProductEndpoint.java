package com.captainparlik.api.endpoint;

import com.captainparlik.api.model.Product;
import com.captainparlik.api.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Tag(name = "Product Client", description = "Methods for getting products")
public class ProductEndpoint {

    private final ProductService productService;

    @Operation(
            description = "Get all visible products",
            responses = {
                    @ApiResponse(
                            description = "Fetch All visible products",
                            responseCode = "200",
                            content = {@Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Product.class))}
                    )
            }
    )
    @GetMapping
    public List<Product> getProduct() {
        return productService.findAll();
    }

    @Operation(
            description = "Get Product By Id",
            responses = {
                    @ApiResponse(
                            description = "Get Product By Id",
                            responseCode = "200",
                            content = {@Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Product.class))}
                    ),
                    @ApiResponse(
                            description = "Product not Found",
                            responseCode = "404",
                            content = {@Content(
                                    mediaType = "application/json")}
                    )
            }
    )
    @GetMapping("/{id}")
    public Product getProductById(
            @Parameter(description = "Product identifier", example = "1")
            @PathVariable Long id) {
        return productService.findById(id);
    }
}
