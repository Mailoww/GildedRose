package com.gildedrose.updater.quality;

import com.gildedrose.adapter.ItemAdapterToProduct;
import com.gildedrose.model.Item;
import com.gildedrose.model.Product;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class QualityUpdaterSulfurasProductTest {

    @Test
    @Parameters({"Sulfuras\\, Hand of Ragnaros, 0, 80"})
    public void should_not_change_quality_and_sell_in(
            String name, int sellIn, int quality) throws Exception {
        // GIVEN
        QualityUpdater qualityUpdater = new QualityUpdaterSulfurasProduct();
        Item item =  new Item(name, sellIn, quality);
        Collection<Product> product = ItemAdapterToProduct.convertToProduct(new Item[]{item});
        // WHEN
        qualityUpdater.update(product.iterator().next());
        // THEN
        assertThat(item.quality).isEqualTo(80);
        assertThat(item.sellIn).isEqualTo(0);
    }
}