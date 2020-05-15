package com.kata.taxes;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author ALLOUM Abderrahim on 13/05/2020
 * @project Taxes-Kata
 */
public class BigDecimalUtils {

    private static final BigDecimal ROUND = new BigDecimal("0.05");
    private static final BigDecimal REMINDER_ZERO = new BigDecimal("0.00");
    public static final BigDecimal ZERO_PERCENT = BigDecimal.ZERO;
    public static final BigDecimal FIVE_PERCENT = new BigDecimal("0.05");
    public static final BigDecimal TEN_PERCENT = new BigDecimal("0.1");
    public static final BigDecimal TWENTY_PERCENT = new BigDecimal("0.2");

    /***
     *
     * @param amount Taxe calculée
     * @return Taxe imputée
     */
    public static BigDecimal round(BigDecimal amount) {
        BigDecimal value = amount.setScale(2, RoundingMode.CEILING);
        BigDecimal reminder = value.remainder(ROUND);
        return reminder.equals(REMINDER_ZERO) ? value : value.add(ROUND.subtract(reminder));
    }

}
