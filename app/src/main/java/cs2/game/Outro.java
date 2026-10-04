package cs2.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Outro implements Screen {
    
    private GraphicsContext g;
    Font DaydreamTitle = Font.loadFont(getClass().getResourceAsStream("/fonts/Daydream.otf"),50);
    Font DaydreamSubtitle = Font.loadFont(getClass().getResourceAsStream("/fonts/Daydream.otf"),25);
    static final Image birdHat = new Image("file:imgs/player_with_hat.png", 300, 300, true, true);

    public Outro(GraphicsContext g){
        this.g = g;
    }

    public void draw() {
        g.setFill(Color.rgb(244, 155, 232));
        g.fillRect(0, 0, 1280,720);
        g.setFill(Color.WHITE);
        g.setFont(DaydreamTitle);
        g.fillText("Congratulations!", 250, 100);
        g.setFont(DaydreamSubtitle);
        g.fillText("You threw an epic party,", 375, 160);
        g.fillText("and everyone loved it!", 385, 210);
        g.drawImage(birdHat, 490, 275);
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
    draw();}
}
