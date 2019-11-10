package map;



import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.GameController;
import sample.GameField;

import java.io.*;
import java.util.Scanner;

public final class runMap extends Application {
    public static void main(String[] args) {
        Application.launch(args);

    }

    @Override
    public void start(Stage primaryStage){
        double width = 640;
        double height = 576;

        Image image = new Image("graphics/BrickTile.png");
        Image sandTile = new Image("graphics/SandTile.png");
        Canvas canvas = new Canvas(width,height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(image,0,0,32,32);
//        try{
//            draw(gc);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        draw(gc);
        Scene scene = new Scene(new Group(canvas));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Tower Defenese");
        primaryStage.show();
    }
    public void draw(GraphicsContext gc) {
        LargeMap largeMap = new LargeMap();
        MapEditor mapEditor = new MapEditor(32,16,largeMap.getUserInput());

        try {
            mapEditor.writeFile("Large Map");
        }catch (Exception e){
            e.printStackTrace();
        }

        int[][] maparray = mapEditor.getMapArray();

        double w = 0, h=0;
        Image green = new Image("graphics/green.jpg");
        Image gravelTile = new Image("graphics/GravelTile.png");
        Image sandTile = new Image("graphics/SandTile.png");
        for(int i=0; i<maparray.length; i++){
            w=0;
            for(int j=0; j<maparray[0].length; j++){
                if(maparray[i][j]==0){
                    gc.drawImage(green,w,h,32,32);
                    w+=32;
                }
                else {
                    gc.drawImage(sandTile,w,h,32,32);
                    w+=32;
                }

            }
            h+=32;
        }

    }

}
