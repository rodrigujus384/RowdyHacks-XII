package cs2.game;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Sprite {
  Image img; 
  protected Vec2 pos; 

  public Sprite(Image i, Vec2 p) { 
    img = i;
    pos = p;
  }

  public Vec2 getPos(){
    return pos;
  }

  public double getWidth(){ 
    return img.getWidth();
  }

  //Returns the current sprite's height
  public double getHeight(){
    return img.getHeight(); 
  }
  
  public void display(GraphicsContext g) { 
    g.drawImage(img, pos.getX(), pos.getY());
  }

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
}
