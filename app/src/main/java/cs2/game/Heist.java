package cs2.game;

import java.util.ArrayList;
import java.util.Set;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
public class Heist extends PlayState{

    private GraphicsContext g;
    private Integer resources; 
    private String name;
    private Shelves shelves; 
    static final Image ShelfImg = new Image("file:imgs/store_shelf_empty_alarm_off.png", MainApp.scale, MainApp.scale, true, true);


    public Heist(GraphicsContext g, int x, int y, Integer resources, String name) {
        super(x, y);
        
        this.g = g;
        this.resources = resources;
        this.name = name;

        shelves = new Shelves(ShelfImg, 0.25, x, y);
        super.addObjects(shelves.getShelves());
        //TODO Auto-generated constructor stub
    }

    private void draw(){
        super.display(g, MainApp.Store1); 
    }

    public boolean isButtonClicked(){
        return false; 
    }

    
    public void update(Set<KeyCode> heldKeys) {
        super.update(heldKeys);
        if(isButtonClicked()){
            
        }
    }

    
    public void render() {
       draw(); 
    }
    
}
