package cs2.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TransScreen implements Screen {

    private GraphicsContext g;
    static final Image store1 = new Image("file:imgs/liqa_sto.png",250,250,true,true);
    static final Image store2 = new Image("file:imgs/shindig_town.png", 250,250,true,true);
    static final Image store3 = new Image("file:imgs/snacs.png",250,250,true,true);
    Font Daydream = Font.loadFont(getClass().getResourceAsStream("/fonts/Daydream.otf"),100);


    public TransScreen(GraphicsContext g) {
        this.g = g;
    }

    public void draw1() { // this one is for transitioning from a party to a heist
        g.setFill(Color.web("#000000"));
        g.fillRect(0, 0, 1280, 720);
        g.drawImage(store3, 65, 400);
        g.drawImage(store2, 490, 400);
        g.drawImage(store1, 915, 400);
    }

    public void draw2() { // this one is for transitioning from a heist to a party
        g.setFill(Color.BLACK);
        g.fillRect(0, 0, 1280, 720);
        g.setFont(Daydream);
        g.setFill(Color.WHITE);
        g.fillText("TEST", 100, 100);
    }

    public void renderP2H() {
        draw1();
    }

    public void renderH2P() {
        draw2();
    }

    @Override
    public void render() {
    }
    @Override
    public void update() {
    }
}
