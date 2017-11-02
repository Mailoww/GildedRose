package com.gildedrose.updater.product;

import com.gildedrose.model.Product;
import com.gildedrose.repository.ProductRepository;

public class ProductsUpdaterPerDay implements ProductsUpdater {

    private final ProductRepository productRepository;

    public ProductsUpdaterPerDay(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void update() {
        for (Product product : productRepository.getProducts()) {
            product.decrementDay();
            product.updateQuality();
        }
    }
}