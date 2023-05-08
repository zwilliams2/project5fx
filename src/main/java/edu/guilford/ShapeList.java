package edu.guilford;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.TriangleMesh;

//shapelist is a list of shapes, so let's have it extends ArrayList<Shape>

public class ShapeList extends ArrayList<Shape> {
    // instantiate a random object
    private Random random = new Random();

    // method to return a random color with any possible value
    public Color getRandomColor() {
        // return a random color with any possible value
        // this returns a color with random values for red, green, blue and
        // alpha(opacity
        // between 0 and 1
        return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256), random.nextDouble());

    }
    // constructor to add random shap objects to the list

    public ShapeList() {
        // call the super constructor
        super();
        // add 10 random shapes to the list
        int nShapes = random.nextInt(40) + 10;
        for (int i = 0; i < 10; i++) {
            // add a random shape to the list
            this.add(getRandomShape());
        }

    }

    // method to return a random shape
    public Shape getRandomShape() {
        int shapeChoice = random.nextInt(4);
        switch (shapeChoice) {
            case 0:
                // circle needs a center x center y, radius, and color
                Circle circle = new Circle(random.nextInt(640), random.nextInt(480), random.nextInt(100),
                        getRandomColor());
                return circle;
            case 1:
                // generate a random rectangle
                Rectangle rectangle = new Rectangle(random.nextInt(640), random.nextInt(480), random.nextInt(100),
                        random.nextInt(100));
                // set the fill color to a random color
                rectangle.setFill(getRandomColor());
                return rectangle;
            case 2:
                // ellipse needs a center x, center y, radius x, radius y, and color
                Ellipse ellipse = new Ellipse(random.nextInt(640), random.nextInt(480), random.nextInt(100),
                        random.nextInt(100));
                // set the fill color to a random color
                ellipse.setFill(getRandomColor());
                return ellipse;

            case 3:

                // generate a random line
                Line line = new Line(random.nextInt(640), random.nextInt(480), random.nextInt(640),
                        random.nextInt(480));
                // set a stroke color to a random color
                line.setStroke(getRandomColor());
                // set a stroke width to a random value
                line.setStrokeWidth(random.nextInt(10) + 2);
                return line;
            default:
                // generate arandom polygon
                int nSides = random.nextInt(10) + 3;
                // create an array to hold the x coordinates
                double[] verticles = new double[nSides * 2];
                // fill the array with random x coordinates
                for (int i = 0; i < nSides * 2; i++) {
                    verticles[i] = random.nextDouble() * 800;
                }
                // new polygon object
                Polygon polygon = new Polygon(verticles);
                // set the fill color to a random color
                polygon.setFill(getRandomColor());
                return polygon;
        }
    }

    // add a toString method to return a string representation of the list
    @Override
    public String toString() {
        // go through the list and print out something relevant to each kind of shape
        StringBuilder s = new StringBuilder();
        // loop through the list
        // asking each kind of shape to do sothing and each shape respods in a different
        // way depending on what kind of shape it is, is called polymorphism
        // thing we're asking the shape to do is to add itself to the string

        for (Shape shape : this) {
            // add the shape to the string
            // s.append(shape.toString() + "\n");
            // use instanceof to determine what kind of shape we have
            if (shape instanceof Circle) {
                // tell java shape were looking at right now is a circle
                // cast the shape to a circle
                Circle circle = (Circle) shape;
                // add the circle to the string
                s.append("Circle: " + circle.getCenterX() + ", " + circle.getCenterY() + ", " + circle.getRadius()
                        + ", " + circle.getFill() + "\n");
            } else if (shape instanceof Rectangle) {
                // cast the shape to a rectangle
                Rectangle rectangle = (Rectangle) shape;
                // add the rectangle to the string
                s.append("Rectangle: " + rectangle.getX() + ", " + rectangle.getY() + ", " + rectangle.getWidth() + ", "
                        + rectangle.getHeight() + ", " + rectangle.getFill() + "\n");
            } else if (shape instanceof Ellipse) {
                // cast the shape to an ellipse
                Ellipse ellipse = (Ellipse) shape;
                // add the ellipse to the string
                s.append("Ellipse: " + ellipse.getCenterX() + ", " + ellipse.getCenterY() + ", " + ellipse.getRadiusX()
                        + ", " + ellipse.getRadiusY() + ", " + ellipse.getFill() + "\n");
            } else if (shape instanceof Line) {
                // cast the shape to a line
                Line line = (Line) shape;
                // add the line to the string
                s.append("Line: " + line.getStartX() + ", " + line.getStartY() + ", " + line.getEndX() + ", "
                        + line.getEndY() + ", " + line.getStroke() + ", " + line.getStrokeWidth() + "\n");
            } else if (shape instanceof Polygon) {
                // cast the shape to a polygon
                Polygon polygon = (Polygon) shape;
                // add the polygon to the string
                s.append("Polygon: " + polygon.getPoints() + ", " + polygon.getFill() + "\n");
            }
          
        }
          // return the string
          return s.toString();
    }
    // //return a string representation of the list
    // String string = "";
    // //loop through the list
    // for (Shape shape : this) {
    // //add the shape to the string
    // string += shape.toString() + "\n";
    // }
    // //return the string
    // return string;
}
