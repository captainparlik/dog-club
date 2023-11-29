package com.captainparlik.api.service;

import com.captainparlik.api.model.*;
import com.captainparlik.api.repository.ProductOrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTest {

    @Mock
    private ProductOrderRepository productOrderRepository;

    @InjectMocks
    private OrderService orderService;

    private ProductOrder productOrder;

    @Before
    public void setUp() {
        Product product = Product.builder()
                .id(1L)
                .code("WL-2145")
                .name("BPR-9")
                .description("Good hose")
                .imageUrl("test_url")
                .price(22f)
                .visible(true)
                .build();
        productOrder = ProductOrder.builder()
                .id(1L)
                .firstName("Test")
                .lastName("Sasha")
                .phone("1234")
                .city("Kharkiv")
                .product(List.of(product))
                .deliveryMethod(DeliveryMethod.PICKUP)
                .paymentMethod(PaymentMethod.CARD)
                .orderStatus(OrderStatus.CREATED)
                .build();

        when(productOrderRepository.save(any(ProductOrder.class))).thenReturn(productOrder);
    }

    @Test
    public void should_save_order() {
        //Act
        ProductOrder actual = orderService.saveOrder(productOrder);

        //Assert
        assertThat(actual).isNotNull();
        assertThat(actual.getCity()).isEqualTo(productOrder.getCity());
    }
}