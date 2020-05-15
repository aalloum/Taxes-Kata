package com.kata.taxes;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author ALLOUM Abderrahim on 15/05/2020
 * @project Taxes-Kata
 */
public class BigDecimalUtilsTest {

    private BigDecimalUtils bigDecimalUtils = new BigDecimalUtils();

    @Test
    public void should_return_round_value() {
        assertThat(bigDecimalUtils.round(new BigDecimal("0.99"))).isEqualTo(new BigDecimal("1.00"));
        assertThat(bigDecimalUtils.round(new BigDecimal("1.00"))).isEqualTo(new BigDecimal("1.00"));
        assertThat(bigDecimalUtils.round(new BigDecimal("1.01"))).isEqualTo(new BigDecimal("1.05"));
        assertThat(bigDecimalUtils.round(new BigDecimal("1.02"))).isEqualTo(new BigDecimal("1.05"));
    }

}
