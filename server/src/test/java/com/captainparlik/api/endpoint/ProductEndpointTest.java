package com.captainparlik.api.endpoint;

import com.captainparlik.api.model.Product;
import com.captainparlik.api.repository.ProductRepository;
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
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ProductEndpointTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductRepository productRepository;

    private Product product;

    @Before
    public void setUp() {
        product = Product.builder()
                .id(1L)
                .code("WL-2145")
                .name("BPR-9")
                .description("Good hose")
                .imageUrl("test_url")
                .price(22f)
                .visible(true)
                .build();
    }

    @Test
    public void should_fetch_all_visible_products() throws Exception {
        when(productRepository.findAllByVisibleTrue()).thenReturn(List.of(product));

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/api/product")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value(1L));
    }

    @Test
    public void should_get_product_byId() throws Exception {
        when(productRepository.findByIdAndVisibleTrue(anyLong())).thenReturn(Optional.of(product));

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/api/product/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));
    }
}