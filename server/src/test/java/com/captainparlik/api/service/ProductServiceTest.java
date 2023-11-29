package com.captainparlik.api.service;

import com.captainparlik.api.model.Product;
import com.captainparlik.api.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

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
    public void should_get_allVisible_products() {
        //when
        when(productRepository.findAllByVisibleTrue()).thenReturn(List.of(product));

        //actual
        List<Product> actual = productService.findAll();

        //assert
        assertThat(actual).isNotNull();
        assertThat(actual).isEqualTo(List.of(product));
    }

    @Test
    public void should_get_visibleProduct_byId() {
        //when
        when(productRepository.findByIdAndVisibleTrue(anyLong())).thenReturn(Optional.of(product));

        //actual
        Product actual = productService.findById(1L);

        //assert
        assertThat(actual).isNotNull();
        assertThat(actual).isEqualTo(product);
    }
}