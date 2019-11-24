package game;

import entity.Enemies.Enemy;
import entity.Enemies.NormalEnemy;
import entity.tower.MachineGun;
import entity.tower.SniperTower;
import entity.tower.Tower;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class GameController extends AnimationTimer {

    private static GameController controllerInstance = null;

    private GameController(GameField gameField, GraphicsContext graphicsContext) {
        this.gameField = gameField;
        this.graphicsContext = graphicsContext;
    }

    public static GameController getInstance(GameField gameField, GraphicsContext graphicsContext) {
        if (controllerInstance == null) controllerInstance = new GameController(gameField, graphicsContext);
        return controllerInstance;
    }

    private GraphicsContext graphicsContext;
    static private GameField gameField;

    public static Button button1 = new Button();
    public static Button button2 = new Button();

    Tower towerOnDrag = null;

    static{
        button1.setMinSize(100, 100);
        button1.setOnAction(event -> {
            if(controllerInstance.towerOnDrag == null) {
                controllerInstance.towerOnDrag = new MachineGun(-1000, -1000, gameField.getEnemyArrayList());
            }
        });

        Image image = new Image("Assets/gun1.png");
        ImageView imageView1 = new ImageView(image);
        button1.setGraphic(imageView1);

        button2.setMinSize(100, 100);
        button2.setOnAction(event -> {
            if(controllerInstance.towerOnDrag == null) {
                controllerInstance.towerOnDrag = new SniperTower(-1000, -1000, gameField.getEnemyArrayList());
            }
        });

        Image image2 = new Image("Assets/gun4.png");
        ImageView imageView2 = new ImageView(image2);
        button2.setGraphic(imageView2);
    }

    public static void mouseMouse(MouseEvent mouseEvent) {
        if(controllerInstance.towerOnDrag != null) {
            double x = mouseEvent.getX() - 25;
            double y = mouseEvent.getY() - 25;
            controllerInstance.towerOnDrag.setxPos(x);
            controllerInstance.towerOnDrag.setyPos(y);
            controllerInstance.towerOnDrag.getxPos();
            controllerInstance.towerOnDrag.getyPos();
        }
    }

    public static void mouseClicked(MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == MouseButton.PRIMARY) {
            if(controllerInstance.towerOnDrag != null) {
                controllerInstance.gameField.createTower(controllerInstance.towerOnDrag);
                controllerInstance.towerOnDrag = null;
            }
        }
    }
    long count = 0;
    @Override
    public void handle(long now) {
        gameField.update();
        gameField.draw(graphicsContext);
        gameField.drawObject(graphicsContext);
        count++;
        if(count % 100 == 0) {
            count = 0;
            gameField.add_enemy();
        }
        if(controllerInstance.towerOnDrag != null) {
            graphicsContext.setStroke(Color.RED);
            towerOnDrag.setRange();
            graphicsContext.strokeOval(controllerInstance.towerOnDrag.getxPos() + 25 - towerOnDrag.getRange()/2, controllerInstance.towerOnDrag.getyPos() + 25 - towerOnDrag.getRange()/2, towerOnDrag.getRange(), towerOnDrag.getRange());
            controllerInstance.towerOnDrag.draw(graphicsContext);
        }
    }

}
