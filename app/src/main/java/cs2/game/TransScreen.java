package cs2.game;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TransScreen implements Screen {

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



    public TransScreen(GraphicsContext g, Image sks, Image sup, Image alc) {
        this.g = g;
        this.snacks = new Clickable(new Vec2(65, 400), sks);
        this.supplies = new Clickable(new Vec2(490, 400), sup);
        this.alcohol = new Clickable(new Vec2(915, 400), alc);
    }

        //Checks if the mouse overlaps with the button. 
    private boolean ButtonClicked(double buttonWidth, double buttonX, double buttonY, double mouseX, double mouseY) {
        return mouseX >= buttonX &&
               mouseX <= buttonX + buttonWidth &&
               mouseY >= buttonY &&
               mouseY <= buttonY + 250;
    }

        //Given button, chceks if that button is clicked or not 
    private boolean isButtonClicked(Clickable button, double mouseX, double mouseY){
        Vec2 position = button.getPos(); 
        double w = button.getWidth();
        double x = position.getX();
        double y = position.getY();

        return ButtonClicked(w, x, y, mouseX, mouseY);
    }

        //Returns an integer based on what button is clicked 
    public int isButtonClick(double mouseX, double mouseY){
        if(isButtonClicked(snacks, mouseX, mouseY)) { return 1; }
        if(isButtonClicked(supplies, mouseX, mouseY)) { return 2; }
        if(isButtonClicked(alcohol, mouseX, mouseY)) { return 3; }
        else {return -1;}
    }


    public void draw1() { // this one is for transitioning from a party to a heist
        Xstart += 5;
        if (Xstart > 1280) {Xstart = -300;}
        g.setFill(Color.web("#000000"));
        g.fillRect(0, 0, 1280, 720);
        //g.drawImage(store3, 65, 400);
        //g.drawImage(store2, 490, 400);
        //g.drawImage(store1, 915, 400);
        g.setFont(DaydreamTitle);
        g.setFill(Color.WHITE);
        g.fillText("Which store?", 335, 100);
        g.setFont(DaydreamSubtitle);
        g.fillText("Whoops! Your party sucked!", 300, 40);
        g.drawImage(traverse, Xstart, 100);
        snacks.display(g);
        supplies.display(g);
        alcohol.display(g);
    }

    public void draw2() { // this one is for transitioning from a heist to a party
        g.setFill(Color.BLACK);
        g.fillRect(0, 0, 1280, 720);
        g.setFont(DaydreamTitle);
        g.setFill(Color.WHITE);
        g.fillText("Heist Summary", 335, 200);
        g.setFont(DaydreamSubtitle);
        g.fillText("ph", 400, 250);
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
