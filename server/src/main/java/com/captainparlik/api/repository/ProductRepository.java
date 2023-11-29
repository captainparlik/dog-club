package com.captainparlik.api.repository;

import com.captainparlik.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findAllByVisibleTrue();

    Optional<Product> findByIdAndVisibleTrue(Long id);
}
