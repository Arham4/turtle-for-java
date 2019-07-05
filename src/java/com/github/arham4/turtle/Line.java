package com.github.arham4.turtle;

final class Line {
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;

    Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /**
     * Gets the starting x-coordinate of the line.
     *
     * @return The starting x-coordinate of the line.
     */
    public double getX1() {
        return x1;
    }

    /**
     * Gets the starting y-coordinate of the line.
     * @return The starting y-coordinate of the line.
     */
    public double getY1() {
        return y1;
    }

    /**
     * Gets the ending x-coordinate of the line.
     * @return The ending x-coordinate of the line.
     */
    public double getX2() {
        return x2;
    }

    /**
     * Gets the ending y-coordinate of the line.
     * @return The ending y-coordinate of the line.
     */
    public double getY2() {
        return y2;
    }
}
