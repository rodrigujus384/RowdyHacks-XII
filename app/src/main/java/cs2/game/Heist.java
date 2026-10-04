package cs2.game;

import java.util.ArrayList;
import java.util.Set;
import java.util.Timer; 
import java.util.TimerTask;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Heist extends PlayState{
    private int selectHeld; 

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
        
        //Resouce display dimentions
        double boxWidth = 150;
        double boxHeight = 45;
        double x = 1280 - boxWidth - 20;
        double y = 20;

        //Resource Background
        g.setFill(Color.LIGHTGRAY);
        g.fillRoundRect(x, y, boxWidth, boxHeight, 10, 10);


        // Resource Border
        g.setStroke(Color.BLACK);
        g.setFont(javafx.scene.text.Font.font(20));
 
        //Text 
        g.setFill(Color.BLACK);
        g.setFont(javafx.scene.text.Font.font(20));
        g.fillText( name + ": " + resources.intValue() , x + 10, y + 29);
    }

    public boolean isButtonClicked(Set<KeyCode> heldKeys){
        return heldKeys.contains(KeyCode.SPACE);
    }

    
    public void update(Set<KeyCode> heldKeys) {
        super.movement(heldKeys);
        if(isButtonClicked(heldKeys)){
            Shelf shelf = (Shelf)objAdjacentToPlayer();
            if(shelf != null){
                selectHeld++;
                System.out.println(selectHeld);
                if(selectHeld >= 1*60) { 
                    resources += shelf.removeResources();
                    selectHeld = 0; 
                }
            }
            else{ selectHeld = 0;}
        }
        else { selectHeld = 0;}
    }

    
    public void render() {
       draw(); 
    }
    
}
