package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            Item product = items[i];

            if(isNormalProduct(product)){
                if(product.quality > 0)
                    product.quality--;
                if ((isExpired(product) || product.sellIn == 0) && product.quality > 0)
                    product.quality--;
            }

            if (!isNormalProduct(product) && product.quality > 0) {
                if (product.quality < 50) {
                    product.quality = product.quality + 1;

                    if (isBackstagePasses(product)) {
                        if (product.sellIn < 11) {
                            if (product.quality < 50) {
                                product.quality = product.quality + 1;
                            }
                        }

                        if (product.sellIn < 6) {
                            if (product.quality < 50) {
                                product.quality = product.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!isSulfuras(product)) {
                product.sellIn = product.sellIn - 1;
            }

            if (!isNormalProduct(product) && product.sellIn < 0) {
                if (!isAgedBrie(product)) {
                    if (!isBackstagePasses(product)) {
                        if (product.quality > 0) {
                            if (!isSulfuras(product)) {
                                product.quality = product.quality - 1;
                            }
                        }
                    } else {
                        product.quality = product.quality - product.quality;
                    }
                } else {
                    if (product.quality < 50) {
                        product.quality = product.quality + 1;
                    }
                }
            }
        }
    }

    private boolean isExpired(Item product) {
        return product.sellIn < 0;
    }

    private boolean isNormalProduct(Item product) {
        return !isAgedBrie(product)
                && !isBackstagePasses(product)
                && !isSulfuras(product);
    }

    private boolean isAgedBrie(Item product) {
        return product.name.equals("Aged Brie");
    }

    private boolean isBackstagePasses(Item product) {
        return product.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isSulfuras(Item product) {
        return product.name.equals("Sulfuras, Hand of Ragnaros");
    }
}