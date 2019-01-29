package com.moment.test.controller;

import com.moment.test.entities.Sale;
import com.moment.test.service.product.SaleService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Created by Seledkov Andrii on 28.01.2019.
 */
@RestController
@RequestMapping("sale")
@GraphQLApi
public class ProductSaleController {

    @Autowired
    private SaleService saleService;

    @GraphQLQuery(name = "sale")
    public Optional<Sale> getSale(@GraphQLArgument(name = "id") int id) {
        return saleService.findById(id);
    }

    @GraphQLMutation(name = "saveSale")
    public Sale saveSale(@GraphQLArgument(name = "sale") Sale sale) {
        return saleService.save(sale);
    }

    @GraphQLMutation(name = "deleteSale")
    public boolean deleteSale(@GraphQLArgument(name = "id") int id) {
        return saleService.deleteById(id);
    }


    @GraphQLQuery(name = "saleByDiscount")
    public List<Sale> getSaleByDiscount(@GraphQLArgument(name = "discount") int discount) {
        return saleService.findByDiscount(discount);
    }

    @GraphQLQuery(name = "summaryAmmount")
    public double getSummaryAmount(@GraphQLArgument(name = "start") LocalDate start, @GraphQLArgument(name = "end") LocalDate end) {
        return saleService.getSummaryAmount(start, end);
    }


}
