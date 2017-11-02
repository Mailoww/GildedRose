package com.gildedrose;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import com.gildedrose.model.Item;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }


    @Test
    @Parameters({"Product lambda, 0, 1", "Product lambda other, -1, 1"})
    public void updateQuality_should_not_make_quality_negative(
            String productName, int sellIn, int quality) throws Exception {

        Item[] items = new Item[] { new Item(productName, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    @Parameters({"Product lambda, 4, 2","Product lambda other, 0, 3", "Product lambda, -2, 3"})
    public void updateQuality_should_decrement_quality_for_a_normal_product(
            String productName, int sellIn, int quality) throws Exception {

        Item[] items = new Item[] { new Item(productName, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(1);
    }

    @Test
    @Parameters({"Aged Brie, 0, 9", "Aged Brie, 10, 10", "Backstage passes to a TAFKAL80ETC concert, 12, 10"
            , "Backstage passes to a TAFKAL80ETC concert, 10, 9"
            , "Backstage passes to a TAFKAL80ETC concert, 5, 8"})
    public void updateQuality_should_increment_quality_when_aged_brie_or_backstage_passes_product(
            String productName, int sellIn, int quality) throws Exception {

        Item[] items = new Item[] { new Item(productName, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(11);
    }

    @Test
    @Parameters({"Backstage passes to a TAFKAL80ETC concert, 0, 8"
            , "Backstage passes to a TAFKAL80ETC concert, -3, 8"})
    public void updateQuality_should_make_quality_to_zero_when_product_is_backstage_passes(
            String productName, int sellIn, int quality) throws Exception {

        Item[] items = new Item[] { new Item(productName, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    @Parameters({"Sulfuras\\, Hand of Ragnaros, 0, 80"})
    public void updateQuality_should_not_change_sellIn_and_quality_when_is_a_legendary_product(
            String productName, int sellIn, int quality) throws Exception {

        Item[] items = new Item[] { new Item(productName, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(80);
        assertThat(app.items[0].sellIn).isEqualTo(0);
    }

    @Test
    @Parameters({"Aged Brie, 10, 50", "Backstage passes to a TAFKAL80ETC concert, 12, 50"
            , "Backstage passes to a TAFKAL80ETC concert, 10, 50"
            , "Backstage passes to a TAFKAL80ETC concert, 10, 49"
            , "Backstage passes to a TAFKAL80ETC concert, 5, 50"
            , "Backstage passes to a TAFKAL80ETC concert, 5, 48"})
    public void updateQuality_should_not_make_quality_upper_that_50(
            String productName, int sellIn, int quality) throws Exception {

        Item[] items = new Item[] { new Item(productName, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(50);
    }

}
