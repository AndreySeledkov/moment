package com.moment.test.service.product;

import com.moment.test.entities.Product;

import java.util.Optional;

/**
 * Created by Seledkov Andrii on 18.01.2019.
 */
public interface ProductService {
    Product save(Product product);

    Optional<Product> findById(int id);

    boolean deleteById(int id);
}
