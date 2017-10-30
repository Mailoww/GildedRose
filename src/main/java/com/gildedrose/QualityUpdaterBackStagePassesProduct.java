package com.gildedrose;

public class QualityUpdaterBackStagePassesProduct implements QualityUpdater {

    private Product product;

    public QualityUpdaterBackStagePassesProduct(Product product) {
        this.product = product;
    }

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
