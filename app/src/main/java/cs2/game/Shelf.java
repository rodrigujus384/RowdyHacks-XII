package cs2.game;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Shelf extends GameSprite{
    static Integer resources; 

    boolean isAlarm;
    boolean isAlert; 

    double alarmTimer; 
    double alertTimer = 2.0;
    double timePassed = 0; 

    public Shelf(Image i, Vec2 p, double alarmfrequency) {
        super(i, p);
        
        this.resources = (int)(Math.random() * 6);
        this.isAlarm = alarmInstall(alarmfrequency);
    }

    private boolean alarmInstall(double alarmfrequncy){
        double odds = Math.random();
        if(odds < alarmfrequncy){ 
            this.isAlert = false; 
            this.alarmTimer = Math.random() * 4 + 3;
            return true; 
        }

        return false; 
    }   

    public void update(double deltaTime) {
        if (!isAlarm) {
            return;
        }

        timePassed += deltaTime;

        if (!isAlert) {
            if (timePassed >= alarmTimer) {
                isAlert = true;
                timePassed = 0;

                System.out.println("ALARM ON!");
            }
        } else {
            if (timePassed >= alertTimer) {
                isAlert = false;
                timePassed = 0;

                System.out.println("ALARM OFF!");
            }
        }
    }

    public static int removeResources(){
        System.out.println("Removed Resources");
        int temp = resources.intValue();
        resources.valueOf(0);
        return temp;
    }
    
}
