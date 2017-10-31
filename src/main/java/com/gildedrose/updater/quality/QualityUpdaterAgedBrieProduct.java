package com.gildedrose.updater.quality;

import com.gildedrose.product.Product;

public class QualityUpdaterAgedBrieProduct implements QualityUpdater {

    public QualityUpdaterAgedBrieProduct() {

    }

    @Override
    public void update(Product product) {
        if (product.hasQualityStrictlyUnder50())
            product.incrementQuality();
        if (product.isExpired() && product.hasQualityStrictlyUnder50())
            product.incrementQuality();
    }
}
