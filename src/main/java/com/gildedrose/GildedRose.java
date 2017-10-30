package com.gildedrose;

import java.util.ArrayList;
import java.util.Collection;

class GildedRose {

    Item[] items;
    private final Collection<Product> products;

    public GildedRose(Item[] items) {
        this.items = items;
        products = new ArrayList();
        for (Item item : items){
            Product product;
            if(item.name.equals("Sulfuras, Hand of Ragnaros"))
                product = Product.ofSulfuras(item);
            else if(item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
                product = Product.ofBackstagePasses(item);
            else if(item.name.equals("Aged Brie"))
                product = Product.ofAgedBrie(item);
            else
                product = Product.ofNormal(item);
            products.add(product);
        }
    }

    public void updateQuality() {

        for (Product product : products) {
            product.decrementDay();
            product.updateQuality();
        }
    }
}