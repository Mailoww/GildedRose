package com.gildedrose.updater.product;

import com.gildedrose.adapter.ItemAdapterToProduct;
import com.gildedrose.model.Item;
import com.gildedrose.model.Product;
import com.gildedrose.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collection;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductsUpdaterPerDayTest {

    @Mock
    private
    ProductRepository productRepository;

    @Test
    public void update_should_get_products_from_repository() throws Exception {
        // GIVEN
        ProductsUpdaterPerDay productsUpdaterPerDay = new ProductsUpdaterPerDay(productRepository);
        // WHEN
        productsUpdaterPerDay.update();
        // THEN
        verify(productRepository).getProducts();
    }
}