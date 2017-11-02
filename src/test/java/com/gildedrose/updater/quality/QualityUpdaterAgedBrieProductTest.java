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
public class QualityUpdaterAgedBrieProductTest {

    @Test
    public void should_increment_quality_of_1_when_product_is_not_expired() throws Exception {
        // GIVEN
        QualityUpdater qualityUpdater = new QualityUpdaterAgedBrieProduct();
        Item item =  new Item("AgedBrie", 3, 6);
        Collection<Product> product = ItemAdapterToProduct.convertToProduct(new Item[]{item});
        // WHEN
        qualityUpdater.update(product.iterator().next());
        // THEN
        assertThat(item.quality).isEqualTo(7);
    }

    @Test
    public void should_increment_quality_of_2_when_product_is_expired() throws Exception {
        // GIVEN
        QualityUpdater qualityUpdater = new QualityUpdaterAgedBrieProduct();
        Item item =  new Item("Conjured Mana Cake", 0, 6);
        Collection<Product> product = ItemAdapterToProduct.convertToProduct(new Item[]{item});
        // WHEN
        qualityUpdater.update(product.iterator().next());
        // THEN
        assertThat(item.quality).isEqualTo(8);
    }

    @Test
    @Parameters({"Aged Brie, 0, 49", "Aged Brie, 2, 50"})
    public void should_quality_not_be_higher_fifty(
            String name, int sellIn, int quality) throws Exception {
        // GIVEN
        QualityUpdater qualityUpdater = new QualityUpdaterAgedBrieProduct();
        Item item =  new Item(name, sellIn, quality);
        Collection<Product> product = ItemAdapterToProduct.convertToProduct(new Item[]{item});
        // WHEN
        qualityUpdater.update(product.iterator().next());
        // THEN
        assertThat(item.quality).isEqualTo(50);
    }

}