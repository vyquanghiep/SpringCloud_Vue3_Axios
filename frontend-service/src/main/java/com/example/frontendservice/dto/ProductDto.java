package com.example.frontendservice.dto;

import jakarta.persistence.*;

import lombok.Data;


import java.math.BigDecimal;

@Data

public class ProductDto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String name;

        private int quantity;

        private BigDecimal price;

        private String decription;

        private String url;

        private String typeproduct;



}
