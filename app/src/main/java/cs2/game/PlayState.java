package cs2.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public abstract class PlayState{
    //class variables
    private ArrayList<GameSprite> objs;
    private HashMap<Vec2, GameSprite> objFromPos;
    private boolean[][] grid;
    Player player;

    // Constructs the needed sprites
    public PlayState(int x, int y){
        this.objs = new ArrayList<GameSprite>();
        this.objFromPos = new HashMap<Vec2, GameSprite>();
        this.player = new Player();
        grid = new boolean[y][x];
    }

    public int getGridWidth(){ return grid[0].length; }

    public int getGridHeight(){ return grid.length; }

    public void addObjects(ArrayList<? extends GameSprite> newObjs){
        for(GameSprite s : newObjs){
            objs.add(s); 
            objFromPos.put(s.gridPos, s);
        }
    }

    public void addObjects(GameSprite[] newObjs){
        for(GameSprite s: newObjs){
            objs.add(s);
            objFromPos.put(s.gridPos, s);
        }
    }

    public void update(Set<KeyCode> heldKeys){
        movement(heldKeys);
    }

    // Handles movement in Heist and Party
    public void movement(Set<KeyCode> heldKeys){
        if (heldKeys.contains(KeyCode.UP) || heldKeys.contains(KeyCode.W)) {player.moveUp();}
        if (heldKeys.contains(KeyCode.LEFT) || heldKeys.contains(KeyCode.A)) {player.moveLeft();}
        if (heldKeys.contains(KeyCode.RIGHT) || heldKeys.contains(KeyCode.D)) {player.moveRight();}
        if (heldKeys.contains(KeyCode.DOWN) || heldKeys.contains(KeyCode.S)) {player.moveDown();}
    }

    // Handles collison in Heist and Party
    public boolean isNoCollison(){
        for(GameSprite s: objs)
            if(player.intersection(s))
                return false;
        return true;
    }

    public void display(GraphicsContext g, Image floorTileTexture) {

        Vec2 playerPos = player.getGridPos();

        double cameraX =
            playerPos.getX() * MainApp.gridCellSize - 640;

        double cameraY =
            playerPos.getY() * MainApp.gridCellSize - 360;

        int tileSize = MainApp.gridCellSize;

        // Floor starts at the player's grid position
        int startCol = (int) playerPos.getX();

        // Cover the full vertical screen around the player
        int startRow = (int) playerPos.getY() - 360 / tileSize;
        int endRow = (int) playerPos.getY() + 360 / tileSize;

        // Draw enough columns to fill the screen to the right
        int endCol = startCol + 1280 / tileSize + 1;

        for (int row = startRow; row <= endRow; row++) {
            for (int col = startCol; col <= endCol; col++) {

                g.drawImage(
                    floorTileTexture,
                    col * tileSize - cameraX,
                    row * tileSize - cameraY
                );
            }
        }

        // Player
        player.display(g);

        // Shelves
        for (GameSprite s : objs) {
            s.displayWithTranslation(
                g,
                new Vec2(cameraX, cameraY)
            );
        }
    }

    public GameSprite objAbovePlayer(){
        Vec2 xy = player.getGridPos();
        if(grid[(int)xy.getY()-1][(int)xy.getX()])
            return objFromPos.get(xy);
        return null;
    }

    public GameSprite objAdjacentToPlayer(){
        Vec2 xy = player.getGridPos();
        int x = (int)xy.getX(), y = (int)xy.getY();
        if(grid[y-1][x])
            return objFromPos.get(new Vec2(x, y-1));
        if(grid[y][x+1])
            return objFromPos.get(new Vec2(x+1, y));
        if(grid[y+1][x])
            return objFromPos.get(new Vec2(x, y+1));
        if(grid[y][x-1])
            return objFromPos.get(new Vec2(x-1, y));
        return null;
    }
}
