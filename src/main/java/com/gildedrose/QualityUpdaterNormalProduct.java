package com.gildedrose;

public class QualityUpdaterNormalProduct implements QualityUpdater {

    private Product product;

    public QualityUpdaterNormalProduct(Product product) {
        this.product = product;
    }

    public QualityUpdaterNormalProduct() {
    }

    @Override
    public void process(Product product) {
        if(product.hasQualityStrictlyPositive())
            product.decrementQuality();
        if (product.isExpired() && product.hasQualityStrictlyPositive())
            product.decrementQuality();
    }
}
