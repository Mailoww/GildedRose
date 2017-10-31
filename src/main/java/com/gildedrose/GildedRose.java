package com.gildedrose;

import java.util.ArrayList;
import java.util.Collection;

class GildedRose {

    Item[] items;
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