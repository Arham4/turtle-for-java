package com.github.arham4.turtle;

/**
 * A complete line path, which is then incrementally drawn using {@link Line#draw(Screen, double, double)}.
 */
final class Line {
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;

    /**
     * A complete line path.
     *
     * @param x1 The starting x-coordinate.
     * @param y1 The starting y-coordinate.
     * @param x2 The ending x-coordinate of the complete line path.
     * @param y2 The ending y-coordinate of the complete line path.
     */
    Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }
}
