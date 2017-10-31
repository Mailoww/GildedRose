package com.gildedrose;

import java.util.ArrayList;
import java.util.Collection;

public class ItemAdapter {

    public static final String SULFURAS_PRODUCT = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES_PRODUCT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String AGED_BRIE_PRODUCT = "Aged Brie";

    static Collection<Product> convertToProduct(Item[] items){
        Collection<Product> products = new ArrayList<>();
        for (Item item : items){
            Product product;
            if(item.name.equals(SULFURAS_PRODUCT))
                product = Product.ofSulfuras(item);
            else if(item.name.equals(BACKSTAGE_PASSES_PRODUCT))
                product = Product.ofBackstagePasses(item);
            else if(item.name.equals(AGED_BRIE_PRODUCT))
                product = Product.ofAgedBrie(item);
            else
                product = Product.ofNormal(item);
            products.add(product);
        }
        return products;
    }
}
