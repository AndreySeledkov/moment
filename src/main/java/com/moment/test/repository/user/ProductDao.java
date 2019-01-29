package com.moment.test.repository.user;


import com.moment.test.entities.Product;

import java.util.Optional;

public interface ProductDao {

    Optional<Product> findById(int id);
    boolean deleteById(int id);
    Product save(Product product);
}

