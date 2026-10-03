package cs2.game;

import cs2.util.Vec2;
import javafx.scene.image.Image;

public class Player extends Sprite {
  Image bulletPicture;
  double x = 0;


  //This constructor should initialize all fields
  //**Remember that some fields are inherited from Sprite
  public Player(Image avatar, Image bullPic, Vec2 p) {
    super(avatar, p);
    bulletPicture = bullPic;
   }



  // This method should create a new Bullet object and return it
  // The Bullet should be initialized with the bulletPicture, the
  // current position of the player, and a velocity going up the screen
  public Bullet shoot(double x) { 
    Bullet Projectile = new Bullet(bulletPicture, new Vec2(pos.getX()+x, pos.getY()-15), new Vec2(0,-3), true);
    return Projectile;
  }



  public void moveLeft() { 
    if (!MainApp.Powerup) {x = 5;} else if (MainApp.Powerup) {x = 10;}
    if (MainApp.PlayerWho == "Matthew") {x = 1.5*x;}
    Vec2 left = new Vec2(-x, 0);
    if (pos.getX() > 0)
      pos.addThis(left);
  }

  public void moveRight() { 
    if (!MainApp.Powerup) {x = 5;} else if (MainApp.Powerup) {x = 10;}
    if (MainApp.PlayerWho == "Matthew") {x = 1.5*x;}
    Vec2 right = new Vec2(x,0);
    if (pos.getX() < 500-(this.img.getWidth()))
      pos.addThis(right);
  }

  public void moveUp() { 
    if (!MainApp.Powerup) {x = 5;} else if (MainApp.Powerup) {x = 10;}
    if (MainApp.PlayerWho == "Matthew") {x = 1.5*x;}
    Vec2 right = new Vec2(0,-x);
    if (pos.getY() > 0)
      pos.addThis(right);
  }

  public void moveDown() { 
    if (!MainApp.Powerup) {x = 5;} else if (MainApp.Powerup) {x = 10;}
    if (MainApp.PlayerWho == "Matthew") {x = 1.5*x;}
    Vec2 right = new Vec2(0, x);
    if (pos.getY() < 575)
      pos.addThis(right);
  }
}
