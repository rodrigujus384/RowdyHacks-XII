package cs2.game;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;

public class Player extends Sprite {

  public Player() {
    super(MainApp.playerImg, new Vec2(0,0));
  }
 
  public void display(GraphicsContext g) { 
    g.drawImage(img, 640, 360);
  }

  public Vec2 getGridPos(){
    return new Vec2(
      Math.round(this.pos.getX()/MainApp.gridCellSize), 
      Math.round(this.pos.getY()/MainApp.gridCellSize));
  }

  public void moveLeft() {
      this.move(new Vec2(-MainApp.moveSpeed, 0));
  }
  public void moveRight() {
      this.move(new Vec2(MainApp.moveSpeed, 0));
  }
  public void moveUp() { 
      this.move(new Vec2(0, -MainApp.moveSpeed));
  }
  public void moveDown() { 
      this.move(new Vec2(0, MainApp.moveSpeed));
  }
}
