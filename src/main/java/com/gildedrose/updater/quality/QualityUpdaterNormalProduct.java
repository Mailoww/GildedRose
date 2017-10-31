package com.gildedrose.updater.quality;

import com.gildedrose.product.Product;

public class QualityUpdaterNormalProduct implements QualityUpdater {

    public QualityUpdaterNormalProduct() {
    }

    @Override
    public void update(Product product) {
        if(product.hasQualityStrictlyPositive())
            product.decrementQuality();
        if (product.isExpired() && product.hasQualityStrictlyPositive())
            product.decrementQuality();
    }
}
