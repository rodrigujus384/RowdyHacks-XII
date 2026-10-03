package cs2.game;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

public class Clickable extends Sprite {
    private String text; 

    public Clickable(Vec2 p){ super(new Image("file:imgs/button_bg.png"), p); }

    public Clickable(Vec2 p, String text) {
        super(new Image("file:imgs/button_bg.png"), p);
        this.text = text; 
    }

    @Override
    public void display(GraphicsContext g) {
        super.display(g);

        g.setFill(Color.BLACK);
        g.setFont(Font.font("Arial", 25));

        Text textObject = new Text(text);
        textObject.setFont(g.getFont());

        double textWidth = textObject.getLayoutBounds().getWidth();
        double textHeight = textObject.getLayoutBounds().getHeight();

        double x = pos.getX() + (getWidth() - textWidth) / 2;
        double y = pos.getY() + (getHeight() + textHeight) / 2;

        g.fillText(text, x, y);
    }
}