package com.gildedrose.product;

import java.util.ArrayList;
import java.util.Collection;

public class ItemAdapter {

    private static final String SULFURAS_PRODUCT = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES_PRODUCT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE_PRODUCT = "Aged Brie";

    public static Collection<Product> convertToProduct(Item[] items){
        Collection<Product> products = new ArrayList<>();
        for (Item item : items){
            Product product;
            switch (item.name) {
                case SULFURAS_PRODUCT:
                    product = Product.ofSulfuras(item);
                    break;
                case BACKSTAGE_PASSES_PRODUCT:
                    product = Product.ofBackstagePasses(item);
                    break;
                case AGED_BRIE_PRODUCT:
                    product = Product.ofAgedBrie(item);
                    break;
                default:
                    product = Product.ofNormal(item);
                    break;
            }
            products.add(product);
        }
        return products;
    }
}
