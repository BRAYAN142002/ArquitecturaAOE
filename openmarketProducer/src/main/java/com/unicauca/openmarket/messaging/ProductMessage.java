/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicauca.openmarket.messaging;

import com.unicauca.openmarket.domain.entity.Product;

/**
 *
 * @author Jorge
 */
public class ProductMessage {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String action;

    public ProductMessage(Product product, String action) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.action = action;
    }

    // Getters y setters
}