package cs2.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Heist extends PlayState implements Screen {

    private GraphicsContext g;
    private Integer resources; 
    private String name;
    private Shelves shelves; 

    public Heist(GraphicsContext g, Player py, int x, int y, Integer resources, String name) {
        super(py, x, y);
        
        this.g = g;
        this.resources = resources;
        this.name = name;

        shelves = new Shelves(new Image("file:apps/imgs/app/imgs/store_shelf_empty_alarm_off.png"), 0.25, x, y);
        super.addOjbects(shelves.getShelves());
        //TODO Auto-generated constructor stub
    }

    private void draw(){
        // Background
        g.setFill(Color.web("#87cefa"));
        g.fillRect(0, 0, 1280, 720);

        super.display(g); 
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
