package cs2.game;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HowToPlayScreen implements Screen {

    private GraphicsContext g;
    private Clickable back; 
    Font DaydreamTitle = Font.loadFont(getClass().getResourceAsStream("/fonts/Daydream.otf"),50);
    Font DaydreamSubtitle = Font.loadFont(getClass().getResourceAsStream("/fonts/Daydream.otf"),25);
    static final Image bars = new Image("file:imgs/PartyBars.png");
    static final Image info = new Image("file:imgs/Information.png", 200, 200, true, true);

    private final double buttonHeight = 80;

    public HowToPlayScreen(GraphicsContext g) {
        this.g = g;
        this.back = new Clickable(new Vec2(500, 500), "Return Home");
    }

    @Override
    public void update() {
        // Nothing to update yet
    }

    @Override
    public void render() {

        // Background
        g.setFill(Color.web("#87cefa"));
        g.fillRect(0, 0, 1280, 720);

        // Popup box
        g.setFill(Color.WHITE);
        g.fillRect(250, 100, 780, 520);

        // Title
        g.setFill(Color.BLACK);
        g.setFont(DaydreamTitle);
        g.fillText("HOW TO PLAY", 400, 170);

        // Instructions
        g.setFont(DaydreamSubtitle);

        g.fillText("WASD or Arrow keys to move", 350, 250);
        g.fillText("E to Interact", 480, 300);

        g.drawImage(bars, 275, 325);
        g.drawImage(info, 500, 325);
        

        //back button
        back.display(g);
    }

    public boolean isButtonClick(double mouseX, double mouseY){
        return isButtonClicked(back, mouseX, mouseY);
    }

    private boolean isButtonClicked(Clickable button, double mouseX, double mouseY){
        Vec2 position = button.getPos(); 
        double w = button.getWidth();
        double x = position.getX();
        double y = position.getY();

        return ButtonClicked(w, x, y, mouseX, mouseY);
    }

    private boolean ButtonClicked(double buttonWidth, double buttonX, double buttonY, double mouseX, double mouseY) {
        return mouseX >= buttonX &&
               mouseX <= buttonX + buttonWidth &&
               mouseY >= buttonY &&
               mouseY <= buttonY + buttonHeight;
    }
}