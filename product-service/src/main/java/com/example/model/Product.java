package com.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private BigDecimal price;

    @Column(name ="quantity")
    private int quantity;

    @Column(name="decription")
    private String decription;

    @Column(name="url")
    private String url;

    @Column(name="typeproduct")
    private String typeproduct;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;



}
