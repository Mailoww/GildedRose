package com.gildedrose.updater.quality;

import com.gildedrose.model.Product;

public class QualityUpdaterConjuredProduct implements QualityUpdater {

    private static final int NUMBER_OF_DECREMENT_WHEN_NO_EXPIRED = 2;
    private static final int NUMBER_OF_DECREMENT_WHEN_EXPIRED = 4;

    @Override
    public void update(Product product) {
        int decrementNumber = NUMBER_OF_DECREMENT_WHEN_NO_EXPIRED;
        if(product.isExpired())
            decrementNumber = NUMBER_OF_DECREMENT_WHEN_EXPIRED;
        do{
            incrementQuality(product);
        }while(--decrementNumber > 0);
    }

    private void incrementQuality(Product product) {
        if(product.hasQualityStrictlyPositive())
            product.decrementQuality();
    }
}
