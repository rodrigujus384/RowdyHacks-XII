package cs2.game;

import java.util.Set;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class Party extends PlayState {

    private int selectHeld; 
    private GraphicsContext g;

    //@Override 
    public Party(GraphicsContext g, int x, int y){
        super(x, y);
        this.g = g;
    }

    private void draw(){
        super.display(g, MainApp.HouseFloor);
        g.setFill(Color.BLACK);
        g.fillRect(950, 85, 120, 110);
        g.setStroke(Color.YELLOW);
        g.setFill(Color.YELLOW);
        g.strokeRect(960, 95, 100, 25);
        g.fillRect(960, 95, MainApp.guestHappiness, 25);
        g.setStroke(Color.ROYALBLUE);
        g.setFill(Color.ROYALBLUE);
        g.strokeRect(960, 130, 100, 10);
        g.fillRect(960, 130, MainApp.musicVolume, 10);
        g.setStroke(Color.ROSYBROWN);
        g.setFill(Color.ROSYBROWN);
        g.strokeRect(960, 150, 100, 10);
        g.fillRect(960, 150, MainApp.alcohol, 10);
        g.setStroke(Color.ORANGE);
        g.setFill(Color.ORANGE);
        g.strokeRect(960, 170, 100, 10);
        g.fillRect(960, 170, MainApp.snacks, 10);
    }

    public boolean isButtonClicked(){
        return false; 
    }

    public boolean isButtonClicked(Set<KeyCode> heldKeys){
        return heldKeys.contains(KeyCode.SPACE);
    }

    public void update(Set<KeyCode> heldKeys) {
        super.update(heldKeys);}

    // @Override
    // public void update() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'update'");
    // }

    public void render() {
       draw();
    }
    
}
