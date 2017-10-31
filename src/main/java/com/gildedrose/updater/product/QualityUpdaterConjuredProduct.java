package com.gildedrose.updater.product;

import com.gildedrose.product.Product;
import com.gildedrose.updater.quality.QualityUpdater;

public class QualityUpdaterConjuredProduct implements QualityUpdater {

    @Override
    public void update(Product product) {
        if(product.hasQualityStrictlyPositive())
            product.decrementQuality();
        if(product.hasQualityStrictlyPositive())
            product.decrementQuality();
        if(product.isExpired() && product.hasQualityStrictlyPositive())
            product.decrementQuality();
        if(product.isExpired() && product.hasQualityStrictlyPositive())
            product.decrementQuality();
    }
}
