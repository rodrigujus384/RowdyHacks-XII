package cs2.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Heist extends PlayState implements Screen {

    GraphicsContext g;
    Integer resources; 
    String name;

    public Heist(GraphicsContext g, Player py, int x, int y, Integer resources, String name) {
        super(py, x, y);
        
        this.g = g;
        this.resources = resources;
        this.name = name;
        
        //TODO Auto-generated constructor stub
    }

    private void draw(){
        // Background
        g.setFill(Color.web("#87cefa"));
        g.fillRect(0, 0, 1280, 720);
    }

    public boolean isButtonClicked(){
        return false; 
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void render() {
        
       draw();
    }
    
}
