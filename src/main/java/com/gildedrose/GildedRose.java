package com.gildedrose;

import java.util.ArrayList;
import java.util.Collection;

class GildedRose {

    Item[] items;
    private final Collection<Product> products;

    public GildedRose(Item[] items) {
        this.items = items;
        products = new ArrayList();
        for (Item item : items)
            products.add(new Product(item));
    }

    public void updateQuality() {

        for (Product product : products) {

            product.decrementDay();

            QualityUpdater qualityUpdater = new QualityUpdaterSulfuraProduct();

            if(product.isNormalProduct()){
                qualityUpdater = new QualityUpdaterNormalProduct(product);
            }

            if(product.isBackstagePasses()){
                qualityUpdater = new QualityUpdaterBackStagePassesProduct(product);
            }

            if(product.isAgedBrie()){
                qualityUpdater = new QualityUpdaterAgedBrie(product);
            }

            qualityUpdater.process();
        }
    }
}