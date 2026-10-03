package cs2.game;

import cs2.util.Vec2;
import javafx.scene.image.Image;

public class Moving extends Sprite {
  private Vec2 vel; // the velocity/speed the bullet should move
  boolean PB;

  //This constructor should initialize all fields
  //**Remember that some fields are inherited from Sprite
  public Moving(Image bul, Vec2 p, Vec2 v, boolean b) { 
    super(bul, p);
    vel = v;
    PB = b;
  }

  // This method should update the position of the bullet by adding
  // the velocity to the current position
  public void update() { 
    pos.addThis(vel);
  }

  public Moving clone() {
    return new Moving(this.img, this.pos.clone(), this.vel.clone(), this.PB);
  }
}