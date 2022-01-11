package com.example.lab06_fractions;

public class Fraction {

    // These are called member variables
    private int numerator, denominator;

    // This is the Constructor, they don't return so there's no use of Void
    public Fraction()
    {
        numerator = 1;
        denominator = 1;
    }

    // This is also a constructor, but this one accepts
    // arguments (also called parameters).

    public Fraction(int n, int d)
    {
        numerator = n;
        denominator = d;
        reduce();
    }

    public int getNumerator()
    {
        return numerator;
    }

    public int getDenominator()
    {
        return denominator;
    }

    // This is a private "helper method"
    // Strip the sign off, and reduce the fraction, and put the sign back on.
    private void reduce()
    {
        int sign = 1;
        if (numerator < 0)
        { // numerator is negative
            sign *= -1; // records the sign
            numerator *= -1; // Make numerator positive
        }
        if (denominator < 0)
        { // denominator is negative
            sign *= -1;  // records the sign
            denominator *= -1; // Make numerator positive
        }

        for (int i = numerator; i > 1; i--)
        { // count backwards from numerator down to 2
            if (numerator % i == 0 && denominator % i == 0) // if its whole number, no remainder
            {
                // If this is true, found the biggest number on top and bottom
                // that is evenly divisible.
                numerator /= i; // numerator = numerator /i
                denominator /= i;
                break;
            }
        }

        numerator *= sign; // Put the sign back on the numerator
    }

    // Add two fraction objects
    public Fraction Add(Fraction fraction1, Fraction fraction2)
    {
        this.numerator = (fraction1.numerator * fraction2.denominator)
                          + (fraction2.numerator * fraction1.denominator);

        this.denominator = fraction1.denominator * fraction2.denominator;

        reduce();

        return this;
    }

    public Fraction Subtract(Fraction fraction1, Fraction fraction2)
    {
        this.numerator = (fraction1.numerator * fraction2.denominator)
                          - (fraction2.numerator * fraction1.denominator);

        this.denominator = fraction1.denominator * fraction2.denominator;

        reduce();

        return this;
    }

    public Fraction Multiply(Fraction fraction1, Fraction fraction2)
    {
        this.numerator = fraction1.numerator * fraction2.numerator;

        this.denominator = fraction1.denominator * fraction2.denominator;

        reduce();

        return this;
    }

    public Fraction Divide(Fraction fraction1, Fraction fraction2)
    {
        this.numerator = fraction1.numerator * fraction2.denominator;

        this.denominator = fraction1.denominator * fraction2.numerator;

        reduce();

        return this;
    }

    // Overriding built in method of toString
    public String toString()
    {
        return numerator + " / " + denominator;
    }

    public double toDecimal()
    {
        return (double)numerator / denominator;
    }

    // public double toDecimal() { return (double)numerator / denominator}
}
