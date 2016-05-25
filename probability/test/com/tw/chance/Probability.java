package com.tw.chance;

//Understands a measure of occurrence of an event
public class Probability {
    private static final int CERTAINTY = 1;
    private final double value;

    public Probability(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Probability that = (Probability) o;

        if (Double.compare(that.value, value) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(value);
        return (int) (temp ^ (temp >>> 32));
    }

    public Probability not() {
        return new Probability(Math.round( (CERTAINTY - value) * 10000.0 ) / 10000.0);
    }
}
