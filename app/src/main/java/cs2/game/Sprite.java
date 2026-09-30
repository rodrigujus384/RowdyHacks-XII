package cs2.game;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Sprite {
  Image img; // the image to be displayed for this sprite
  protected Vec2 pos; // the current position of this sprite

  /* The remained of the constructors and methods should be uncommented
   * as you write your code. I recommend keeping your project in a state
   * that it can always be run, even if it doesn't do much.
   * Then slowly over time, you can un-comment and add in additional
   * features.
   * DO NOT TRY TO WRITE EVERYTHING ALL AT ONCE. IT WILL NOT WORK.
   */



  // The constructor should initialize the fields of the class
  public Sprite(Image i, Vec2 p) { 
    img = i;
    pos = p;
  }
  


  // This method should draw the image at the current position
  public void display(GraphicsContext g) { 
    g.drawImage(img, pos.getX(), pos.getY());
  }


  
  // This method should change the location/position of the sprite
  // by the amount specified in the parameter delta
  public void move(Vec2 delta) { 
    pos.addThis(delta);
  }
  
  public boolean intersection(Sprite other) {
    double thisLeft = this.pos.getX();
    double thisRight = this.pos.getX() + this.img.getWidth();
    double thisTop = this.pos.getY();
    double thisBottom = this.pos.getY() + this.img.getHeight();
    
    double otherLeft = other.pos.getX();
    double otherRight = other.pos.getX() + other.img.getWidth();
    double otherTop = other.pos.getY();
    double otherBottom = other.pos.getY() + other.img.getHeight();
    return ((otherRight >= thisLeft && otherLeft <= thisRight) && (otherBottom >= thisTop && otherTop <= thisBottom));
  }

  // public boolean Intersection(Sprite other) {
  //   boolean returned = false;
  //   double XRangeT = this.pos.getX() + 50;
  //   double YRangeT = this.pos.getX() + 50;
  //   double XRangeO = other.pos.getX() + 50;
  //   double YRangeO = other.pos.getY() + 50;
  //   if (other.pos.getX() > this.pos.getX() && other.pos.getX() < XRangeT) {
  //     if (other.pos.getY() > this.pos.getY() && other.pos.getY() < YRangeT) {
  //       returned = true;
  //     }
  //     else {returned = false;}
  //   }
  //   if (this.pos.getX() > other.pos.getX() && this.pos.getX() < XRangeO) {
  //     if (this.pos.getY() > other.pos.getY() && this.pos.getY() < YRangeO) {
  //       returned = true;
  //     }
  //     else {returned = false;}
  //   }
  //   return returned;
  // }
}
