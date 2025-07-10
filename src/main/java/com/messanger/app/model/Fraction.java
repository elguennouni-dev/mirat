package com.messanger.app.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new ArithmeticException("Denominator cannot be zero");
        int gcd = gcd(numerator, denominator);
        int num = numerator / gcd;
        int den = denominator / gcd;

        if (den < 0) {
            num *= -1;
            den *= -1;
        }

        this.numerator = num;
        this.denominator = den;
    }

    public static Fraction of(int num, int den) {
        return new Fraction(num, den);
    }

    public Fraction add(Fraction other) {
        int num = this.numerator * other.denominator + other.numerator * this.denominator;
        int den = this.denominator * other.denominator;
        return new Fraction(num, den);
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    public Fraction simplify() {
        int gcd = gcd(numerator, denominator);
        return new Fraction(numerator / gcd, denominator / gcd);
    }

    public int compareTo(Fraction other) {
        return Integer.compare(this.numerator * other.denominator, other.numerator * this.denominator);
    }

    public BigDecimal toDecimal(int scale) {
        return BigDecimal.valueOf(numerator)
                .divide(BigDecimal.valueOf(denominator), scale, RoundingMode.HALF_UP);
    }

    public boolean isGreaterThanOne() {
        return numerator > denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Fraction)) return false;
        Fraction other = (Fraction) obj;
        return this.numerator * other.denominator == other.numerator * this.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    private int gcd(int a, int b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcdStatic(a, b);
    }

    private static int gcdStatic(int a, int b) {
        return b == 0 ? Math.abs(a) : gcdStatic(b, a % b);
    }
}
