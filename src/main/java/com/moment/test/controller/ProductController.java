package com.moment.test.controller;

import com.moment.test.entities.Product;
import com.moment.test.service.product.ProductService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by Seledkov Andrii on 16.01.2019.
 */
@RestController
@RequestMapping("product")
@GraphQLApi
public class ProductController {

    @Autowired
    private ProductService productService;

    @GraphQLQuery(name = "product")
    public Optional<Product> getProduct(@GraphQLArgument(name = "id") int id) {
        return productService.findById(id);
    }

    @GraphQLMutation(name = "saveProduct")
    public Product saveProduct(@GraphQLArgument(name = "product") Product product) {
        return productService.save(product);
    }

    @GraphQLMutation(name = "deleteProduct")
    public void deleteProduct(@GraphQLArgument(name = "id") int id) {
        productService.deleteById(id);
    }
}
