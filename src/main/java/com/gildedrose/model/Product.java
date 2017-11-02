package com.gildedrose.model;

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

    public void decrementSellIn() {
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

    public boolean hasQualityStrictlyUnder(int number) {
        return item.quality < number;
    }

    public boolean hasSellInIsUnder(int sellIn) {
        return item.sellIn < sellIn;
    }

    public void makeQualityAtZero() {
        item.quality = 0;
    }
}
