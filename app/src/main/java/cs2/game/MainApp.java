// THE GAME RUNS WITH
// ./gradlew run -Pmain=cs2.game.MainApp

package cs2.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


import cs2.util.Vec2;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainApp extends Application {
  
  // Images created
  static final Image ArloSprite = new Image("file:imgs/ImageNotFound.png");
  static final Image MatthewSprite = new Image("file:ImageNotFound.png");
  static final Image AudreySprite = new Image("file:BiAudrey.png");
  static final Image ArloBullet = new Image("file:Philippines.png");
  static final Image MatthewBullet = new Image("file:Radiohead.png");
  static final Image AudreyBullet = new Image("file:Banana.png");
  static final Image DylanSprite = new Image("file:BlueDylan.png");
  static final Image KarlSprite = new Image("file:KarlTime.png");
  static final Image EnemyBullet = new Image("file:Foot.png");
  static final Image planet = new Image("file:FTOplanet.png");
  static final Image Buff = new Image("file:HolePuncher.png");
  static final Image Default = new Image("file:imgs/ImageNotFound.png");
  


  // Variables initialized
  Player player = new Player(Default, Default, new Vec2(200, 575));
  EnemySwarm enemies = new EnemySwarm((int)(Math.random() * Difficulty)+2, (int)(Math.random() * Difficulty), DylanSprite, KarlSprite, EnemyBullet);
  Buff Punch = new Buff(Buff, new Vec2(250, 750), new Vec2(0, 5));
  ArrayList<Bullet> shots = new ArrayList<Bullet>();
  Set<KeyCode> inputs = new HashSet<KeyCode>();
  int PlayerLives = 3;
  int PlayerScore = 0;
  int HighScore = 0;
  boolean HSreset = true;
  int BCD = 0;
  int eBCD = 0;
  boolean BHere = false;
  int PUCount = 0;
  int PUdown = 300;
  static boolean Powerup = false;
  int GameStatus = 1; // 1 = start screen, 2 = gameplay, 3 = game over
  static int Difficulty = 0; // Difficulty scales 1-5
  int SwarmsKilled = 0;
  static String PlayerWho = "";
  Stack<GameState> history = new Stack<GameState>();

  @SuppressWarnings("incomplete-switch")
  public void start(Stage stage) {
    stage.setTitle("Party Animal");
    stage.show();
    Canvas canvas = new Canvas(1280,720);
    stage.setScene(new Scene(new StackPane(canvas)));
    GraphicsContext g = canvas.getGraphicsContext2D();
    // g.setFill(Color.rgb(39, 3, 94));
    // g.fillRect(0, 0, 500, 800);
    // g.drawImage(planet, 50, 675);

    AnimationTimer timer = new AnimationTimer() {
      public void handle(long t) {
        
        // Title screen
        if (GameStatus == 1) {
          g.setFill(Color.rgb(4, 201, 184));
          g.fillRect(0, 0, 1280,720);
          g.setFill(Color.rgb(238, 73, 43));
          g.fillRect(25, 25, 450, 750);
          g.setFill(Color.rgb(245, 134, 45));
          g.fillRect(50, 50, 400, 700);
          g.setFill(Color.rgb(255, 191, 67));
          g.fillRect(100, 100, 300, 600);
          g.setFill(Color.rgb(59, 15, 42));
          g.setFont(new Font("Bright DEMO", 40));
          g.fillText("FTO Board Saves the World!", 50, 200);
          g.fillText("Select a character to begin", 60, 300);
          g.fillText("Arrow Keys/WASD to move", 45, 250);
          g.fillText("SPACE to shoot", 150, 350);
          g.fillText("R to rewind", 175, 400);

          g.drawImage(ArloSprite, 115, 500);
          g.drawImage(MatthewSprite, 315, 500);
          g.drawImage(AudreySprite, 215, 600);

          if (GameStatus == 1) {
            canvas.setOnMouseClicked(e -> {
              if ((e.getX() > 115 && e.getX() < 194) && (e.getY() > 500 && e.getY() < 581)) {
                player.img = ArloSprite;
                player.bulletPicture = ArloBullet;
                PlayerWho = "Arlo";
                GameStatus = 2; PlayerLives = 3; PlayerScore = 0;
              }
              if ((e.getX() > 315 && e.getX() < 388) && (e.getY() > 500 && e.getY() < 585)) {
                player.img = MatthewSprite;
                player.bulletPicture = MatthewBullet;
                PlayerWho = "Matthew";
                GameStatus = 2; PlayerLives = 3; PlayerScore = 0;
              }
              if ((e.getX() > 215 && e.getX() < 295) && (e.getY() > 600 && e.getY() < 680)) {
                player.img = AudreySprite;
                player.bulletPicture = AudreyBullet;
                PlayerWho = "Audrey";
                GameStatus = 2; PlayerLives = 3; PlayerScore = 0;
              }
            });

            // canvas.setOnMouseMoved(e -> {
            //   if ((e.getX() > 115 && e.getX() < 194) && (e.getY() > 500 && e.getY() < 581)) {
            //     System.out.println("ARLO ARLO ARLO!");
            //   }
            // });
        }
        }

        // Gameplay
        if (GameStatus == 2) {

          canvas.setFocusTraversable(true);
          canvas.requestFocus();
          canvas.setOnKeyPressed(e -> {
            inputs.add(e.getCode());
          });

          g.setFill(Color.rgb(39, 3, 94));
          g.fillRect(0, 0, 500, 800);
          g.drawImage(planet, 50, 675);
          g.setFill(Color.WHITE);
          g.setFont(new Font("Bright DEMO", 12));
          g.fillText("Lives: " + PlayerLives, 50, 20);
          g.fillText("Score: " + PlayerScore, 85, 20);
          if (!Powerup) {g.fillText("Hole Punches: " + PUCount, 50, 40);}
          else if (Powerup) {g.fillText("POWERUP ACTIVATED", 50, 40);}
          player.display(g);
          enemies.display(g);
          for (Bullet b : shots){
            b.display(g);
          }

          if (inputs.contains(KeyCode.R) && !history.isEmpty()) {
            history.pop();
            GameState reset = history.pop();
            player.pos = reset.PlayerPos;
            enemies = reset.EnemyState;
            shots = reset.BulletState;
            PlayerLives = reset.PLives;
            PlayerScore = reset.PScore;
            HighScore = reset.HS;
            HSreset = reset.HSR;
            BHere = reset.BuffHere;
            PUCount = reset.PowerUpCount;
            PUdown = reset.PowerUpDown;
            Powerup = reset.PowerUp;
            Punch.pos = reset.BuffPos;
          }
          else {
          if (inputs.contains(KeyCode.UP) || inputs.contains(KeyCode.W)) {player.moveUp();}
          if (inputs.contains(KeyCode.LEFT) || inputs.contains(KeyCode.A)) {player.moveLeft();}
          if (inputs.contains(KeyCode.RIGHT) || inputs.contains(KeyCode.D)) {player.moveRight();}
          if (inputs.contains(KeyCode.DOWN) || inputs.contains(KeyCode.S)) {player.moveDown();}
          if (inputs.contains(KeyCode.SPACE)) {
            if (BCD < 0 && PlayerLives > 0) {
              if (PlayerWho != "Arlo") {shots.add(player.shoot(25));}
              else if (PlayerWho == "Arlo") {shots.add(player.shoot(0)); shots.add(player.shoot(50));} 
              if (!Powerup) {BCD = 30;} else if (Powerup) {BCD = 5;}}}
          

          g.setFill(Color.rgb(39, 3, 94));
          g.fillRect(0, 0, 500, 800);
          g.drawImage(planet, 50, 675);
          g.setFill(Color.WHITE);
          g.setFont(new Font("Bright DEMO", 12));
          g.fillText("Lives: " + PlayerLives, 50, 20);
          g.fillText("Score: " + PlayerScore, 85, 20);
          if (!Powerup) {g.fillText("Hole Punches: " + PUCount, 50, 40);}
          else if (Powerup) {g.fillText("POWERUP ACTIVATED", 50, 40);}
          // g.fillText("Difficulty: " + Difficulty, 150, 20);
          // g.fillText("Swarms Killed: " + SwarmsKilled, 150, 40);
          BCD--;
          eBCD--;
          // if (BCD < 0) {BCD = 0;}
          /* 
          g.save();
          g.translate(50, 1075);
          g.rotate(90);
          g.drawImage(planet, -planet.getWidth()/2, -planet.getHeight()/2);
          g.restore();
          */
          player.display(g); // Shows the player
          enemies.display(g); // Shows the enemies
          // shows all bullets
          for (Bullet b : shots) {
            b.update();
            b.display(g);
          }
          // Determines random enemy shooter
          if ((Math.random() < 0.005) && eBCD < 0) {
          shots.add(enemies.shoot());
          eBCD = 45;
          }

          // Randomly spawns buff
          if (BHere == false && !Powerup && Math.random() < 0.001) {
            BHere = true;
            Punch.display(g);
            Punch.pos = new Vec2(Math.floor(Math.random() * 751), 0);
          }
          else if (BHere == true) {
            Punch.display(g);
            Punch.update();
            if (Punch.pos.getY() > 800) {
              BHere = false;
            }
          }
          
          // Loop through all bullets
          for (int i=0; i<shots.size(); i++) {
            Bullet b = shots.get(i);
            // Bullet hits player
            if (player.intersection(b) && !b.PB) {
              if (!Powerup) {PlayerLives--;
              player.pos.addThis(new Vec2(-(player.pos.getX()), -(player.pos.getY())));
              player.pos.addThis(new Vec2(200, 575));}
              shots.remove(b);
            }
            // Bullet hits an enemy
            for (int j=0; j<enemies.swarm.size(); j++) {
              Enemy e = enemies.swarm.get(j);
              if (b.PB && e.intersection(b)) {
                enemies.swarm.remove(e);
                PlayerScore += 100;
                if (!Powerup) {shots.remove(b);} // powerup changes this
              }
            }
            // Bullets hit each other
            for (int k = 0; k < shots.size(); k++) {
              Bullet d = shots.get(k);
              if (b.intersection(d) && b != d) {
                if (!Powerup && !b.PB) {shots.remove(b); shots.remove(d);}
              }
            }
            // Bullets off screen
            if (b.pos.getY() < -50 || b.pos.getY() > 800) {
              shots.remove(b);
            }
          }
          // Loops through all the enemies
          for (int i = 0; i < enemies.swarm.size(); i++) {
          Enemy e = enemies.swarm.get(i);
          if (player.intersection(e)) {
              PlayerLives--;
              player.pos.addThis(new Vec2(-(player.pos.getX()), -(player.pos.getY())));
              player.pos.addThis(new Vec2(200, 575));
            }
          }

          if (player.intersection(Punch)) {
            BHere = false;
            PUCount++;
            Punch.pos = new Vec2(0, 750);
          }
          
          // Resetting EnemySwarm
          if (enemies.swarm.isEmpty()) {
            SwarmsKilled++;
            enemies = new EnemySwarm((int)(Math.random() * Difficulty)+2, (int)(Math.random() * Difficulty), DylanSprite, KarlSprite, EnemyBullet);
            shots.clear();
            //System.out.println(SwarmsKilled);
          }
          // Player dying
          if (PlayerLives < 1) {
            GameStatus = 3;
          }

          if (SwarmsKilled > 9) {
            Difficulty++;
            SwarmsKilled = 0;
          }

          if (PUCount > 3) {
            Powerup = true;
            PUdown--;
          }
          if (PUdown < 1) {
            Powerup = false;
            PUCount = 0;
            PUdown = 300;
          }

          canvas.setOnKeyReleased(e -> {
            inputs.remove(e.getCode());
          });

          // GameState stack
          GameState now = new GameState(player.pos, enemies, shots, PlayerLives, PlayerScore, HighScore, HSreset, BHere, PUCount, PUdown, Powerup, Punch.pos);
          history.push(now);          
          }
      }

      // Death screen
      if (GameStatus == 3) {
        g.setFill(Color.BLACK);
        g.fillRect(0, 0, 500, 800);
        g.setFill(Color.RED);
        g.setFont(new Font("Bright DEMO", 20));
        g.fillText("You Died", 195, 200);
        g.setFill(Color.WHITE);
        g.fillText("Press Enter to restart", 160, 225);
        g.fillText("Final Score: " + PlayerScore, 170, 250);
        if (PlayerScore > HighScore) {
          HighScore = PlayerScore;
          HSreset = false;
        }
        if (HSreset == false) {
          g.fillText("NEW High Score!", 170, 300);
        }
        g.fillText("High Score:" + HighScore, 170, 275);

        Difficulty = 1;
        enemies = new EnemySwarm((int)(Math.random() * Difficulty)+2, (int)(Math.random() * Difficulty), DylanSprite, KarlSprite, EnemyBullet);

        canvas.setOnKeyPressed(e -> {
        switch (e.getCode()) {
        case ENTER:
          if (GameStatus == 1 || GameStatus == 3) {GameStatus = 1; PlayerLives = 3; PlayerScore = 0; history.clear(); HSreset = true; Powerup = false; PUCount = 0;}
      }
    });
      }
    }
    };
    timer.start();
  }
}
