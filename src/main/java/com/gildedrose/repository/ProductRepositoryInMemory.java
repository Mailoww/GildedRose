package com.gildedrose.repository;

import com.gildedrose.model.Product;

import java.util.Collection;

public class ProductRepositoryInMemory implements ProductRepository {

    private Collection<Product> products;

    public ProductRepositoryInMemory(Collection<Product> products) {
        this.products = products;
    }

    @Override
    public Collection<Product> getProducts() {
        return products;
    }
}
