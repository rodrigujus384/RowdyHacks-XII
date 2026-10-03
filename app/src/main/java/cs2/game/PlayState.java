package cs2.game;

import java.util.ArrayList;
import java.util.Set;
import javafx.scene.input.KeyCode;

public abstract class PlayState {
    //class variables
    private ArrayList<GameSprite> objs;
    private Boolean[][] grid;
    Player player;

    // Constructs the needed sprites
    public PlayState(Player py, int x, int y){
        this.objs = new ArrayList<GameSprite>();
        this.player = py; 
        grid = new Boolean[y][x];
    }

    // Handles movement in Heist and Party
    public void movement(Set<KeyCode> s){
        //TODO: implement movement from Player
    }

    // Handles collison in Heist and Party
    public boolean isNoCollison(){
        for(GameSprite s: objs)
            if(player.intersection(s))
                return false;
        return true;
    }
}
