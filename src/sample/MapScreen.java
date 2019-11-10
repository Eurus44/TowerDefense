package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import map.Map;
import map.MapEditor;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MapScreen {
    Image SandTile;
    Image ExitButtonGraphic;
    Image CreateMapButtonGraphic;
    Image BlackTileBoundaryGraphic;
    Image StartingPointGraphic;
    Image ExitPointGraphic;
    Image BluePathTileGraphic;
    Image SandTileGraphic;
    Image GravelTileGraphic;
    Image SaveMapButtonGraphic;

    private final int mouseClickDelay = 200;
    private long lastClick = (-1*mouseClickDelay);

    ArrayList<Integer> mapPoints = new ArrayList<Integer>();
    Rectangle ExitGameButton;
    Rectangle CreatMapButton;
    Rectangle SaveMapButton;
    ArrayList<Rectangle> buttonList = new ArrayList<Rectangle>();

    TextField mapWidthTextField;
    TextField mapHeightTextField;
    TextField mapNameTextField;

    Map userCreateMap;
    MapEditor saveMap;

    Font font;


    public final String widthString = "Enter Map Width:";
    public final String heightString = "Enter Map Height:";
    public final String nameString = "Enter Map Name: ";
    public static String statusString= "";

    private final int minimumMapDimension = 12;
    private final int maximumMapDimension = 20;

    public final int mapDrawOffsetX = 96;
    public final int mapDrawOffsetY = 128;

    private final int mapNameMaximumLength = 15;

    private static int mapWidthInput=0;
    private static int mapHeightInput=0;
    private static String mapNameInput ="";

    private int selectedTileX=-1;
    private int selectedTileY=-1;
    private int[] exitPoint;


    boolean mapInputAccepted = false;
    boolean startingPointAccepted=false;
    boolean exitPointAccepted = false;
    boolean mapCreated = false;


    public MapScreen(){}

    public void init(){
        loadImage();
    }
    public void update(){

    }
    public void drawBackGround(){

    }
    public void drawMap(GraphicsContext graphicsContext){

    }
    public void loadImage(){
        SandTile = new Image("graphics/SandTile.png");
        ExitButtonGraphic = new Image ("graphics/ExitButton.png");
        CreateMapButtonGraphic = new Image("graphics/CreateMapButtonGraphic.png");
        BlackTileBoundaryGraphic = new Image("graphics/BlackTileBoundaryGraphic.png");
        StartingPointGraphic = new Image("graphics/StartingPointGraphic.png");
        ExitPointGraphic = new Image("graphics/ExitPointGraphic.png");
        BluePathTileGraphic = new Image("graphics/BluePathTileGraphic.png");
        SandTileGraphic = new Image("graphics/SandTile.png");
        GravelTileGraphic = new Image("graphics/GravelTile.png");
        SaveMapButtonGraphic = new Image("graphics/SaveMapButtonGraphic.png");
    }
}
