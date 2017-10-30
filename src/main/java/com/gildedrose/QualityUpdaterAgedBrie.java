package com.gildedrose;

public class QualityUpdaterAgedBrie implements QualityUpdater {
    private Product product;

    public QualityUpdaterAgedBrie(Product product) {
        this.product = product;
    }

    @Override
    public void process() {
        if (product.hasQualityStrictlyUnder50()) {
            product.incrementQuality();
        }

        if (product.isExpired() && product.hasQualityStrictlyUnder50()) {
            product.incrementQuality();
        }
    }
}
