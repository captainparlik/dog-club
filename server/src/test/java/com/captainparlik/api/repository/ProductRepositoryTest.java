package com.captainparlik.api.repository;

import com.captainparlik.api.model.Product;
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
public class ProductRepositoryTest {

    @Autowired
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
    public void should_find_product_byId() {
        //act
        productRepository.save(product);
        Product actual = productRepository.findByIdAndVisibleTrue(1L).orElseThrow();

        //assert
        assertThat(actual).isNotNull();
        assertThat(actual).isEqualTo(product);
    }

    @Test
    public void should_fetch_all_visibleProducts() {
        //act
        productRepository.save(product);
        List<Product> actual = productRepository.findAllByVisibleTrue();

        //assert
        assertThat(actual).isNotNull();
        assertThat(actual).isEqualTo(List.of(product));

    }
}