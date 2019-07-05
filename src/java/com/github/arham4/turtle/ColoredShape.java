package com.github.arham4.turtle;

import java.awt.*;

final class ColoredShape {
    private final Shape shape;
    private final Color color;

    ColoredShape(Shape shape, Color color) {
        this.shape = shape;
        this.color = color;
    }

    public Shape getShape() {
        return shape;
    }

    public Color getColor() {
        return color;
    }
}
