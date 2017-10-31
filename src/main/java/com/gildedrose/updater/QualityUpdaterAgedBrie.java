package com.gildedrose.updater;

import com.gildedrose.product.Product;

public class QualityUpdaterAgedBrie implements QualityUpdater {

    public QualityUpdaterAgedBrie() {

    }

    @Override
    public void process(Product product) {
        if (product.hasQualityStrictlyUnder50())
            product.incrementQuality();
        if (product.isExpired() && product.hasQualityStrictlyUnder50())
            product.incrementQuality();
    }
}
