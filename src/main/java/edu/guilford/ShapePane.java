package edu.guilford;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

//Shapepane will extend Pane because we want exact control over where swe place the 
//graphics objects we'll be drawing

public class ShapePane extends Pane {

    //shapPane does everything Pane does

    //constructor: this constructor essentiallly overrides the pane default constructor
    public ShapePane() {
        //when a class extends another class, the first cline should be asking 
        //the superclass to run its constructor

        //call the super constructor
        super();//this refers to the current object; *super* refers to superclass
    }

    //add a shape to the pane
    public void addShape(Shape shape) {
        //add the shape to the pane
        this.getChildren().add(shape);
    }
    //remove a shape from the pane
    public void removeShape(Shape shape) {
        //remove the shape from the pane
        this.getChildren().remove(shape);
    }
    //clear all shapes from the pane
    public void clearShapes() {
        //clear all shapes from the pane
        this.getChildren().clear();
    }

}
