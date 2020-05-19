package com.github.arham4.turtle;

/**
 * A sample application that makes a turtle make a shape given the amount of sides.
 */
public final class MakeAShape {
    public static void main(String[] args) {
        Screen screen = new Screen();
        screen.setup(400, 400);

        Turtle turtle = new Turtle(screen);
        turtle.shape("gnome.png");
        drawShape(turtle, 4);
        turtle.color("green");
        turtle.forward(100);
        drawShape(turtle, 4);
    }

    private static void drawShape(Turtle turtle, int sides) {
        for (int i = 0; i < sides; i++) {
            turtle.forward(100);
            turtle.left(360 / sides);
        }
    }
}
