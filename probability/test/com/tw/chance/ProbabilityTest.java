package com.tw.chance;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class ProbabilityTest {

    @Test
    public void shouldBeEqualIfValueIsSame() throws Exception {
        Probability probability = new Probability(.5);
        assertThat(probability, is(new Probability(.5)));
        assertThat(new Probability(.5), is(probability));
    }

    @Test
    public void shouldBeEqualReflexively() throws Exception {
        Probability probability = new Probability(.5);
        assertThat(probability, is(probability));
    }

    @Test
    public void shouldBeEqualSymmetrically() throws Exception {
        Probability probabilityA = new Probability(.5);
        Probability probabilityB = new Probability(.5);

        assertThat(probabilityA, is(probabilityB));
        assertThat(probabilityB, is(probabilityA));
    }

    @Test
    public void shouldBeEqualTransitively() throws Exception {
        Probability probabilityA = new Probability(.5);
        Probability probabilityB = new Probability(.5);
        Probability probabilityC = new Probability(.5);

        assertThat(probabilityA, is(probabilityB));
        assertThat(probabilityB, is(probabilityC));
        assertThat(probabilityA, is(probabilityC));
    }

    @Test
    public void shouldNotBeEqualToNull() throws Exception {
        assertThat(new Probability(.3), not(equalTo(null)));
    }

    @Test
    public void shouldNegateTheProbabilityValueOnNot() throws Exception {
        assertThat(new Probability(.3).not(), is(new Probability(.7)));
    }

    @Test
    public void shouldBeTheOriginalProbabilityIfNegatedTwice() throws Exception {
        assertThat(new Probability(.3).not().not(), is(new Probability(.3)));
        assertThat(new Probability(.125).not().not(), is(new Probability(.125)));
    }

    @Test
    public void shouldAddProbabilityValuesInOROperation() throws Exception {
        assertThat(new Probability(.3).or(new Probability(.2)), is(new Probability(.44)));
        assertThat(new Probability(1).or(new Probability(.2)), is(new Probability(1)));
        assertThat(new Probability(.4).or(new Probability(1)), is(new Probability(1)));
        assertThat(new Probability(1).or(new Probability(1)), is(new Probability(1)));
        assertThat(new Probability(.75).or(new Probability(.25)), is(new Probability(.8125)));
    }

    @Test
    public void shouldMultiplyProbabilityValuesInAndOperation() throws Exception {
        assertThat(new Probability(.3).and(new Probability(.2)), is(new Probability(.06)));
        assertThat(new Probability(.3).and(new Probability(0)), is(new Probability(0)));
        assertThat(new Probability(0).and(new Probability(.4)), is(new Probability(0)));
    }
}
