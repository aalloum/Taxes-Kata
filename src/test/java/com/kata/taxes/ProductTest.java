package com.kata.taxes;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author ALLOUM Abderrahim on 15/05/2020
 * @project Taxes-Kata
 */
public class ProductTest {

    @Test
    public void testGetPriceOfAllTypesWithVAT() {

        Product books = new Product(2, "livre", ProductType.BOOK, Origin.DOMESTIC, new BigDecimal(12.49));
        Product cdMusical = new Product(1, "CD musical", ProductType.OTHER, Origin.DOMESTIC, new BigDecimal(14.99));
        Product chocolat = new Product(3, "barre de chocolat", ProductType.FOOD, Origin.DOMESTIC, new BigDecimal(0.85));

        assertThat(books.getPriceofAllTypesWithVAT()).isEqualTo(new BigDecimal("27.50"));
        assertThat(cdMusical.getPriceofAllTypesWithVAT()).isEqualTo(new BigDecimal("18.00"));
        assertThat(chocolat.getPriceofAllTypesWithVAT()).isEqualTo(new BigDecimal("2.55"));

        assertThat(books.toString()).isEqualTo("* 2 livre à 12.50€ : 27.50€ TTC");
        assertThat(cdMusical.toString()).isEqualTo("* 1 CD musical à 15.00€ : 18.00€ TTC");
        assertThat(chocolat.toString()).isEqualTo("* 3 barre de chocolat à 0.85€ : 2.55€ TTC");
    }

}
