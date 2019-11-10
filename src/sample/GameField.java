package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import map.Map;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class GameField {

    Map map;

    public GameField() {}

    public void update() {}


    public void draw(GraphicsContext graphicsContext) {
        Image image = new Image("graphics/Screenshot.SandTile.png");
        ImageView imageView = new ImageView(image);
        graphicsContext.drawImage(image,200,300);
    }

}