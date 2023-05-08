package edu.guilford;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class ShapeDriver extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        //instantiate a new ShapePane object
        //shapePane is where we draw the shape
        ShapePane shapePane = new ShapePane();
        //shapeList is where we build the list of shapes we'll draw
        //instantiate a ShapList object
        ShapeList shapeList = new ShapeList();
        //instantiate the scene
        scene = new Scene(shapePane, 640, 480);
        //add all the shapes in the shapeList to the shapePane
        for (int i = 0; i < shapeList.size(); i++) {
            shapePane.addShape(shapeList.get(i));
        }
        stage.setScene(scene);
        stage.show();
        System.out.println(shapeList);
    }


    public static void main(String[] args) {
        launch();
    }

}