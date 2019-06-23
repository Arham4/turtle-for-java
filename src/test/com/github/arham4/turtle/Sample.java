package com.github.arham4.turtle;

/**
 * A sample application that makes a turtle make a square.
 */
public final class Sample {
    public static void main(String[] args) {
        Screen screen = new Screen();
        screen.setup(400, 400);

        Turtle turtle = new Turtle(screen);
        for (int i = 0; i < 4; i++) {
            turtle.forward(100);
            turtle.left(90);
        }
    }
}
