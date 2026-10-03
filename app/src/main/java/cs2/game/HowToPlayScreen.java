package cs2.game;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HowToPlayScreen implements Screen {

    private GraphicsContext g;
    private Clickable back; 

    private final double buttonHeight = 80;

    public HowToPlayScreen(GraphicsContext g) {
        this.g = g;
        this.back = new Clickable(new Vec2(500, 500));
    }

    @Override
    public void update() {
        // Nothing to update yet
    }

    @Override
    public void render() {

        // Background
        g.setFill(Color.rgb(176, 90, 9));
        g.fillRect(0, 0, 1280, 720);

        // Popup box
        g.setFill(Color.WHITE);
        g.fillRect(250, 100, 780, 520);

        // Title
        g.setFill(Color.BLACK);
        g.setFont(Font.font("Arial", 45));
        g.fillText("HOW TO PLAY", 480, 170);

        // Instructions
        g.setFont(Font.font("Arial", 25));

        g.fillText("WASD - Move", 350, 250);
        g.fillText("E - Interact", 350, 300);
        g.fillText("SPACE - Jump", 350, 350);

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