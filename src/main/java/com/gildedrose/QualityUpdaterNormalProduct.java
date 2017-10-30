package com.gildedrose;

public class QualityUpdaterNormalProduct implements QualityUpdater {

    private Product product;

    public QualityUpdaterNormalProduct(Product product) {
        this.product = product;
    }

    @Override
    public void process() {
        if(product.hasQualityStrictlyPositive())
            product.decrementQuality();
        if (product.isExpired() && product.hasQualityStrictlyPositive())
            product.decrementQuality();
    }
}
