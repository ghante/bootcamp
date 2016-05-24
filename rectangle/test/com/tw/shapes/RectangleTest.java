package com.tw.shapes;

import com.tw.shapes.exceptions.InvalidInput;
import org.junit.Test;

import static com.tw.shapes.Rectangle.rectangle;
import static com.tw.shapes.Rectangle.square;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RectangleTest {

    @Test
    public void shouldCalculateAreaAs20IfLengthIs5AndWidthIs4() throws InvalidInput {
        assertThat(rectangle(5, 4).area(), is(20));
    }

    @Test
    public void shouldCalculateAreaOfASquareWithSideOf5As25() throws InvalidInput {
        assertThat(square(5).area(), is(25));
    }

    @Test(expected = InvalidInput.class)
    public void shouldNotCreateRectangleForNegativeLength() throws InvalidInput {
        rectangle(-5, 4);
    }

    @Test(expected = InvalidInput.class)
    public void shouldNotCreateRectangleForNegativeWidth() throws InvalidInput {
        rectangle(-5, 4);
    }

    @Test(expected = InvalidInput.class)
    public void shouldNotCreateRectangleForNegativeLengthAndWidth() throws InvalidInput {
        rectangle(-5, -4);
    }

    @Test(expected = InvalidInput.class)
    public void shouldNotCreateSquareOfNegativeSide() throws InvalidInput {
        square(-5);
    }

}
