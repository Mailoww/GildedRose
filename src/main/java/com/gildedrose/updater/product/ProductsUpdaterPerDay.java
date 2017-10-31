package com.gildedrose.updater.product;

import com.gildedrose.product.Product;

import java.util.Collection;

public class ProductsUpdaterPerDay implements ProductsUpdater {

    private final Collection<Product> products;

    public ProductsUpdaterPerDay(Collection<Product> products) {
        this.products = products;
    }

    @Override
    public void update() {
        for (Product product : products) {
            product.decrementDay();
            product.updateQuality();
        }
    }
}