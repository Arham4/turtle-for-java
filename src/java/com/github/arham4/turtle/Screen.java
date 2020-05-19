package com.github.arham4.turtle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Screen} to display all entities on. Without a screen, a Turtle program cannot exist. Thus, it is essential
 * to make a screen at the beginning of every Turtle program.
 */
public final class Screen extends JPanel implements KeyListener {

    private int width = 200;
    private int height = 200;
    private final List<Turtle> turtleList = new ArrayList<>();

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.translate(width / 2, height / 2);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.scale(1, -1);
        for (Turtle turtle : turtleList) {
            AffineTransform origin = (AffineTransform) graphics2D.getTransform().clone();
            origin.setToTranslation(0, 0);
            graphics2D.drawImage(turtle.getLinesBuffer(), origin, this);

            BufferedImage shape = turtle.getShape();
            if (shape != null) {
                double angle = Math.toRadians(turtle.getAngle());
                AffineTransform trans = (AffineTransform) graphics2D.getTransform().clone();
                trans.setToTranslation(turtle.getX() - (Math.cos(angle) * (shape.getWidth() / 2.0) - ((shape.getHeight() / 2.0) * Math.sin(angle))),
                        turtle.getY() - (Math.sin(angle) * (shape.getHeight() / 2.0)) - ((shape.getWidth() / 2.0) * Math.cos(angle)));
                trans.rotate(angle);
                graphics2D.drawImage(shape, trans, this);
            }
        }
        graphics2D.dispose();
    }

    /**
     * Sets up the Graphical User Interface to make a canvas in which entities are displayed.
     *
     * @param width  The width of the display screen.
     * @param height The height of the display screen.
     * @apiNote This method is overloaded.
     * @see Screen#setup(String, int, int)
     */
    public void setup(int width, int height) {
        setup("Turtle", width, height);
    }

    /**
     * Sets up the Graphical User Interface to make a canvas in which entities are displayed.
     *
     * @param title  The title of the Graphic User Interface window.
     * @param width  The width of the display screen.
     * @param height The height of the display screen.
     * @apiNote This method is overloaded.
     * @see Screen#setup(int, int)
     */
    public void setup(String title, int width, int height) {
        this.width = width;
        this.height = height;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.setTitle(title);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.addKeyListener(this);
    }

    /**
     * Refreshes the frame synchronously to the screen. The drawing thread sleeps for 10 milliseconds
     * and then proceeds to redraw the screen.
     */
    public void refreshFrame() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    /**
     * Adds a {@link Turtle} to be displayed on this {@code Screen}.
     *
     * @param turtle The {@link Turtle} to add.
     */
    public void addTurtle(Turtle turtle) {
        turtleList.add(turtle);
        turtle.setScreen(this);
        refreshFrame();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        for (Turtle turtle : turtleList) {
            turtle.keyTyped(e);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        for (Turtle turtle : turtleList) {
            turtle.keyPressed(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        for (Turtle turtle : turtleList) {
            turtle.keyReleased(e);
        }
    }
}
