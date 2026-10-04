package cs2.game;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class KeyPrompt extends Sprite {
    public boolean isVisible;
    public KeyPrompt(){
        super(new Image("file:imgs/convo5.png"), new Vec2(0,0));
        isVisible = false;
    }
}
