package com.moment.test.entities;

/**
 * Created by Seledkov Andrii on 28.01.2019.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @JoinColumn(name="product")
    private Product product;
    private double unitPrice;
    private int quantity;
    private int discount;
    private double totalPrice;

    private LocalDate date;
}
