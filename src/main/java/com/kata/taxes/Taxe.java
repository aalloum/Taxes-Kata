package com.kata.taxes;

import java.math.BigDecimal;

/**
 * @author ALLOUM Abderrahim on 12/05/2020
 * @project Taxes-Kata
 */
public class Taxe {

    private BigDecimal price;
    private BigDecimal rate;
    private BigDecimal importedRate;

    public Taxe(BigDecimal price, BigDecimal rate, BigDecimal importedRate) {
        this.price = price;
        this.rate = rate;
        this.importedRate = importedRate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public BigDecimal getImportedRate() {
        return importedRate;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public void setImportedRate(BigDecimal importedRate) {
        this.importedRate = importedRate;
    }

    /***
     *
     * @return Taxe
     */
    public BigDecimal getTaxeOfOneProduct() {
        return price.multiply(rate)
                .add(price.multiply(importedRate));
    }


}
