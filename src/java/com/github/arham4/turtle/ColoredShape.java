package com.github.arham4.turtle;

import java.awt.*;

final class ColoredShape {
    private final Shape shape;
    private final Color color;

    ColoredShape(Shape shape, Color color) {
        this.shape = shape;
        this.color = color;
    }

    /**
     * Gets the {@link Shape} of the {@code ColoredShape}.
     *
     * @return The {@link Shape}.
     */
    public Shape getShape() {
        return shape;
    }

    /**
     * Gets the {@link Color} that this shape is colored.
     * @return The {@link Color} of the shape.
     */
    public Color getColor() {
        return color;
    }
}
