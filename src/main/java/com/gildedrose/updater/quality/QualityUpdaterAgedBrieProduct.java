package com.gildedrose.updater.quality;

import com.gildedrose.model.Product;

public class QualityUpdaterAgedBrieProduct implements QualityUpdater {

    public QualityUpdaterAgedBrieProduct() {

    }

    @Override
    public void update(Product product) {
        if (product.hasQualityStrictlyUnder(MAXIMUM_QUALITY))
            product.incrementQuality();
        if (product.isExpired() && product.hasQualityStrictlyUnder(MAXIMUM_QUALITY))
            product.incrementQuality();
    }
}
