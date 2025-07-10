package com.messanger.app.model;

import com.messanger.app.contsants.ShareType;

import java.math.BigDecimal;

public class Share {
    private Warith warith;
    private Fraction fraction;
    private BigDecimal amount;
    private ShareType type;


    public Share(Warith warith, Fraction fraction, BigDecimal amount, ShareType type) {
        this.amount = amount;
        this.warith = warith;
        this.fraction = fraction;
        this.type = type;
    }

    public void setFraction(Fraction fraction) {
        this.fraction = fraction;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setWarith(Warith warith) {
        this.warith = warith;
    }

    public void setType(ShareType type) {
        this.type = type;
    }


    public BigDecimal getAmount() {
        return amount;
    }

    public Fraction getFraction() {
        return fraction;
    }

    public Warith getWarith() {
        return warith;
    }

    public ShareType getType() {
        return type;
    }
}
