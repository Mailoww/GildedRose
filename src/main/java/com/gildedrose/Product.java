package com.gildedrose;

public class Product {

    private Item item;
    private QualityUpdater qualityUpdater;

    private Product(Item item, QualityUpdater qualityUpdater) {
        this.item = item;
        this.qualityUpdater = qualityUpdater;
    }

    public static Product ofAgedBrie(Item item) {
        return new Product(item, new QualityUpdaterAgedBrie());
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
        qualityUpdater.process(this);
    }

    boolean isExpired() {
        return item.sellIn <= 0;
    }

    boolean isSulfuras() {
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
