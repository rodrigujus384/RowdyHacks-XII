package cs2.game;

import java.util.ArrayList;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Shelves {
    private ArrayList<Shelf> shelves;

    public Shelves(Image i, double alarmFrequency, int width, int height){
        shelves = new ArrayList<Shelf>(); 
        
        int type = (int)(Math.random() * 3 + 1); 
        switch (type) {
            case 1:
                lineShelves(i, shelves, alarmFrequency, width, height);
                break;
            case 2: 
                circleShelves(i, shelves, alarmFrequency, width, height);
                break;
            case 3: 
                randomShelves(i, shelves, alarmFrequency, width, height);
                break;
            default:
                lineShelves(i, shelves, alarmFrequency, width, height);
                break;
        }
    }

    private void lineShelves(Image i, ArrayList<Shelf> shelves, double alarmFrequency, int width,int height) {
        // Player's world position
        int playerX = 0;

        // Shelves begin to the right of the player
        int startX = playerX + 4;

        // Place shelves both above and below the player
        int startY = -height / 2;
        int endY = height / 2;
        
        // Creates columns of shelves
        for (int x = startX; x < width; x++) {
            for (int y = startY; y <= endY; y += 2) {
                shelves.add(new Shelf(i,new Vec2(x, y),alarmFrequency));
            }
        }
    }

    private void randomShelves(Image i, ArrayList<Shelf> shelves, double alarmFrequency, int width, int height) {
        for (int x = 2; x < width; x += 2) {
            for (int y = -height / 2; y <= height / 2; y += 2) {
                
                //There is a 50% chance any given shelf space contains a shelf
                if (Math.random() < 0.5) {
                    shelves.add(new Shelf(i, new Vec2(x, y),alarmFrequency));
                }
            }
        }
    }

    private void circleShelves(Image i, ArrayList<Shelf> shelves, double alarmFrequency, int width, int height) {
        // Player is at (0, 0)
        int playerX = 0;
        int playerY = 0;

        // Radius of the circle
        int radius = Math.min(width / 4, height / 2);

        // Gap between player and the circle
        int gap = 3;

        // Put the center of the circle to the right of the player
        int centerX = playerX + radius + gap;
        int centerY = playerY;

        // Number of shelves around the circle
        int numberOfShelves = height * 2;

        for (int n = 0; n < numberOfShelves; n++) {
            double angle = 2 * Math.PI * n / numberOfShelves;

            int x = (int) Math.round(centerX + radius * Math.cos(angle));
            int y = (int) Math.round(centerY + radius * Math.sin(angle));

            shelves.add(new Shelf(i,new Vec2(x, y),alarmFrequency));
        }
    }

    public ArrayList<Shelf> getShelves(){
        return shelves;
    }
    
    public void update(double deltaTime) {
        for (Shelf sh : shelves) {
            sh.update(deltaTime);
        }
    }
}
