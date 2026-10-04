package cs2.game;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.image.Image;

public class StartScreen implements Screen{

    //private buttons and g
    private Clickable start;
    private Clickable howToPlay; 
    private GraphicsContext g; 
    Font Daydream = Font.loadFont(getClass().getResourceAsStream("/fonts/Daydream.otf"),75);

    private final double buttonHeight = 80;

    //Gets the graphics and buttons 
    public StartScreen(GraphicsContext g,Image start, Image how){
        this.g = g;

        //System.out.println("Start image: " + start.getWidth() + " x " + start.getHeight());
        //System.out.println("How image: " + how.getWidth() + " x " + how.getHeight());

        this.start = new Clickable(new Vec2(490, 350), "Start");
        this.howToPlay = new Clickable(new Vec2(490, 450), "How To Play");
    }

    //Draws the graphics for the screen 
    private void draw() {

        // Background
        g.setFill(Color.web("#87cefa"));
        g.fillRect(0, 0, 1280, 720);

        // Title
        g.setFill(Color.WHITE);
        g.setFont(Daydream);
        g.fillText("PARTY ANIMAL", 200, 200);

        start.display(g);
        howToPlay.display(g);
    }

    //Returns an integer based on what button is clicked 
    public int isButtonClick(double mouseX, double mouseY){
        if(isButtonClicked(start, mouseX, mouseY)) { return 1; }
        else if(isButtonClicked(howToPlay, mouseX, mouseY)) { return 2; }
        else{ return -1; }
    }

    //Given button, chceks if that button is clicked or not 
    private boolean isButtonClicked(Clickable button, double mouseX, double mouseY){
        Vec2 position = button.getPos(); 
        double w = button.getWidth();
        double x = position.getX();
        double y = position.getY();

        return ButtonClicked(w, x, y, mouseX, mouseY);
    }

    //Checks if the mouse overlaps with the button. 
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
