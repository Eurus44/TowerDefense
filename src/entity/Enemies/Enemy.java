package entity.Enemies;

import entity.GameEntity;

public abstract class Enemy extends GameEntity {

    protected double dangerous;
    protected double hp;
    Direction direction = Direction.RIGHT;
    protected double speed;

    public double getDangerous() {
        return dangerous;
    }

    int[][] map;

    public Enemy(int[][] map, double xPos, double yPos) {
        super(xPos, yPos);
        this.map = map;
    }


    @Override
    public void update() {
        double vx;
        double vy;
        direction = getDirect();
        switch (direction) {
            case LEFT:
                vx = -speed;
                vy = 0;
                break;
            case RIGHT:
                vx = speed;
                vy = 0;
                break;
            case UP:
                vx = 0;
                vy = -speed;
                break;
            default /*down*/:
                vx = 0;
                vy = speed;
        }
        xPos += vx;
        yPos += vy;
    }

    boolean check_destroy = false;

    public Direction getDirect() {
        if (xPos % 32 != 0 || yPos % 32 != 0) return direction;
        int x = (int) xPos / 32;
        int y = (int) yPos / 32;
        if(x < 0 || x >= 32 || y < 0 || y >= 16) return  direction; // out of map
        switch (direction) {
            case RIGHT:
                if (x + 1 >= 32 || map[y][x + 1] == 0)
                    if (y - 1 >= 0 && map[y - 1][x] == 1) return Direction.UP;
                    else if (y + 1 < 16 && map[y + 1][x] == 1) return Direction.DOWN;
                    else {
                        check_destroy = true;
                    }
                break;
            case LEFT:
                if (x - 1 < 0 || map[y][x - 1] == 0)
                    if (y + 1 < 16 && map[y + 1][x] == 1) return Direction.DOWN;
                    else if (y - 1 >= 0 && map[y - 1][x] == 1) return Direction.UP;
                    else check_destroy = true;
                break;
            case UP:
                if (y - 1 < 0 || map[y - 1][x] == 0)
                    if (x + 1 < 32 && map[y][x + 1] == 1) return Direction.RIGHT;
                    else if (x - 1 >= 0 && map[y][x - 1] == 1) return Direction.LEFT;
                    else check_destroy = true;
                break;
            case DOWN:
                if (y + 1 >= 16 || map[y + 1][x] == 0)
                    if (x - 1 >= 0 && map[y][x - 1] == 1) return Direction.LEFT;
                    else if (x + 1 < 32 && map[y][x + 1] == 1) return Direction.RIGHT;
                    else check_destroy = true;
                break;
        }
        return direction;
    }


    public void setHp(double hp) {
        this.hp = hp;
    }

    public void damage(double dame) {
        hp -= dame;
    }

    public boolean onDestroy() {
        if(check_destroy == true) return true;
        if(hp < 0) {
            //System.out.println("abs");
            return true;
        }
        return false;
    }
}
