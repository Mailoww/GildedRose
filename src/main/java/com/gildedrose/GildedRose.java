package com.gildedrose;

import com.gildedrose.product.Item;
import com.gildedrose.product.ItemAdapter;
import com.gildedrose.product.Product;

import java.util.Collection;

class GildedRose {

    final Item[] items;
    private final Collection<Product> products;

    public GildedRose(Item[] items) {
        this.items = items;
        products = ItemAdapter.convertToProduct(items);
    }

    public void updateQuality() {
        for (Product product : products) {
            product.decrementDay();
            product.updateQuality();
        }
    }
}