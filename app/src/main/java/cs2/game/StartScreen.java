package cs2.game;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.image.Image;

public class StartScreen implements Screen{

    private Clickable start;
    private Clickable howToPlay; 
    private GraphicsContext g; 

    private final double buttonHeight = 80;

    public StartScreen(GraphicsContext g,Image start, Image how){
        this.g = g;

        System.out.println("Start image: " + start.getWidth() + " x " + start.getHeight());
    System.out.println("How image: " + how.getWidth() + " x " + how.getHeight());

        this.start = new Clickable(start, new Vec2(490, 350));
        this.howToPlay = new Clickable(how, new Vec2(490, 450));
    }

    public void draw() {

        // Background
        g.setFill(Color.rgb(176, 90, 9));
        g.fillRect(0, 0, 1280, 720);

        // Title
        g.setFill(Color.WHITE);
        g.setFont(Font.font("Arial", 60));
        g.fillText("PARTY ANIMAL", 400, 200);

        start.display(g);
        howToPlay.display(g);
    }

    public int isButtonClick(double mouseX, double mouseY){
        if(isButtonClicked(start, mouseX, mouseY)) { return 1; }
        else if(isButtonClicked(howToPlay, mouseX, mouseY)) { return 2; }
        else{ return -1; }
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

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void render() {
        draw(); 
    }
    
}
