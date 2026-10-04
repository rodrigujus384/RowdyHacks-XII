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
  static final int gridCellSize = 30;
  static final int scaleMult = 3;
  static final int scale = gridCellSize * scaleMult;
  static final Image Default = new Image("file:imgs/ImageNotFound.png");
  static final Image playerImg = new Image("file:imgs/roadrunner.png", scale, scale, true, true);
  static final Image playerImgLeft = new Image("file:imgs/roadrunner2.png", scale, scale, true, true);
  static final Image playerGif = new Image("file:imgs/player_run.gif", scale, scale, true, true);
  static final Image playerGifLeft = new Image("file:imgs/player_run2.gif", scale, scale, true, true);
  static final Image playerPFP = new Image("file:imgs/roadrunner_pfp.png");
  static final Image friendPFP = new Image("file:imgs/friend_pfp.png");
  static final Image NPCcontact = new Image("file:imgs/friend_pfp.png", 75, 75, true, true);
  static final Image Bubble = new Image("file:imgs/speech_bubble.png", 75, 75, true, true);
  static final Image Store1 = new Image("file:imgs/store_floor1.png", scale, scale, true, true);
  static final Image HouseFloor = new Image("file:imgs/house_floor1.png", scale, scale, true, true);


  // Variables initialized
  //Set<KeyCode> inputs = new HashSet<KeyCode>();
  static int GameStatus = 0; // 0 = title screen, 1 = intro, 2 = party, 3 = heist, 4 = end, 5 = how to screen, 6 p2h, 7 = h2p
  int storyAcum;
  int heistAcum;
  int type; 
  Set<KeyCode> inputs = new HashSet<KeyCode>();
  static int PartyNum = 1;
  int GuestLock = 0;
  static KeyPrompt kp = new KeyPrompt();



  //'resources'
  static Integer guestHappiness = 30;
  static Integer musicVolume = 3;
  static Integer noiseComplaint = 0;
  static Integer snacks = 4;
  static Integer alcohol = 4;
  static Integer partySupplies = 4;
  static double moveSpeed = 9; 

  //Intializes Screens 
  StartScreen startScreen;
  HowToPlayScreen howScreen;
  Intro IntroScreen;
  Heist heistScreen; 
  TransScreen TransScreen;
  Party PartyScreen;
  Outro OutroScreen;

  //Intialize Selected Store for Heist 
  String selectedStore;
  Integer selectedResource;  


  @SuppressWarnings("incomplete-switch")
  public void start(Stage stage) {
    stage.setTitle("Party Animal");
    stage.show();
    Canvas canvas = new Canvas(1280,720);
    stage.setScene(new Scene(new StackPane(canvas)));
    stage.setAlwaysOnTop(true);
    GraphicsContext g = canvas.getGraphicsContext2D();

    startScreen = new StartScreen(g, new Image("file:imgs/roadrunner_pfp.png"), new Image("file:imgs/roadrunner.png") );
    howScreen = new HowToPlayScreen(g);
    IntroScreen = new Intro(g);
    heistScreen = new Heist(g, 15, 15, selectedResource, selectedStore); 
    PartyScreen = new Party(g, 15, 15);
    OutroScreen = new Outro(g);

    type = 0; 
    TransScreen = new TransScreen(g, TransScreen.store3, TransScreen.store2, TransScreen.store1);

    //CLICKABLES
    canvas.setOnMouseClicked(event -> {
            if (GameStatus == 0) { 
              if(startScreen.isButtonClick(event.getX(), event.getY()) == 1) {GameStatus = 1;}
              else if(startScreen.isButtonClick(event.getX(), event.getY()) == 2) {GameStatus = 5;}
              else {System.out.println("Nothing was clicked");}
            }else if (GameStatus == 5) {
              if(howScreen.isButtonClick(event.getX(), event.getY())) {GameStatus = 0;}
            }
            if (GameStatus == 6) { 
              if(TransScreen.isButtonClick(event.getX(), event.getY()) == 1) {
                selectedStore = "Snacks";
                selectedResource = snacks;
              }
              else if(TransScreen.isButtonClick(event.getX(), event.getY()) == 2) {
                selectedStore = "Party Supplies";
                selectedResource = partySupplies;
              }
              else if (TransScreen.isButtonClick(event.getX(), event.getY()) == 3) {
                selectedStore = "Alcohol";
                selectedResource = alcohol;
              }
              heistScreen = new Heist(g, 15, 15, selectedResource, selectedStore); 
              GameStatus = 3; 
            }
      });

    // TIMER START
    AnimationTimer timer = new AnimationTimer() {
      public void handle(long t) {
      
        if (guestHappiness > 100) {guestHappiness = 100;}
        if (musicVolume > 10) {musicVolume = 10;}
        if (noiseComplaint > 10) {noiseComplaint = 10;}
        if (alcohol > 100) {alcohol = 100;}
        if (snacks > 100) {snacks = 100;}
        if (partySupplies > 100) {partySupplies = 100;}
        
        // Title screen
        if (GameStatus == 0) {
          startScreen.render(); 
        }

        //INTRO
        else if (GameStatus == 1) {
        IntroScreen.render();
        if (Intro.storyAcum >= 25*60) {GameStatus = 2;}
      }

        //PARTY GAME
        else if (GameStatus == 2) {  
          if (GuestLock == 0) {
            PartyScreen.invite();
            }
          GuestLock ++;


          canvas.setFocusTraversable(true);
          canvas.requestFocus();
          canvas.setOnKeyPressed(e -> {
            inputs.add(e.getCode());
          });
          
          // if (inputs.contains(KeyCode.Z)) {guestHappiness--;}
          // if (inputs.contains(KeyCode.X)) {guestHappiness++;}

          if (snacks < 1) {guestHappiness--;}
          if (alcohol < 1) {guestHappiness--;}
          if (partySupplies < 1) {guestHappiness--;}
          if (musicVolume > 80) {noiseComplaint++;}

          PartyScreen.update(inputs);
          PartyScreen.render();

          PartyScreen.checkIn();

          canvas.setOnKeyReleased(e -> {
            inputs.remove(e.getCode());
          });

          if (noiseComplaint > 99) {GameStatus = 6; GuestLock = 0;}
          if (guestHappiness < 0) {GameStatus = 6; GuestLock = 0;}
          if (GuestLock > 300*60) {GameStatus = 4;}
      }

        // HEIST GAME
        else if (GameStatus == 3) {
          heistAcum++;
          System.out.println(heistAcum);
          canvas.setFocusTraversable(true);
          canvas.requestFocus();
          canvas.setOnKeyPressed(e -> {
            inputs.add(e.getCode());
          });
          
          heistScreen.update(inputs);
          heistScreen.render();

          canvas.setOnKeyReleased(e -> {
            inputs.remove(e.getCode());
          });
          if (heistAcum > 30*60) {GameStatus = 7; heistAcum = 0;}
      }

      //END GAME
        else if (GameStatus == 4) {
          OutroScreen.render();
      }

        //how-to
        else if (GameStatus == 5) { 
          howScreen.render();
        }

        // TRANSITION 1
        else if (GameStatus == 6) {
          TransScreen.renderP2H();
      }

        // TRANSITION 2
        else if (GameStatus == 7) { 
          TransScreen.renderH2P();
        }

      
    }
    };
    timer.start();
  }
}
