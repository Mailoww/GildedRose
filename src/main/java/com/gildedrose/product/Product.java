package com.gildedrose.product;

import com.gildedrose.updater.quality.*;

public class Product {

    private final Item item;
    private final QualityUpdater qualityUpdater;

    private Product(Item item, QualityUpdater qualityUpdater) {
        this.item = item;
        this.qualityUpdater = qualityUpdater;
    }

    public static Product ofAgedBrie(Item item) {
        return new Product(item, new QualityUpdaterAgedBrieProduct());
    }

    public static Product ofNormal(Item item) {
        return new Product(item, new QualityUpdaterNormalProduct());
    }

    public static Product ofBackstagePasses(Item item) {
        return new Product(item, new QualityUpdaterBackStagePassesProduct());
    }

    public static Product ofSulfuras(Item item) {
        return new Product(item, new QualityUpdaterSulfurasProduct());
    }

    public void decrementDay() {
        if (!isSulfuras()) {
            item.sellIn--;
        }
    }

    public void updateQuality() {
        qualityUpdater.update(this);
    }

    public boolean isExpired() {
        return item.sellIn <= 0;
    }

    private boolean isSulfuras() {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    public boolean hasQualityStrictlyPositive() {
        return item.quality > 0;
    }

    public void decrementQuality() {
        item.quality--;
    }

    public void incrementQuality() {
        item.quality++;
    }

    public boolean hasQualityStrictlyUnder50() {
        return item.quality < 50;
    }

    public boolean hasSellInUnder(int sellIn) {
        return item.sellIn < sellIn;
    }

    public void makeQualityAtZero() {
        item.quality = 0;
    }
}
