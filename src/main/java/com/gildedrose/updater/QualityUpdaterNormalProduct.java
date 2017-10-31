package com.gildedrose.updater;

import com.gildedrose.product.Product;

public class QualityUpdaterNormalProduct implements QualityUpdater {

    public QualityUpdaterNormalProduct() {
    }

    @Override
    public void process(Product product) {
        if(product.hasQualityStrictlyPositive())
            product.decrementQuality();
        if (product.isExpired() && product.hasQualityStrictlyPositive())
            product.decrementQuality();
    }
}
