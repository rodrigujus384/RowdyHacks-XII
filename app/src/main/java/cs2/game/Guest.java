package cs2.game;

import java.util.ArrayList;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Guest extends GameSprite {

  static final Image one = new Image("file:imgs/guest1.png", MainApp.scale, MainApp.scale, true, true);
  static final Image two = new Image("file:imgs/guest2.png", MainApp.scale, MainApp.scale, true, true);
  static final Image three = new Image("file:imgs/guest3.png", MainApp.scale, MainApp.scale, true, true);
  static final Image four = new Image("file:imgs/guest4.png", MainApp.scale, MainApp.scale, true, true);
  static final Image five = new Image("file:imgs/guest5.png", MainApp.scale, MainApp.scale, true, true);
  static final Image six = new Image("file:imgs/guest6.png", MainApp.scale, MainApp.scale, true, true);
  static final Image seven = new Image("file:imgs/guestCharlie.png", MainApp.scale, MainApp.scale, true, true);
  static final Image eight = new Image("file:imgs/guestJordan.png", MainApp.scale, MainApp.scale, true, true);
  static final Image nine = new Image("file:imgs/guestJustin.png", MainApp.scale, MainApp.scale, true, true);


    public Guest(Image i, Vec2 p) {
      super(randomSkin(), p);
      this.interactable = true;
    }

    public static Image randomSkin() {
      int imag = (int) (Math.random() * 21) + 1;
      if (imag == 1 || imag == 2 || imag == 3) {return one;}
      if (imag == 4 || imag == 5 || imag == 6) {return two;}
      if (imag == 7 || imag == 8 || imag == 9) {return three;}
      if (imag == 10 || imag == 11 || imag == 12) {return four;}
      if (imag == 13 || imag == 14 || imag == 15) {return five;}
      if (imag == 16 || imag == 17 || imag == 18) {return six;}
      if (imag == 19) {return seven;}
      if (imag == 20) {return eight;}
     else {return nine;}
    }

    public void Hunger() {
      if (Math.random() < 0.0005) {
        MainApp.snacks--;
      }
    }
    
    public void Thirst() {
      if (Math.random() < 0.001) {
        MainApp.alcohol--;
      }
    }

    public void moveLeft(int x) {
      this.moveAlongGrid(-x, 0);
    }
    public void moveRight(int x) {
      this.moveAlongGrid(x, 0);
    }
    public void moveUp(int x) { 
      this.moveAlongGrid(0, -x);
    }
    public void moveDown(int x) { 
      this.moveAlongGrid(0, x);
    }

    public void display(GraphicsContext g) { 
      g.drawImage(img, pos.getX(), pos.getY());
  }
    
    public void roam() {
        if (Math.random() < 0.03) {
            int rand = (int) (Math.random() * 3) + 1;
            int choice = (int) (Math.random() * 4) + 1;
            if (choice == 1) {this.moveUp(rand);}
            if (choice == 2) {this.moveRight(rand);}
            if (choice == 3) {this.moveDown(rand);}
            if (choice == 4) {this.moveLeft(rand);}
        }
    }

}
