package com.kata.taxes;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author ALLOUM Abderrahim on 15/05/2020
 * @project Taxes-Kata
 */
public class FactureTest {

    private Facture facture = new Facture();

    @Test
    public void testFactureToStringInput1() {

        Product books = new Product(2, "livre", ProductType.BOOK, Origin.DOMESTIC, new BigDecimal(12.49));
        Product cdMusical = new Product(1, "CD musical", ProductType.OTHER, Origin.DOMESTIC, new BigDecimal(14.99));
        Product chocolat = new Product(3, "barre de chocolat", ProductType.FOOD, Origin.DOMESTIC, new BigDecimal(0.85));
        facture.getProducts().add(books);
        facture.getProducts().add(cdMusical);
        facture.getProducts().add(chocolat);

        String output1 = "* 2 livre à 12.50€ : 27.50€ TTC\n" +
                "* 1 CD musical à 15.00€ : 18.00€ TTC\n" +
                "* 3 barre de chocolat à 0.85€ : 2.55€ TTC\n" +
                "Montant des taxes : 5.50€\n" +
                "Total : 48.05€";

        assertThat(facture.toString()).isEqualTo(output1);
    }

    @Test
    public void testFactureToStringInput2() {

        Product chocolatImported = new Product(2, "boîtes de chocolats", ProductType.FOOD, Origin.IMPORTED, new BigDecimal(10.0));
        Product parfumImported = new Product(3, "flacons de parfum", ProductType.OTHER, Origin.IMPORTED, new BigDecimal(47.50));
        facture.getProducts().add(chocolatImported);
        facture.getProducts().add(parfumImported);

        String output2 = "* 2 boîtes de chocolats à 10.00€ : 21.00€ TTC\n" +
                "* 3 flacons de parfum à 47.50€ : 178.15€ TTC\n" +
                "Montant des taxes : 36.65€\n" +
                "Total : 199.15€";

        assertThat(facture.toString()).isEqualTo(output2);
    }

    @Test
    public void testFactureToStringInput3() {
        Product parfumImported = new Product(2, "flacons de parfum ", ProductType.OTHER, Origin.IMPORTED, new BigDecimal(27.99));
        Product parfumDomestic = new Product(1, "flacons de parfum ", ProductType.OTHER, Origin.DOMESTIC, new BigDecimal(18.99));
        Product pilulesDomestic = new Product(3, "boîtes de pilules contre la migraine", ProductType.DRUG, Origin.DOMESTIC, new BigDecimal(9.75));
        Product chocolatImported = new Product(2, "boîtes de chocolats", ProductType.FOOD, Origin.IMPORTED, new BigDecimal(11.25));
        facture.getProducts().add(parfumImported);
        facture.getProducts().add(parfumDomestic);
        facture.getProducts().add(pilulesDomestic);
        facture.getProducts().add(chocolatImported);

        String output3 = "* 2 flacons de parfum  à 28.00€ : 70.00€ TTC\n" +
                "* 1 flacons de parfum  à 19.00€ : 22.80€ TTC\n" +
                "* 3 boîtes de pilules contre la migraine à 9.75€ : 29.25€ TTC\n" +
                "* 2 boîtes de chocolats à 11.25€ : 23.65€ TTC\n" +
                "Montant des taxes : 18.95€\n" +
                "Total : 145.70€";

        assertThat(facture.toString()).isEqualTo(output3);
    }
}
