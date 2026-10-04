package cs2.game;

import cs2.util.Vec2;
import javafx.scene.image.Image;

public class Guest extends GameSprite {

    public Guest(Image i, Vec2 p) {
        super(i, p);
    }

    public void moveLeft(int x) {
      this.move(new Vec2(-x, 0));
    }
    public void moveRight(int x) {
      this.move(new Vec2(x, 0));
    }
    public void moveUp(int x) { 
      this.move(new Vec2(0, -x));
    }
    public void moveDown(int x) { 
      this.move(new Vec2(0, x));
    }

    public void roam() {
        if (Math.random() < 0.003) {
            int rand = (int) (Math.random() * 3) + 1;
            int choice = (int) (Math.random() * 4) + 1;
            if (choice == 1) {this.moveUp(rand);}
            if (choice == 2) {this.moveRight(rand);}
            if (choice == 3) {this.moveDown(rand);}
            if (choice == 4) {this.moveLeft(rand);}
        }
    }

}
