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

import java.awt.font.ImageGraphicAttribute;
import java.io.*;
import java.util.Scanner;

public final class runMap extends Application {
    public static void main(String[] args) {
        Application.launch(args);

    }

    @Override
    public void start(Stage primaryStage){
        double width = 1024;
        double height = 512;
        Canvas canvas = new Canvas(width,height);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        draw(gc);
        drawObject(gc);
        Scene scene = new Scene(new Group(canvas));


        primaryStage.setScene(scene);
        primaryStage.setTitle("Tower Defenese");
        primaryStage.show();
    }
    public void draw(GraphicsContext gc) {
        SmallMap smallMap = new SmallMap();
        MapEditor mapEditor = new MapEditor(32,16,smallMap.getUserInput());

        try {
            mapEditor.writeFile("Small Map");
        }catch (Exception e){
            e.printStackTrace();
        }

        int[][] maparray = mapEditor.getMapArray();
        int[][] objecArray = smallMap.placeTree();

        double w = 0, h=0;
        Image green = new Image("graphics/green.jpg");
        Image sandTile = new Image("graphics/SandTile.png");
        Image soilImage = new Image("graphics/soil.jpg");

        for(int i=0; i<16; i++){
            w=0;
            for(int j=0; j<32; j++){
                if(maparray[i][j]==0){
                    gc.drawImage(soilImage,w,h,32,32);
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
    public void drawObject(GraphicsContext gc) {
        SmallMap smallMap = new SmallMap();
        MapEditor mapEditor = new MapEditor(32,16,smallMap.getUserInput());

        try {
            mapEditor.writeFile("Small Map");
        }catch (Exception e){
            e.printStackTrace();
        }

        int[][] maparray = mapEditor.getMapArray();
        int[][] objecArray = smallMap.placeTree();

        double w = 0, h=0;

        Image treeImage2 = new Image("graphics/tree.png");
        Image churchImage = new Image("graphics/church1.png");


        for(int i=0; i<16; i++){
            w=0;
            for(int j=0; j<32; j++){
                if(objecArray[i][j]==4){
                    gc.drawImage(treeImage2,w,h,64,64);
                }
                else if(objecArray[i][j]==5) {
                    gc.drawImage(churchImage,w,h, 192,192);
                }
                w+=32;
            }
            h+=32;
        }
    }

}