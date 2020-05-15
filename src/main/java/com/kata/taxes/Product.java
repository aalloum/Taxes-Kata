package com.kata.taxes;

import java.math.BigDecimal;

import static com.kata.taxes.BigDecimalUtils.round;

/**
 * @author ALLOUM Abderrahim on 12/05/2020
 * @project Taxes-Kata
 */
public class Product {

    private int quantity;
    private String name;
    private ProductType productType;
    private Origin origin;
    private BigDecimal price;

    public Product(int quantity, String name, ProductType productType, Origin origin, BigDecimal price) {
        this.quantity = quantity;
        this.name = name;
        this.productType = productType;
        this.origin = origin;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public ProductType getProductType() {
        return productType;
    }

    public Origin getOrigin() {
        return origin;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    /***
     *
     * @return Price_Of_All_Types_With_VAT
     */
    public BigDecimal getPriceofAllTypesWithVAT() {
        BigDecimal priceTotal = price.multiply(new BigDecimal(quantity));
        return round(priceTotal).add(getVATProductsByType());
    }

    /***
     *
     * @return VAT_Products_By_Type
     */
    public BigDecimal getVATProductsByType() {
        Taxe taxe = new Taxe(price, productType.getVATRate(), origin.getVATRate());
        BigDecimal rateVATOfProducts = taxe.getTaxeOfOneProduct().multiply(new BigDecimal(quantity));
        return round(rateVATOfProducts);
    }

    @Override
    public String toString() {
        return "* " + getQuantity() + " " + getName() + " à " + round(getPrice()) + "€ : " + getPriceofAllTypesWithVAT() + "€ TTC";
    }
}
