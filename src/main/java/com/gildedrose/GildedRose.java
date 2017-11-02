package com.gildedrose;

import com.gildedrose.adapter.ItemAdapterToProduct;
import com.gildedrose.model.Item;
import com.gildedrose.model.Product;
import com.gildedrose.repository.ProductRepository;
import com.gildedrose.repository.ProductRepositoryInMemory;
import com.gildedrose.updater.product.ProductsUpdater;
import com.gildedrose.updater.product.ProductsUpdaterPerDay;

import java.util.Collection;

class GildedRose {

    final Item[] items;

    private final ProductsUpdater productsUpdater;

    public GildedRose(Item[] items) {
        this.items = items;
        Collection<Product> products = ItemAdapterToProduct.convertToProduct(items);
        ProductRepository productRepository = new ProductRepositoryInMemory(products);
        productsUpdater = new ProductsUpdaterPerDay(productRepository);
    }
    public void updateQuality() {
        productsUpdater.update();
    }

}