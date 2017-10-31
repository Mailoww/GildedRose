package com.gildedrose.updater.quality;

import com.gildedrose.product.Product;

public class QualityUpdaterBackStagePassesProduct implements QualityUpdater {

    public QualityUpdaterBackStagePassesProduct() {

    }

    @Override
    public void update(Product product) {
        if(product.hasSellInIsUnder(0))
            product.makeQualityAtZero();

        else if(product.hasQualityStrictlyIsUnder(50)){
            product.incrementQuality();
            if (product.hasSellInIsUnder(11) && product.hasQualityStrictlyIsUnder(50))
                product.incrementQuality();
            if (product.hasSellInIsUnder(6) && product.hasQualityStrictlyIsUnder(50))
                product.incrementQuality();
        }
    }
}
