package cs2.game;

import java.util.ArrayList;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class EnemySwarm {
  ArrayList<Enemy> swarm;


  // This constructor should create a swarm of enemies in a grid
  // The grid should be nRows x nCols in size.
  // The enemPic and bullPic should be used to create the Enemy instances
  // that are added to the ArrayList. The enemies should be spaced out
  // in a grid pattern across the top of the screen.
  public EnemySwarm(int nRows, int nCols, Image enemPic1, Image enemPic2, Image bullPic) { 
    swarm = new ArrayList<>();

    double startX = 50;
    double startY = 50;
    double spacingX = 60;
    double spacingY = 60;
    boolean wah = true;

    for (int i=0; i < nRows; i++) {
      for (int j=0; j < nCols; j++) {
        double x = startX + i * spacingX;
        double y = startY + j * spacingY;
        if (wah) {
        swarm.add(new Enemy(enemPic1, bullPic, new Vec2(x, y)));
        if (Math.random() < 0.5) {
          wah = !wah;
        }
        }
        else if (!wah) {
          swarm.add(new Enemy(enemPic2, bullPic, new Vec2(x, y)));
          if (Math.random() < 0.5) {
            wah = !wah;
          }
        }
      }
    }
  }

    public EnemySwarm() {
      swarm = new ArrayList<>();
    }


  // This method should display all enemies in the swarm
  public void display(GraphicsContext g) { 
    for (Enemy e : swarm) {
      e.display(g);
    }
  }



  // This method should choose one enemy at random from the swarm,
  // and have that enemy shoot a bullet. Return that Bullet.
  public Bullet shoot() { 
      int index = (int)(Math.random() *swarm.size());
      Enemy shooter = swarm.get(index);
      return shooter.shoot();
  }


  public EnemySwarm clone() {
    EnemySwarm other = new EnemySwarm();
    for (Enemy e : swarm) {
    other.swarm.add(e.clone());
    }
    return other;
  }
}
