package cs2.game;

import cs2.util.Vec2;
import javafx.scene.image.Image;

public class Buff extends Sprite {

    Vec2 vel;

    public Buff(Image i, Vec2 p, Vec2 v) {
        super(i, p);
        vel = v;
    }

    public void update() { 
    pos.addThis(vel);
    }
}
