package com.kata.taxes;

import java.math.BigDecimal;

import static com.kata.taxes.BigDecimalUtils.ZERO_PERCENT;
import static com.kata.taxes.BigDecimalUtils.FIVE_PERCENT;

/**
 * @author ALLOUM Abderrahim on 12/05/2020
 * @project Taxes-Kata
 */
public enum Origin {

    IMPORTED {
        @Override
        public BigDecimal getVATRate() {
            return FIVE_PERCENT;
        }
    },
    DOMESTIC {
        @Override
        public BigDecimal getVATRate() {
            return ZERO_PERCENT;
        }
    };

    public abstract BigDecimal getVATRate();
}
