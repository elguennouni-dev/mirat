package com.messanger.app.model;

import com.messanger.app.exception.InvalidDebtException;
import com.messanger.app.exception.InvalidWasiyaException;
import com.messanger.app.exception.InvalidWealthException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Tarika {
    BigDecimal totalWealth;
    BigDecimal debts;
    BigDecimal wasiya; // <= 1/3
    BigDecimal funeralCosts;


    public Tarika(BigDecimal totalWealth, BigDecimal debts, BigDecimal wasiya, BigDecimal funeralCosts)
            throws InvalidWasiyaException, InvalidWealthException, InvalidDebtException {

        if (totalWealth.intValue() < 0) throw new InvalidWealthException();
        if (debts.intValue() < 0) throw new InvalidDebtException();
        if (funeralCosts.intValue() < 0) throw new RuntimeException("Invalid Funeral Cost");

        BigDecimal oneThird = totalWealth.divide(BigDecimal.valueOf(3), 10, RoundingMode.HALF_UP);

        if (wasiya.compareTo(BigDecimal.ZERO) < 0 || wasiya.compareTo(oneThird) > 0)
            throw new InvalidWasiyaException();

        this.totalWealth = totalWealth;
        this.debts = debts;
        this.wasiya = wasiya;
        this.funeralCosts = funeralCosts;
    }


    public BigDecimal getTotalWealth() {
        return totalWealth;
    }

    public BigDecimal getDebts() {
        return debts;
    }

    public BigDecimal getWasiya() {
        return wasiya;
    }

    public BigDecimal getFuneralCosts() {
        return funeralCosts;
    }


    private void setTotalWealth(BigDecimal totalWealth) {
        this.totalWealth = totalWealth;
    }

    private void setDebts(BigDecimal debts) {
        this.debts = debts;
    }

    private void setWasiya(BigDecimal wasiya) {
        this.wasiya = wasiya;
    }

    private void setFuneralCosts(BigDecimal funeralCosts) {
        this.funeralCosts = funeralCosts;
    }

}
