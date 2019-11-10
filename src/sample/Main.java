package sample;



import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontSmoothingType;
import javafx.stage.Stage;

import java.io.InputStream;
import java.io.ObjectInputFilter;

public final class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    Stage window;
    Scene sceneLevel,sceneInstructions,sceneStore, scene;

    @Override
    public void start(Stage primaryStage) {
        double width = 1024.0;
        double height = 1024.0;
        double rAnchor = width/2-50;
        double lAnchor = width/2-50;

        window = primaryStage;


        Button startButton = new Button("Start");
        Button levelButton = new Button("Level");
        Button quitButton = new Button("Quit");
        Button storeButton = new Button("Store");
        Button backButton = new Button("Back");
        quitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });

        AnchorPane.setTopAnchor(backButton,700.0);
        AnchorPane.setRightAnchor(backButton,rAnchor);
        AnchorPane.setLeftAnchor(backButton,lAnchor);

        AnchorPane.setTopAnchor(startButton,200.0);
        AnchorPane.setRightAnchor(startButton,rAnchor);
        AnchorPane.setLeftAnchor(startButton,lAnchor);

        AnchorPane.setTopAnchor(levelButton,300.0);
        AnchorPane.setRightAnchor(levelButton,rAnchor);
        AnchorPane.setLeftAnchor(levelButton,lAnchor);

        AnchorPane.setTopAnchor(storeButton, 400.0);
        AnchorPane.setLeftAnchor(storeButton,rAnchor);
        AnchorPane.setRightAnchor(storeButton, lAnchor);

        AnchorPane.setTopAnchor(quitButton, 500.0);
        AnchorPane.setLeftAnchor(quitButton,rAnchor);
        AnchorPane.setRightAnchor(quitButton,lAnchor);

        storeButton.setOnAction(e -> window.setScene(sceneStore));
        AnchorPane newAnchorPane = new AnchorPane();
        newAnchorPane.getChildren().addAll(backButton);
        sceneStore = new Scene(newAnchorPane, width, height);
        backButton.setOnAction(e -> window.setScene(scene));


        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(startButton,levelButton,quitButton, storeButton);
        scene = new Scene(anchorPane, width, height);
        window.setTitle("Tower Defense");
        window.setScene(scene);
        window.show();

    }
}
