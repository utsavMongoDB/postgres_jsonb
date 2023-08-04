package com.test.jsonb.repo;

import com.test.jsonb.models.Product;
import com.test.jsonb.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {

}
