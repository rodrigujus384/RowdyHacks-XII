// THE GAME RUNS WITH
// ./gradlew run -Pmain=cs2.game.MainApp

package cs2.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


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

@SuppressWarnings("unused")
public class MainApp extends Application {
  
  // Images created
  static final Image Default = new Image("file:imgs/ImageNotFound.png");
  


  // Variables initialized
  Player player = new Player(Default, Default, new Vec2(200, 575));
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
  int GameStatus = 0; // 0 = title screen, 1 = intro, 2 = party, 3 = heist, 4 = end
  static int Difficulty = 0; // Difficulty scales 1-5
  int SwarmsKilled = 0;
  static String PlayerWho = "";


  @SuppressWarnings("incomplete-switch")
  public void start(Stage stage) {
    stage.setTitle("Party Animal");
    stage.show();
    Canvas canvas = new Canvas(1280,720);
    stage.setScene(new Scene(new StackPane(canvas)));
    GraphicsContext g = canvas.getGraphicsContext2D();

    // TIMER START
    AnimationTimer timer = new AnimationTimer() {
      public void handle(long t) {
        
        // Title screen
        if (GameStatus == 0) {
          g.setFill(Color.rgb(176, 90, 9));
          g.fillRect(0, 0, 1280,720);
        }

        if (GameStatus == 1) {
      }

      if (GameStatus == 2) {
      }

      if (GameStatus == 3) {
      }

      if (GameStatus == 4) {
      }
    }
    };
    timer.start();
  }
}