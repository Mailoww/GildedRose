package com.gildedrose;

import java.util.ArrayList;
import java.util.Collection;

class GildedRose {

    private final Collection<Product> products;

    public GildedRose(Item[] items) {
        products = new ArrayList();
        for (Item item : items)
            products.add(new Product(item));
    }

    public void updateQuality() {

        for (Product product : products) {

            product.decrementDay();

            if(product.isNormalProduct()){
                if(product.hasQualityStrictlyPositive())
                    product.decrementQuality();
                if (product.isExpired() && product.hasQualityStrictlyPositive())
                    product.decrementQuality();
            }

            if (!product.isNormalProduct() && product.hasQualityStrictlyPositive()) {
                if (product.hasQualityStrictlyBelow50()) {
                    product.incrementQuality();

                    if (product.isBackstagePasses()) {
                        if (product.hasSellInBelow(11)) {
                            if (product.hasQualityStrictlyBelow50()) {
                                product.incrementQuality();
                            }
                        }

                        if (product.hasSellInBelow(6)) {
                            if (product.hasQualityStrictlyBelow50()) {
                                product.incrementQuality();
                            }
                        }
                    }
                }
            }

            if (!product.isNormalProduct() && product.hasSellInBelow(0)) {
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