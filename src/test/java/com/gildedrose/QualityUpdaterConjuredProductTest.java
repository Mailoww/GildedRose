package com.gildedrose;

import com.gildedrose.product.Item;
import com.gildedrose.product.ItemAdapterToProduct;
import com.gildedrose.product.Product;
import com.gildedrose.updater.product.QualityUpdaterConjuredProduct;
import com.gildedrose.updater.quality.QualityUpdater;
import org.junit.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class QualityUpdaterConjuredProductTest {

    @Test
    public void should_decrement_quality_of_2_when_product_is_not_expired() throws Exception {
        // GIVEN
        QualityUpdater qualityUpdater = new QualityUpdaterConjuredProduct();
        Item item =  new Item("Conjured Mana Cake", 3, 6);
        Collection<Product> product = ItemAdapterToProduct.convertToProduct(new Item[]{item});
        // WHEN
        qualityUpdater.update(product.iterator().next());
        // THEN
        assertThat(item.quality).isEqualTo(4);
    }

    @Test
    public void should_decrement_quality_of_4_when_product_is_expired() throws Exception {
        // GIVEN
        QualityUpdater qualityUpdater = new QualityUpdaterConjuredProduct();
        Item item =  new Item("Conjured Mana Cake", 0, 6);
        Collection<Product> product = ItemAdapterToProduct.convertToProduct(new Item[]{item});
        // WHEN
        qualityUpdater.update(product.iterator().next());
        // THEN
        assertThat(item.quality).isEqualTo(2);
    }
}
