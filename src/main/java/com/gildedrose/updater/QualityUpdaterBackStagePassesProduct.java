package com.gildedrose.updater;

import com.gildedrose.product.Product;

public class QualityUpdaterBackStagePassesProduct implements QualityUpdater {

    public QualityUpdaterBackStagePassesProduct() {

    }

    @Override
    public void process(Product product) {
        if(product.hasSellInUnder(0))
            product.makeQualityAtZero();

        else if(product.hasQualityStrictlyUnder50()){
            product.incrementQuality();
            if (product.hasSellInUnder(11) && product.hasQualityStrictlyUnder50())
                product.incrementQuality();
            if (product.hasSellInUnder(6) && product.hasQualityStrictlyUnder50())
                product.incrementQuality();
        }
    }
}
