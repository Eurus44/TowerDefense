package entity.Enemies;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.InputStream;
import java.util.ArrayList;

public class NormalEnemy extends Enemy {

    public NormalEnemy(int[][] map, double xPos, double yPos) {
        super(map, xPos, yPos);
        image = new Image("Assets/nnEnemy.png", 32,32,false,true);
        speed = 1;
        hp=10;
    }


    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(this.image, xPos, yPos);
        //System.out.println(hp);
    }

}
