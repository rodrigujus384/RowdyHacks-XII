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
  static final Image playerPFP = new Image("file:imgs/roadrunner_pfp.png");
  static final Image friendPFP = new Image("file:imgs/friend_pfp.png");
  static final Image NPCcontact = new Image("file:imgs/friend_pfp.png", 75, 75, true, true);
  


  // Variables initialized
  Player player = new Player(Default, Default, new Vec2(200, 575));
  //Set<KeyCode> inputs = new HashSet<KeyCode>();
  int GameStatus = 1; // 0 = title screen, 1 = intro, 2 = party, 3 = heist, 4 = end



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

        // story screen
      if (GameStatus == 1) {
        g.setFill(Color.rgb(78, 179, 247));
        g.fillRect(0, 0, 1280,720);
        g.setFill(Color.rgb(255, 255, 255));
        g.fillRect(440, 0, 400,720);
        g.setFill(Color.rgb(0, 0, 0));
        g.fillRect(440, 0, 400, 50);
        g.fillRect(440, 670, 400, 50);
        g.fillRect(440, 0, 25, 720);
        g.fillRect(815, 0, 25, 720);
        g.setFill(Color.rgb(50, 50, 50));
        g.fillOval(625, 680, 30, 30);
        g.setFill(Color.rgb(207, 207, 207));
        g.fillRect(465, 50, 350, 75);
        g.drawImage(NPCcontact, 600, 55);
        g.drawImage(friendPFP, 480, 150);
        g.drawImage(playerPFP, 750, 250);
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