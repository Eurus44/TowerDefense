package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class GameController extends AnimationTimer {

    private static GameController controllerInstance = null;
    private GameController(GameField gameField, GraphicsContext graphicsContext) {
        this.gameField = gameField;
        this.graphicsContext = graphicsContext;
    }

    public static GameController getInstance(GameField gameField, GraphicsContext graphicsContext) {
        if(controllerInstance == null) controllerInstance = new GameController(gameField, graphicsContext);
        return controllerInstance;
    }

    private GraphicsContext graphicsContext;
    private GameField gameField;



    @Override
    public void handle(long now) {

        //update
        gameField.update();

        //draw
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0, 0, 800, 500);
        gameField.draw(graphicsContext);


    }
}