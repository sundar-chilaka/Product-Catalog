package com.ecom.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	// Custom query methods for filtering and searching
	List<Product> findByCategoryContainingIgnoreCase(String category);

	List<Product> findByNameContainingIgnoreCase(String name);

	Optional<Product> findById(Long id);
}
