package com.gildedrose.updater.quality;

import com.gildedrose.model.Product;

public interface QualityUpdater {

    int MAXIMUM_QUALITY = 50;

    void update(Product product);
}
