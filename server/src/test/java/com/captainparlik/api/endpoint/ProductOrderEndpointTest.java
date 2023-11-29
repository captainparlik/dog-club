package com.captainparlik.api.endpoint;

import com.captainparlik.api.model.*;
import com.captainparlik.api.repository.ProductOrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ProductOrderEndpointTest {

    @MockBean
    private ProductOrderRepository productOrderRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

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
    }

    @Test
    public void should_save_order() throws Exception {
        when(productOrderRepository.save(any(ProductOrder.class))).thenReturn(productOrder);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productOrder)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Test"));
    }
}