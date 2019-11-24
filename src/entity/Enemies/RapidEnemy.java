package entity.Enemies;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class RapidEnemy extends Enemy {

    public RapidEnemy(int[][] map, double xPos, double yPos) {
        super(map, xPos, yPos);
        image = new Image("Assets/RapidEnemy.png", 32,32,false, true);
        speed = 2;
        hp = 7;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(image, xPos, yPos);
    }


}
