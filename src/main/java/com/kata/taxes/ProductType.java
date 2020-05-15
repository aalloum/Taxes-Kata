package com.kata.taxes;

import java.math.BigDecimal;

import static com.kata.taxes.BigDecimalUtils.ZERO_PERCENT;
import static com.kata.taxes.BigDecimalUtils.TEN_PERCENT;
import static com.kata.taxes.BigDecimalUtils.TWENTY_PERCENT;

/**
 * @author ALLOUM Abderrahim on 12/05/2020
 * @project Taxes-Kata
 */
public enum ProductType {

    FOOD {
        @Override
        public BigDecimal getVATRate() {
            return ZERO_PERCENT;
        }
    },
    DRUG {
        @Override
        public BigDecimal getVATRate() {
            return ZERO_PERCENT;
        }
    },
    BOOK {
        @Override
        public BigDecimal getVATRate() {
            return TEN_PERCENT;
        }
    },
    OTHER {
        @Override
        public BigDecimal getVATRate() {
            return TWENTY_PERCENT;
        }
    };

    public abstract BigDecimal getVATRate();
}
