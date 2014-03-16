package com.hamster.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

@Embeddable
public class Amount implements Serializable, Comparable<Amount> {

	private static final long serialVersionUID = 1L;

	private static final int FRACTION_MAXLENGTH = 2;

	@Column(name="AMOUNT_VALUE")
    private final BigDecimal calculationValue;
	@Transient
    private final BigDecimal userValue;
	@Column(name="AMOUNT_CURRENCY")
    private final Currency currency;
    @Transient
    private long[] values;

    public Amount() {
    	this(BigDecimal.ZERO, Currency.getInstance(Locale.getDefault()));
    }
    
    public Amount(final BigDecimal value, Currency currency) {
        Preconditions.checkNotNull(value);
        this.userValue = value.setScale(2, RoundingMode.HALF_EVEN);
        this.calculationValue = value.setScale(6, RoundingMode.HALF_EVEN);
        this.currency = Preconditions.checkNotNull(currency);
    }

    public boolean isSign() {
        return calculationValue.compareTo(BigDecimal.ZERO) >= 0;
    }

    public boolean isEmpty() {
        return calculationValue.compareTo(BigDecimal.ZERO) == 0;
    }

    public long getInteger() {
        return getValues()[0];
    }

    public long getFraction() {
        return getValues()[1];
    }

    private static String getFormattedFraction(String fraction) {
        return StringUtils.leftPad(fraction, FRACTION_MAXLENGTH, '0');
    }

    public String getFormattedFraction() {
        return getFormattedFraction(Long.toString(getFraction()));
    }

    public Currency getCurrency() {
        return currency;
    }

    public String getCurrencyCode() {
        return currency.getCurrencyCode();
    }

    public BigDecimal getValue() {
        return calculationValue;
    }

    public BigDecimal getUserValue() {
        return userValue;
    }

    public double getDoubleValue() {
        return userValue.doubleValue();
    }

    private long[] getValues() {
        if (values == null) {
            values = split(userValue);
        }
        return values;
    }

    private long[] split(BigDecimal value) {
        BigDecimal integer = new BigDecimal((long) value.doubleValue());
        return new long[] { 
                integer.longValue(),
                value.add(integer.negate()).movePointRight(2).longValue(), 
        };
    }

    public int compareTo(Amount o) {
        if (o == null) {
            return 1;
        }
        if (!currency.equals(o.getCurrency())) {
            throw new IllegalArgumentException("It's impossible to compare amounts with different currencies.");
        }
        return userValue.compareTo(o.getUserValue());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(currency, userValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Amount)) {
            return false;
        }
        Amount other = (Amount) obj;
        return Objects.equal(currency, other.currency)
                && Objects.equal(userValue, other.userValue);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                        .addValue(userValue)
                        .addValue(calculationValue)
                        .addValue(currency)
                            .toString();
    }

    public static boolean isEmpty(Amount amount) {
        return amount == null || amount.isEmpty();
    }

    public static Amount copy(Amount amount) {
        return copy(amount, true);
    }

    public static Amount copy(Amount amount, boolean create) {
        if (!create) {
            return amount;
        }
        if (amount == null) {
            return null;
        }
        return new Amount(amount.getValue(), amount.getCurrency());
    }

    public static Amount create(Currency currency) {
        return create(0D, currency);
    }

    public static Amount create(long integer, long fraction, Currency currency) {
        return create(
                integer + "." + getFormattedFraction(Long.toString(fraction)),
                currency);
    }

    public static Amount create(String integer, String fraction, Currency currency) {
        return create(Objects.firstNonNull(integer, "0") + "."
                        + getFormattedFraction(Objects.firstNonNull(fraction, "0")),
                        currency);
    }

    public static Amount create(String value, Currency currency) {
        return create(Double.parseDouble(value), currency);
    }

    public static Amount create(double value, Currency currency) {
        return create(BigDecimal.valueOf(value), currency);
    }

    public static Amount create(BigDecimal value, Currency currency) {
        if (currency == null) {
            throw new IllegalArgumentException(
                    "Amount's currency cann't be null");
        }
        return new Amount(value, currency);
    }

    public static Amount add(Amount a1, Amount a2) {
        return add(a1, a2, true);
    }

    public static Amount add(Amount a1, Amount a2, boolean create) {
        if (a1 == null) {
            return copy(a2);
        }
        if (a2 == null) {
            return copy(a1, create);
        }
        if (!a1.getCurrency().equals(a2.getCurrency())) {
            throw new IllegalArgumentException("This operation doesn't support different currencies");
        }
        return new Amount(a1.getValue().add(a2.getValue()), a1.getCurrency());
    }

    public static Amount reduce(Amount a1, Amount a2) {
        if (a1 == null) {
            throw new IllegalArgumentException("It's impossible to make reducing when first argument is null");
        }
        if (a2 == null) {
            return copy(a1);
        }
        if (!a1.getCurrency().equals(a2.getCurrency())) {
            throw new IllegalArgumentException("This operation doesn't support different currencies");
        }
        return new Amount(a1.getValue().add(a2.getValue().negate()), a1.getCurrency());
    }

    public static Amount multiply(Amount a, double value) {
        return multiply(a, BigDecimal.valueOf(value));
    }

    public static Amount multiply(Amount a, BigDecimal value) {
        if (a == null) {
            return null;
        }
        return create(a.getValue().multiply(value), a.getCurrency());
    }

}
