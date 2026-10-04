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

    private void lineShelves(Image i, ArrayList<Shelf> shelves, double alarmFrequency, int width, int height){
        int gridCols = width;
        int gridRows = height;  

        int bufferX = (int)(gridCols * 0.10);
        for(int x = 0 + bufferX; x < gridCols - bufferX; x++){
            for(int y = 0; y < (gridRows / 2); y++){
                shelves.add(new Shelf(i, new Vec2(x, (y * 2)),  alarmFrequency));
            }
        }
    }

    private void randomShelves(Image i, ArrayList<Shelf> shelves, double alarmFrequency, int width, int height){
            int gridCols = width;
            int gridRows = height;  

            int bufferX = (int)(gridCols * 0.10);
            for(int x = 0 + bufferX; x < gridCols - bufferX; x++){
                for(int y = 0; y < gridRows; y++){
                    if(0.5 < Math.random()){
                        shelves.add(new Shelf(i, new Vec2(x, y), alarmFrequency));
                    }
                    
                }
            }
    }

    private void circleShelves(Image i, ArrayList<Shelf> shelves, double alarmFrequency, int width, int height) {
        int centerX = (width / 2);
        int centerY = (height / 2);
        int radius = (int)(centerX);

        int numberOfShelves = height; 

        for (int n = 0; n < numberOfShelves; n++) {

            double angle = 2 * Math.PI * n / numberOfShelves;

            int x = (int)(centerX + radius * Math.cos(angle));
            int y = (int)(centerY + radius * Math.sin(angle));

            shelves.add(new Shelf(i,new Vec2(x, y), alarmFrequency));
        }
    }
    
    public void update(double deltaTime) {
        for (Shelf sh : shelves) {
            sh.update(deltaTime);
        }
    }
}
