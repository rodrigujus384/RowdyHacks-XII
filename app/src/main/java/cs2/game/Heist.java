package cs2.game;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Heist extends PlayState implements Screen {

    private GraphicsContext g;
    private Integer resources; 
    private String name;
    private Shelves shelves; 

    public Heist(GraphicsContext g, int x, int y, Integer resources, String name) {
        super(x, y);
        
        this.g = g;
        this.resources = resources;
        this.name = name;

        shelves = new Shelves(new Image("file:imgs/store_shelf_empty_alarm_off.png"), 0.25, x, y);
        super.addObjects(shelves.getShelves());
        //TODO Auto-generated constructor stub
    }

    private void draw(){
        super.display(g, new Image("file:imgs/store_floor1.png")); 
    }

    public boolean isButtonClicked(){
        return false; 
    }

    @Override
    public void update() {
        
    }

    @Override
    public void render() {
       draw();
    }
    
}
