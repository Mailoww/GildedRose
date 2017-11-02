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
public class QualityUpdaterNormalProductTest {

    @Test
    public void should_decrement_quality_of_1_when_product_is_not_expired() throws Exception {
        // GIVEN
        QualityUpdater qualityUpdater = new QualityUpdaterNormalProduct();
        Item item =  new Item("Lambda Product", 3, 6);
        Collection<Product> product = ItemAdapterToProduct.convertToProduct(new Item[]{item});
        // WHEN
        qualityUpdater.update(product.iterator().next());
        // THEN
        assertThat(item.quality).isEqualTo(5);
    }

    @Test
    public void should_decrement_quality_of_2_when_product_is_expired() throws Exception {
        // GIVEN
        QualityUpdater qualityUpdater = new QualityUpdaterNormalProduct();
        Item item =  new Item("Lambda Product", 0, 6);
        Collection<Product> product = ItemAdapterToProduct.convertToProduct(new Item[]{item});
        // WHEN
        qualityUpdater.update(product.iterator().next());
        // THEN
        assertThat(item.quality).isEqualTo(4);
    }

    @Test
    @Parameters({"Lambda Product, 0, 1", "Lambda Product, 2, 0"})
    public void should_quality_not_be_under_zero(
            String name, int sellIn, int quality) throws Exception {
        // GIVEN
        QualityUpdater qualityUpdater = new QualityUpdaterNormalProduct();
        Item item =  new Item(name, sellIn, quality);
        Collection<Product> product = ItemAdapterToProduct.convertToProduct(new Item[]{item});
        // WHEN
        qualityUpdater.update(product.iterator().next());
        // THEN
        assertThat(item.quality).isEqualTo(0);
    }

}