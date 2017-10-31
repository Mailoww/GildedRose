package com.gildedrose.updater.quality;

import com.gildedrose.product.Product;

public class QualityUpdaterConjuredProduct implements QualityUpdater {

    @Override
    public void update(Product product) {
        int decrementNumber = 2;
        if(product.isExpired())
            decrementNumber = 4;
        do{
            if(product.hasQualityStrictlyPositive())
                product.decrementQuality();
        }while(--decrementNumber > 0);
    }
}
