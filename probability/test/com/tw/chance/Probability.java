package com.tw.chance;

//Understands a measure of occurrence of an event
public class Probability {
    private static final int CERTAINTY = 1;
    private final double likelihood;

    public Probability(double likelihood) {
        this.likelihood = likelihood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Probability that = (Probability) o;

        if (Double.compare(that.likelihood, likelihood) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(likelihood);
        return (int) (temp ^ (temp >>> 32));
    }

    public Probability not() {
        return new Probability(round(CERTAINTY - likelihood));
    }

    private double round(double value) {
        return Math.round(value * 10000.0 ) / 10000.0;
    }

    // DeMorgan's law
    public Probability or(Probability other) {
        return this.not().and(other.not()).not();
    }

    public Probability and(Probability other) {
        return new Probability(round(this.likelihood * other.likelihood));
    }
}
