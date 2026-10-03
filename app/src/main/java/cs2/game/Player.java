package cs2.game;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;

public class Player extends Sprite {
  double moveSpeed = 3;

  public Player() {
    super(MainApp.playerImg, new Vec2(0,0));
  }
 
  public void display(GraphicsContext g) { 
    g.drawImage(img, 640, 360);
  }

  public void moveLeft() {
    if (pos.getX() > 0)
      this.move(new Vec2(-moveSpeed, 0));
  }
  public void moveRight() {
    if (pos.getX() < 500-(this.img.getWidth()))
      this.move(new Vec2(moveSpeed, 0));
  }
  public void moveUp() { 
    if (pos.getY() > 0)
      this.move(new Vec2(0, -moveSpeed));
  }
  public void moveDown() { 
    if (pos.getY() < 575)
      this.move(new Vec2(0, moveSpeed));
  }
}
