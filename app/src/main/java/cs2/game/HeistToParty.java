package cs2.game;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HeistToParty implements Screen{
    private GraphicsContext g;
    static final Image store1 = new Image("file:imgs/liqa_sto.png",250,250,true,true);
    static final Image store2 = new Image("file:imgs/shindig_town.png", 250,250,true,true);
    static final Image store3 = new Image("file:imgs/snacs.png",250,250,true,true);
    static final Image traverse = new Image("file:imgs/player_run.gif", 300, 300, true, true);
    Font DaydreamTitle = Font.loadFont(getClass().getResourceAsStream("/fonts/Daydream.otf"),50);
    Font DaydreamSubtitle = Font.loadFont(getClass().getResourceAsStream("/fonts/Daydream.otf"),25);
    int Xstart = 450;
    private Clickable snacks;
    private Clickable supplies;
    private Clickable alcohol; 
    //private buttons and g
    private Clickable toParty;

    private final double buttonHeight = 80;



    public HeistToParty(GraphicsContext g) {
        this.g = g;
        this.toParty = new Clickable(new Vec2(490, 450), "Go To Party!");
    }

    //Returns an integer based on what button is clicked 
    public int isButtonClick(double mouseX, double mouseY){
        if(isButtonClicked(toParty, mouseX, mouseY)) { return 4; }
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
    

    public void draw(String results) { // this one is for transitioning from a heist to a party
        g.setFill(Color.BLACK);
        g.fillRect(0, 0, 1280, 720);
        g.setFont(DaydreamTitle);
        g.setFill(Color.WHITE);
        g.fillText("Heist Summary", 335, 200);
        g.setFont(DaydreamSubtitle);
        g.fillText("ph", 400, 250);
        g.fillText(results, 400, 350);

        toParty.display(g);
    }


    public void renderH2P(String name, Integer resources) {
        String results = String.format("%s  %d", name, resources.intValue());
        draw(results);
    }

    @Override
    public void render() {
          // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'render'");
    }
    @Override
    public void update() {
          // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}
