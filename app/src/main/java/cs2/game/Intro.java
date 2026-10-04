package cs2.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

public class Intro implements Screen {

    private GraphicsContext g;
    static int storyAcum = 0;

    static final Image playerPFP = new Image("file:imgs/roadrunner_pfp.png");
    static final Image friendPFP = new Image("file:imgs/friend_pfp.png");
    static final Image NPCcontact = new Image("file:imgs/friend_pfp.png", 75, 75, true, true);
    static final Image Bubble1 = new Image("file:imgs/speech_bubble.png", 75, 75, true, true);
    static final Image Bubble2 = new Image("file:imgs/speech_bubble_reverse.png", 75, 75, true, true);
    static final Image text1 = new Image("file:imgs/convo1.png");
    static final Image text2 = new Image("file:imgs/convo2.png");
    static final Image text3 = new Image("file:imgs/convo3.png");
    static final Image text4 = new Image("file:imgs/convo4.png");
    static final Image text5 = new Image("file:imgs/convo5.png");

    public Intro(GraphicsContext g){
        this.g = g;
    }

    private void draw(){
        storyAcum ++;
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
        if (storyAcum >= 2*60) {g.drawImage(friendPFP, 480, 150);}
        if (storyAcum >= 2*60 && storyAcum < 7*60) {g.drawImage(Bubble1, 530, 135);}
        if (storyAcum >= 7*60) {g.drawImage(text1, 540, 150);}
        if (storyAcum >= 10*60) {g.drawImage(playerPFP, 750, 250);}
        if (storyAcum >= 10*60 && storyAcum < 12*60) {g.drawImage(Bubble2, 675, 235);}
        if (storyAcum >= 12*60) {g.drawImage(text2, 480, 250);}

        if (storyAcum >= 13*60) {g.drawImage(friendPFP, 480, 350);}
        if (storyAcum >= 13*60 && storyAcum < 16*60) {g.drawImage(Bubble1, 530, 335);}
        if (storyAcum >= 16*60) {g.drawImage(text3, 540, 350);}
        if (storyAcum >= 17*60) {g.drawImage(playerPFP, 750, 450);}
        if (storyAcum >= 17*60 && storyAcum < 18*60) {g.drawImage(Bubble2, 675, 435);}
        if (storyAcum >= 18*60) {g.drawImage(text4, 480, 450);}

        if (storyAcum >= 19*60) {g.drawImage(friendPFP, 480, 550);}
        if (storyAcum >= 20*60 && storyAcum < 21*60) {g.drawImage(Bubble1, 530, 535);}
        if (storyAcum >= 21*60) {g.drawImage(text5, 540, 550);}
        }

    public boolean isButtonClicked(){
        return false; 
    }

    @Override
    public void update() {
        
        }

    @Override
    public void render() {
       draw();
    }
}
