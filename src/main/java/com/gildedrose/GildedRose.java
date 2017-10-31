package com.gildedrose;

import com.gildedrose.product.Item;
import com.gildedrose.product.ItemAdapterToProduct;
import com.gildedrose.product.Product;
import com.gildedrose.updater.product.ProductsUpdaterPerDay;

import java.util.Collection;

class GildedRose {

    final Item[] items;
    private final ProductsUpdaterPerDay productsUpdater;

    public GildedRose(Item[] items) {
        this.items = items;
        Collection<Product> products = ItemAdapterToProduct.convertToProduct(items);
        productsUpdater = new ProductsUpdaterPerDay(products);
    }
    public void updateQuality() {
        productsUpdater.update();
    }

}