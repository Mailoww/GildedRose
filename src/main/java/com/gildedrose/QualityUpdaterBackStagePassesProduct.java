package com.gildedrose;

public class QualityUpdaterBackStagePassesProduct implements QualityUpdater {

    private Product product;

    public QualityUpdaterBackStagePassesProduct(Product product) {
        this.product = product;
    }

    @Override
    public void process() {
        if(product.hasSellInUnder(0))
            product.makeQualityAtZero();
        else if(product.hasQualityStrictlyUnder50()){

            product.incrementQuality();

            if (product.hasSellInUnder(11)) {
                if (product.hasQualityStrictlyUnder50()) {
                    product.incrementQuality();
                }
            }

            if (product.hasSellInUnder(6)) {
                if (product.hasQualityStrictlyUnder50()) {
                    product.incrementQuality();
                }
            }
        }
    }
}
