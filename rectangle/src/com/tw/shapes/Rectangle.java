package com.tw.shapes;

import com.tw.shapes.exceptions.InvalidInput;

//Defines a quadrilateral of equal angles
public class Rectangle {
    private final int length;
    private final int width;

    private Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public static Rectangle rectangle(int length, int width) throws InvalidInput {
        validate(length, width);
        return new Rectangle(length, width);
    }

    private static void validate(int length, int width) throws InvalidInput {
        if (length < 0 || width < 0) {
            throw new InvalidInput();
        }
    }

    public static Rectangle square(int side) throws InvalidInput {
        validate(side, side);
        return new Rectangle(side, side);
    }

    public int area() {
        return length * width;
    }

}
