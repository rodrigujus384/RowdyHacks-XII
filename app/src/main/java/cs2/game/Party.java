package cs2.game;

import java.util.ArrayList;
import java.util.Set;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class Party extends PlayState {

    private int selectHeld; 
    private GraphicsContext g;
    ArrayList<Guest> guests = new ArrayList<>();


    //@Override 
    public Party(GraphicsContext g, int x, int y){
        super(x, y);
        this.g = g;
    }

    public void invite() {
        guests.clear();
            for (int i = 0; i < (((int) (Math.random() * 6) + 4) * MainApp.PartyNum); i++) {
              guests.add(new Guest(MainApp.Default , new Vec2(((int) (Math.random() * 14)),((int) (Math.random() * 14)))));
        }
        this.addObjects(guests);
    }

    public void checkIn() {
        // Loops through guests
          for (Guest f : guests) {
            f.roam();
            f.Hunger();
            f.Thirst();
          }
    }

    private void draw(){
        super.display(g, MainApp.HouseFloor);
        g.setFill(Color.BLACK);
        g.fillRect(950, 85, 120, 150);
        g.setStroke(Color.YELLOW);
        g.setFill(Color.YELLOW);
        g.strokeRect(960, 95, 100, 25);
        g.fillRect(960, 95, MainApp.guestHappiness, 25);
        g.setStroke(Color.ROYALBLUE);
        g.setFill(Color.ROYALBLUE);
        g.strokeRect(960, 130, 100, 10);
        g.fillRect(960, 130, (MainApp.musicVolume), 10);
        g.setStroke(Color.RED);
        g.setFill(Color.RED);
        g.fillRect(1040, 130, 5, 10);
        g.strokeRect(960, 150, 100, 10);
        g.fillRect(960, 150, (MainApp.noiseComplaint), 10);
        g.setStroke(Color.ROSYBROWN);
        g.setFill(Color.ROSYBROWN);
        g.strokeRect(960, 170, 100, 10);
        g.fillRect(960, 170, MainApp.alcohol, 10);
        g.setStroke(Color.ORANGE);
        g.setFill(Color.ORANGE);
        g.strokeRect(960, 190, 100, 10);
        g.fillRect(960, 190, MainApp.snacks, 10);
        g.setStroke(Color.GREEN);
        g.setFill(Color.GREEN);
        g.strokeRect(960, 210, 100, 10);
        g.fillRect(960, 210, MainApp.partySupplies, 10);
    }

    public boolean isButtonClicked(){
        return false; 
    }

    public boolean isButtonClicked(Set<KeyCode> heldKeys){
        return heldKeys.contains(KeyCode.SPACE);
    }

    public void update(Set<KeyCode> heldKeys) {
        super.movement(heldKeys);
        Guest g = (Guest)super.adjacentInteractable(false);
    }

    public void render() {
       draw();
    }
    
}
