package cs2.game;

public abstract class PlayState {
    //class variables
    Sprite[] obj; 
    Player py;

    // Constructs the needed sprites
    public PlayState(Player py, Sprite[] obj){
        this.obj = obj;
        this.py = py; 
    }

    // Handles movement in Heist and Party
    public void movement(){

    }

    // Handles collison in Heist and Party
    public boolean collison(){
        return false;
    }
}
