package com.kata.taxes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.joining;

/**
 * @author ALLOUM Abderrahim on 12/05/2020
 * @project Taxes-Kata
 */
public class Facture {

    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public Facture add(Product product) {
        products.add(requireNonNull(product));
        return this;
    }

    /***
     *
     * @return Total_VAT_Of_All_Products_In_Invoice
     */
    public BigDecimal getTotalVAT() {
        return products.stream().map(Product::getVATProductsByType).reduce(BigDecimal::add).get();
    }

    /***
     *
     * @return Total_Final_Price_Of_All_Products_In_Invoice
     */
    public BigDecimal getTotalAmountWithVAT() {
        return products.stream().map(Product::getPriceofAllTypesWithVAT).reduce(BigDecimal::add).get();
    }

    public String toString() {
        return new StringJoiner("\n")
                .add(products.stream().map(Product::toString).collect(joining("\n")))
                .add("Montant des taxes : " + getTotalVAT() + "€")
                .add("Total : " + getTotalAmountWithVAT() + "€")
                .toString();
    }
}
