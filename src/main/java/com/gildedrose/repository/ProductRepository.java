package com.gildedrose.repository;

import com.gildedrose.model.Product;

import java.util.Collection;

public interface ProductRepository {

    Collection<Product> getProducts();
}
