package com.github.arham4.turtle;

/**
 * A {@code Turtle} entity. A turtle is essentially a character that can be manipulated to perform actions on a screen,
 * such as movement and changes in its appearance.
 */
public final class Turtle {
    private final Screen screen;
    private double x;
    private double y;
    private double angle;

    /**
     * Creates a turtle.
     *
     * @param screen The {@link Screen} to add this turtle to.
     */
    public Turtle(Screen screen) {
        this.screen = screen;
        x = 0;
        y = 0;
        angle = 0;
    }

    /**
     * Makes a turtle go to a certain coordinate point.
     *
     * @param x The x-coordinate for the turtle to go to.
     * @param y THe y-coordinate for the turtle to go to.
     */
    public void goTo(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Makes a turtle move forward with respect to its current angle that it is facing.
     *
     * @param amount The distance for the turtle to move. This number is taken and then multiplied with the cosine
     *               of the angle at which the turtle is currently facing for the x distance and done the same
     *               for the y-position, using sine instead.
     */
    public void forward(double amount) {
        double endX = x + (Math.cos(Math.toRadians(angle)) * amount);
        double endY = y + (Math.sin(Math.toRadians(angle)) * amount);
        if (screen != null) {
            Line line = new Line(x, y, endX, endY);
            line.draw(screen, 3, angle);
        }
        x = endX;
        y = endY;
    }

    /**
     * Turns a turtle right.
     *
     * @param angle The angle at which to turn the turtle.
     */
    public void right(double angle) {
        changeAngle(-angle);
    }

    /**
     * Turns a turtle left.
     *
     * @param angle The angle at which to turn the turtle.
     */
    public void left(double angle) {
        changeAngle(angle);
    }

    /**
     * Changes the angle the turlte is facing. This method ensures the angle remains in the range [0, 360).
     *
     * @param angle The angle at which the current angle is being modified.
     */
    private void changeAngle(double angle) {
        double newAmount = this.angle + angle;
        if (newAmount < 0) {
            this.angle = 360 - (Math.abs(angle) - this.angle);
        } else if (newAmount >= 360) {
            this.angle = (this.angle + Math.abs(angle)) - 360;
        } else {
            this.angle += angle;
        }
    }
}
