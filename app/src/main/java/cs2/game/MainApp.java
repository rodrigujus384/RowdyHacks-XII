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
import javafx.scene.image.Image;

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
  int GameStatus = 0; // 0 = title screen, 1 = intro, 2 = party, 3 = heist, 4 = end
  //Intializes Screens 
  StartScreen startScreen;


  @SuppressWarnings("incomplete-switch")
  public void start(Stage stage) {
    stage.setTitle("Party Animal");
    stage.show();
    Canvas canvas = new Canvas(1280,720);
    stage.setScene(new Scene(new StackPane(canvas)));
    GraphicsContext g = canvas.getGraphicsContext2D();

    startScreen = new StartScreen(g, new Image("file:/Users/jordancarter/Desktop/RowdyHacks/RowdyHacks-XII/app/imgs/roadrunner_pfp.png"), new Image("file:/Users/jordancarter/Desktop/RowdyHacks/RowdyHacks-XII/app/imgs/roadrunner.png") );
    canvas.setOnMouseClicked(event -> {
            if(startScreen.isButtonClick(event.getX(), event.getY()) == 1) { System.out.println("Start");}
            else if(startScreen.isButtonClick(event.getX(), event.getY()) == 2) {System.out.println("How to Play");}
            else {System.out.println("Nothing was clicked");}
      });

    // TIMER START
    AnimationTimer timer = new AnimationTimer() {
      public void handle(long t) {
        
        // Title screen
        if (GameStatus == 0) {
          startScreen.render(); 
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