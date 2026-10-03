package cs2.game;

import java.util.ArrayList;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Shelves {
    private ArrayList<Shelf> shelves;

    public Shelves(Image i, Integer[] resources, double alarmFrequency){
        shelves = new ArrayList<Shelf>(); 
        
        int type = (int)(Math.random() * 3 + 1); 
        switch (type) {
            case 1:
                lineShelves(i, shelves, resources, alarmFrequency);
                break;
            case 2: 
                circleShelves(i, shelves, resources, alarmFrequency);
                break;
            case 3: 
                randomShelves(i, shelves, resources, alarmFrequency);
                break;
            default:
                lineShelves(i, shelves, resources, alarmFrequency);
                break;
        }
    }

    private void lineShelves(Image i, ArrayList<Shelf> shelves, Integer[] resources, double alarmFrequency){
        
        for(int x = 0; x < 5; x++){
            for(int y = 0; y < 8; y++){
                shelves.add(new Shelf(i, new Vec2((300 * x), (100 * y)), resources, alarmFrequency));
            }
        }
    }

    private void randomShelves(Image i, ArrayList<Shelf> shelves, Integer[] resources, double alarmFrequency){
            for(int x = 0; x < 5; x++){
                for(int y = 0; y < 8; y++){
                    if(0.5 < Math.random()){
                        shelves.add(new Shelf(i, new Vec2((300 * x), (100 * y)), resources, alarmFrequency));
                    }
                }
            }
    }

    private void circleShelves(
        Image i,
        ArrayList<Shelf> shelves,
        Integer[] resources,
        double alarmFrequency) {

        double centerX = 750;
        double centerY = 350;
        double radius = 300;

        int numberOfShelves = 20;

        for (int n = 0; n < numberOfShelves; n++) {

            double angle = 2 * Math.PI * n / numberOfShelves;

            double x = centerX + radius * Math.cos(angle);
            double y = centerY + radius * Math.sin(angle);

            shelves.add(
                new Shelf(
                    i,
                    new Vec2(x, y),
                    resources,
                    alarmFrequency
                )
            );
        }
    }
    
    public void update(double deltaTime) {
        for (Shelf sh : shelves) {
            sh.update(deltaTime);
        }
    }
}
