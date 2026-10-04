package cs2.game;

import java.util.ArrayList;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Shelves {
    private ArrayList<Shelf> shelves;
    private int scale = MainApp.scale;

    public Shelves(Image i, double alarmFrequency, int width, int height){
        shelves = new ArrayList<Shelf>(); 
        
        int type = 1;
        //int type = (int)(Math.random() * 3 + 1); 
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
        for(int x = 0; x < width * scale; x += (width / 5))
            for(int y = 0; y < height * scale; y += (height / 5))
                shelves.add(new Shelf(i, new Vec2(x, y), alarmFrequency));
    }

    private void randomShelves(Image i, ArrayList<Shelf> shelves, double alarmFrequency, int width, int height) {
        for(int x = 0; x < width; x++)
            for(int y = 0; y < height; y++)
                if(Math.random() < 0.5)
                    shelves.add(new Shelf(i, new Vec2(x, y), alarmFrequency));
    }

    private void circleShelves(Image i, ArrayList<Shelf> shelves, double alarmFrequency, int width, int height) {
        int centerX = (width / 2);
        int centerY = (height / 2);

        int radius = (height / 2);
        int numOfShelves = height * 2;
        for(int n = 0; n < numOfShelves; n++){
            double angle = 2 * Math.PI * n / numOfShelves; 

            int x = (int)Math.round(centerX + radius * Math.cos(angle));
            int y = (int)Math.round(centerY + radius * Math.sin(angle));

            shelves.add(new Shelf(i, new Vec2(x, y), alarmFrequency));
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
