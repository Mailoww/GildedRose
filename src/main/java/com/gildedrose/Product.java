package com.gildedrose;

public class Product {

    private Item item;

    public Product(Item item) {

        this.item = item;
    }

    public void decrementDay() {
        if (!isSulfuras()) {
            item.sellIn--;
        }
    }

    boolean isExpired() {
        return item.sellIn <= 0;
    }

    boolean isNormalProduct() {
        return !isAgedBrie()
                && !isBackstagePasses()
                && !isSulfuras();
    }

    boolean isAgedBrie() {
        return item.name.equals("Aged Brie");
    }

    boolean isBackstagePasses() {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
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

    public boolean hasQualityStrictlyBelow50() {
        return item.quality < 50;
    }

    public boolean hasSellInUnder(int sellIn) {
        return item.sellIn < sellIn;
    }

    public void makeQualityAtZero() {
        item.quality = 0;
    }
}
