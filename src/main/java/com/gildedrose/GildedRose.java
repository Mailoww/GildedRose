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

            if(product.isNormalProduct()){
                QualityUpdater qualityUpdater = new QualityUpdaterNormalProduct(product);
                qualityUpdater.process();


            } else {

                if (product.hasQualityStrictlyPositive() && product.hasQualityStrictlyBelow50()) {
                        product.incrementQuality();

                        if (product.isBackstagePasses()) {
                            if (product.hasSellInUnder(11)) {
                                if (product.hasQualityStrictlyBelow50()) {
                                    product.incrementQuality();
                                }
                            }

                            if (product.hasSellInUnder(6)) {
                                if (product.hasQualityStrictlyBelow50()) {
                                    product.incrementQuality();
                                }
                            }
                        }
                }

                if (product.hasSellInUnder(0)) {
                    if (!product.isAgedBrie()) {
                        if (!product.isBackstagePasses()) {
                            if (product.hasQualityStrictlyPositive()) {
                                if (!product.isSulfuras()) {
                                    product.decrementQuality();
                                }
                            }
                        } else {
                            product.makeQualityAtZero();
                        }
                    } else {
                        if (product.hasQualityStrictlyBelow50()) {
                            product.incrementQuality();
                        }
                    }
                }
            }
        }
    }
}