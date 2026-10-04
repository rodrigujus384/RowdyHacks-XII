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
    private boolean[][] grid;
    private boolean[][] iGrid;
    private Player player;
    private boolean standing = true;
    private boolean facingRight = true;

    // Constructs the needed sprites
    public PlayState(int x, int y){
        this.objs = new ArrayList<GameSprite>();
        this.player = new Player();
        grid = new boolean[y][x];
        iGrid = new boolean[y][x];
        for(int i=0;i<y;i++)
            for(int j=0;j<x;j++){
                grid[i][j] = false;
                iGrid[i][j] = false;
            }
                
    }

    public int getGridWidth(){ return grid[0].length; }

    public int getGridHeight(){ return grid.length; }

    public void addObjects(ArrayList<? extends GameSprite> newObjs){
        for(GameSprite s : newObjs){
            objs.add(s); 
            grid [(int)s.gridPos.getY()][(int)s.gridPos.getX()] = true;
            if(s.interactable)
                iGrid [(int)s.gridPos.getY()][(int)s.gridPos.getX()] = true;
        }
    }
    public void addObjects(GameSprite[] newObjs){
        for(GameSprite s: newObjs){
            objs.add(s);
            grid [(int)s.gridPos.getY()][(int)s.gridPos.getX()] = true;
            if(s.interactable)
                iGrid [(int)s.gridPos.getY()][(int)s.gridPos.getX()] = true;
        }
    }

    public abstract void update(Set<KeyCode> heldKeys);

    public GameSprite adjacentInteractable(){
        return adjacentInteractable(false);
    }
    public GameSprite adjacentInteractable(boolean justUp){
        GameSprite s = justUp? objAbovePlayer() : objAdjacentToPlayer();
        MainApp.kp.isVisible = s!=null;
        if(s!=null){
           MainApp.kp.pos = new Vec2(s.getPos().getX(), s.getPos().getY() + MainApp.scale/3);
           System.out.println("!!!!!!");
        }
        return s; 
    }

    // Handles movement in Heist and Party
    public void movement(Set<KeyCode> heldKeys){
        if ((heldKeys.contains(KeyCode.UP) || heldKeys.contains(KeyCode.W)) 
            && (player.pos.getY()>-360+MainApp.scale/2)
            && !isCollison(player.pos.add(new Vec2(0, -0.2)))) {
            player.moveUp();
            standing = false;
        }
        if ((heldKeys.contains(KeyCode.LEFT) || heldKeys.contains(KeyCode.A)) 
            && (player.pos.getX()>-640+MainApp.scale/2)
            && !isCollison(player.pos.add(new Vec2(-0.7, 0)))) {
            player.moveLeft();
            standing = false;
            facingRight = false;
        }
        if ((heldKeys.contains(KeyCode.RIGHT) || heldKeys.contains(KeyCode.D)) 
            && (player.pos.getX()<getGridWidth()*MainApp.scale-640-MainApp.scale/2)
            && !isCollison(player.pos.add(new Vec2(35, 0)))) {
            player.moveRight();
            standing = false;
            facingRight = true;
        }
        if ((heldKeys.contains(KeyCode.DOWN) || heldKeys.contains(KeyCode.S)) 
            && (player.pos.getY()<getGridWidth()*MainApp.scale-360-MainApp.scale/2)
            && !isCollison(player.pos.add(new Vec2(0, 40)))) {
            player.moveDown();
            standing = false;
        }
        if(standing){
            if(facingRight)
                player.img = MainApp.playerImg;
            else
                player.img = MainApp.playerImgLeft;
        }
        else{
            if(facingRight)
                player.img = MainApp.playerGif;
            else
                player.img = MainApp.playerGifLeft;
        }
        standing = true;
    }

    // Handles collison in Heist and Party
    public boolean isCollison(Vec2 pos){
        int x = (int)Math.floor(pos.getX()/MainApp.scale) + 7, y = (int)Math.floor(pos.getY()/MainApp.scale) + 4;
        return x>=0&&y>=0&&x<getGridWidth()&&y<getGridHeight()&&grid[y][x];
    }

    public void display(GraphicsContext g, Image floorTileTexture){
        g.fillRect(0,0,1280, 720);
        for(int r = 0; r<getGridHeight(); r++)
            for(int c = 0; c<getGridWidth(); c++)
                g.drawImage(floorTileTexture, 
                    r*MainApp.scale-player.pos.getX(), 
                    c*MainApp.scale-player.pos.getY());
        for(GameSprite s: objs)
            s.displayWithTranslation(g, player.pos);
        player.display(g);
    }

    private GameSprite objFromPos(Vec2 tgp){
        for(GameSprite s: objs)
            if(s.gridPos.getX()==tgp.getX()&&s.gridPos.getY()==tgp.getY())
                return s;
        return null;
    }

    public GameSprite objAbovePlayer(){
        Vec2 xy = player.getGridPos();                   
        if(iGrid[(int)xy.getY()-1][(int)xy.getX()])
            return objFromPos(xy.add(new Vec2(0, -1)));
        return null;
    }

    public GameSprite objAdjacentToPlayer(){
        Vec2 xy = player.getGridPos();
        int x = (int)xy.getX(), y = (int)xy.getY();
        if(iGrid[y-1][x])
            return objFromPos(xy.add(new Vec2(0, -1)));
        if(iGrid[y][x+1])
            return objFromPos(xy.add(new Vec2(1, 0)));
        if(iGrid[y+1][x])
            return objFromPos(xy.add(new Vec2(0, 1)));
        if(iGrid[y][x-1])
            return objFromPos(xy.add(new Vec2(-1, 0)));
        return null;
    }
}
