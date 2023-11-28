package com.captainparlik.api.endpoint;

import com.captainparlik.api.model.ProductOrder;
import com.captainparlik.api.service.OrderService;
import com.captainparlik.exception.dto.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Tag(name = "Order Client Endpoint", description = "Method for creating order")
public class ProductOrderEndpoint {

    private final OrderService orderService;

    @Operation(
            description = "Create Order",
            responses = {
                    @ApiResponse(
                            description = "Order created",
                            responseCode = "200",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ProductOrder.class))}
                    ),
                    @ApiResponse(
                            description = "Bad request",
                            responseCode = "400",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorResponse.class))}
                    )
            }
    )
    @PostMapping
    public ProductOrder addOrder(@RequestBody @Validated ProductOrder productOrder) {
        return orderService.saveOrder(productOrder);
    }
}
