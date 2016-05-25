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


}
