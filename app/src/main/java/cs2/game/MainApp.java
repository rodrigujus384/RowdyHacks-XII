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
  static final Image Bubble = new Image("file:imgs/speech_bubble.png", 75, 75, true, true);
  


  // Variables initialized
  Player player = new Player(Default, Default, new Vec2(200, 575));
  //Set<KeyCode> inputs = new HashSet<KeyCode>();
  int GameStatus = 0; // 0 = title screen, 1 = intro, 2 = party, 3 = heist, 4 = end
  int storyAcum;
  //Intializes Screens 
  StartScreen startScreen;
  HowToPlayScreen howScreen;


  @SuppressWarnings("incomplete-switch")
  public void start(Stage stage) {
    stage.setTitle("Party Animal");
    stage.show();
    Canvas canvas = new Canvas(1280,720);
    stage.setScene(new Scene(new StackPane(canvas)));
    GraphicsContext g = canvas.getGraphicsContext2D();

    startScreen = new StartScreen(g, new Image("file:imgs/roadrunner_pfp.png"), new Image("file:imgs/roadrunner.png") );
    howScreen = new HowToPlayScreen(g, new Image("file:imgs/store_floor1.png"));

    canvas.setOnMouseClicked(event -> {
            if (GameStatus == 0) { 
              if(startScreen.isButtonClick(event.getX(), event.getY()) == 1) { System.out.println("Start");}
              else if(startScreen.isButtonClick(event.getX(), event.getY()) == 2) {GameStatus = 5;}
              else {System.out.println("Nothing was clicked");}
            }else{
              if(howScreen.isButtonClick(event.getX(), event.getY())) {GameStatus = 0;}
            }
      });

    // TIMER START
    AnimationTimer timer = new AnimationTimer() {
      public void handle(long t) {
        
        // Title screen
        if (GameStatus == 0) {
          startScreen.render(); 
        }

        else if (GameStatus == 1) {
      }

        else if (GameStatus == 2) {
      }

        else if (GameStatus == 3) {
      }

        else if (GameStatus == 4) {
      }

        else if (GameStatus == 5) { 
          System.out.println("Rendering How Screen");
          howScreen.render();
        }

      
    }
    };
    timer.start();
  }
}