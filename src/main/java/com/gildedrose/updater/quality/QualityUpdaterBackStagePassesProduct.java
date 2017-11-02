package com.gildedrose.updater.quality;

import com.gildedrose.model.Product;

public class QualityUpdaterBackStagePassesProduct implements QualityUpdater {

    public static final int SELL_IN_11 = 11;
    public static final int SELL_IN_6 = 6;

    @Override
    public void update(Product product) {
        if(product.isExpired())
            product.makeQualityAtZero();

        else if(product.hasQualityStrictlyUnder(MAXIMUM_QUALITY)){
            product.incrementQuality();

            if (product.hasSellInIsUnder(SELL_IN_11)
                    && product.hasQualityStrictlyUnder(MAXIMUM_QUALITY))
                product.incrementQuality();

            if (product.hasSellInIsUnder(SELL_IN_6)
                    && product.hasQualityStrictlyUnder(MAXIMUM_QUALITY))
                product.incrementQuality();
        }
    }
}
