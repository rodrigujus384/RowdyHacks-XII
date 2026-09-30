package cs2.game;

import cs2.util.Vec2;
import javafx.scene.image.Image;

public class Enemy extends Sprite {
  private Image bulletPicture;


  //This constructor should initialize all fields
  //**Remember that some fields are inherited from Sprite
  public Enemy(Image avatar, Image bulletPic, Vec2 p) { 
    // img = avatar;
    super(avatar, p);
    bulletPicture = bulletPic;
    //pos = p;
    
  }
  

  
  // This method should create a new Bullet object and return it
  // The Bullet should be initialized with the bulletPicture, the
  // current position of the enemy, and a velocity going down the screen
  public Bullet shoot() {
    Bullet Projectile = new Bullet(bulletPicture, new Vec2(pos.getX()+15, pos.getY()+25), new Vec2(0, 2*(SpaceGameApp.Difficulty)), false);
    return Projectile;
  }


  public Enemy clone() {
    return new Enemy(this.img, this.bulletPicture, this.pos.clone());
  }
}
