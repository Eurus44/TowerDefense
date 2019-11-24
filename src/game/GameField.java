package game;

import Object.Church;
import Object.Tree;
import background.MapEditor;
import background.SmallMap;
import entity.Enemies.Enemy;
import entity.Enemies.NormalEnemy;
import entity.Enemies.RapidEnemy;
import entity.tower.Tower;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GameField {

    public GameField() {
        SmallMap smallMap = new SmallMap();
        MapEditor mapEditor = new MapEditor(32, 16, smallMap.getUserInput());

        try {
            mapEditor.writeFile("Small Map");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        tree = new Tree();
        church = new Church();

        maparray = mapEditor.getMapArray();
        objecArray = smallMap.placeTree();

        for(int i=0;i<10;i++) {
            Enemy e = new NormalEnemy(maparray, 0, 10 * 32);
            enemyQueue.add(e);
        }
        for(int i=0;i<10;i++) {
            Enemy e = new RapidEnemy(maparray, 0, 10 * 32);
            enemyQueue.add(e);
        }

    }

    private Tree tree;
    private Church church;
    int[][] maparray;
    int[][] objecArray;

    private ArrayList<Enemy> enemyArrayList = new ArrayList<>();
    private ArrayList<Tower> towerArrayList = new ArrayList<>();
    private Queue<Enemy> enemyQueue = new LinkedList<>();
    private int count_spawn = 0;
    private int count_dead = 0;

    public ArrayList<Enemy> getEnemyArrayList() {
        return enemyArrayList;
    }

    public void add_enemy() {
        // enemyQueue.size() = 20;
        if(enemyQueue.size() > 0) {
            // round 1 : 1 enemy
            if(count_dead == 0 && count_spawn == 0) {
                enemyArrayList.add(enemyQueue.poll());
                count_spawn++;
            }
            // round 2 : 4 enemy
            if(count_dead >= 1 && count_spawn <= 4) {
                enemyArrayList.add(enemyQueue.poll());
                count_spawn++;
            }
            // round 3 : 5 enemy
            if(count_dead >= 5 && count_spawn <= 9) {
                enemyArrayList.add(enemyQueue.poll());
                count_spawn++;
            }
            // round 4 : 1 rapid enemy
            if(count_dead >= 10 && count_spawn <= 10) {
                enemyArrayList.add(enemyQueue.poll());
                count_spawn++;
            }
            //round 5 : 3 rapid enemy
            if(count_dead >= 11 && count_spawn <= 13) {
                enemyArrayList.add(enemyQueue.poll());
                count_spawn++;
            }
            //round 6 : 5 rapid enemy
            if(count_dead >= 14 && count_spawn <= 20) {
                enemyArrayList.add(enemyQueue.poll());
                count_spawn++;
            }
            System.out.println(count_dead + " " + count_spawn);
        }
    }

    public void update() {
        for(int i=0;i<enemyArrayList.size();i++) {
            if(enemyArrayList.get(i).onDestroy() == true) {
                // dem enemy dead
                count_dead++;
                enemyArrayList.remove(i);
                i--;
            }
            else enemyArrayList.get(i).update();
        }

        for (Tower tower : towerArrayList) tower.update();
    }

    public void createTower(Tower tower) {

        towerArrayList.add(tower);
    }

    public void draw(GraphicsContext graphicsContext) {
        double w = 0, h = 0;
        Image green = new Image("Assets/green.jpg");
        Image sandTile = new Image("Assets/SandTile.png");
        Image soilImage = new Image("Assets/soil.jpg");

        for (int i = 0; i < 16; i++) {
            w = 0;
            for (int j = 0; j < 32; j++) {
                if (maparray[i][j] == 0) {
                    graphicsContext.drawImage(soilImage, w, h, 32, 32);
                    w += 32;
                } else {
                    graphicsContext.drawImage(sandTile, w, h, 32, 32);
                    w += 32;
                }
            }
            h += 32;
        }

        for (Enemy enemy : enemyArrayList) enemy.draw(graphicsContext);
        for (Tower tower : towerArrayList) tower.draw(graphicsContext);
    }

    public void drawObject(GraphicsContext graphicsContext) {
        double w = 0, h = 0;

        for (int i = 0; i < 16; i++) {
            w = 0;
            for (int j = 0; j < 32; j++) {
                if (objecArray[i][j] == 4) {
                    graphicsContext.drawImage(tree.getImage(), w, h, 64, 64);
                } else if (objecArray[i][j] == 5) {
                    graphicsContext.drawImage(church.getImage(), w, h, 192, 192);
                }
                w += 32;
            }
            h += 32;
        }
    }
}
