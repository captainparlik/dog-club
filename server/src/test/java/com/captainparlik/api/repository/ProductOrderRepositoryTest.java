package com.captainparlik.api.repository;

import com.captainparlik.api.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductOrderRepositoryTest {

    @Autowired
    private ProductOrderRepository productOrderRepository;

    private ProductOrder productOrder;

    @Before
    public void setUp() {
        Product product = Product.builder()
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
    }

    @Test
    public void should_save_order() {
        //act
        ProductOrder actual = productOrderRepository.save(productOrder);

        //assert
        assertThat(actual).isNotNull();
        assertThat(actual.getProduct().get(0).getName()).isEqualTo(productOrder.getProduct().get(0).getName());
    }
}