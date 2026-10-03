package cs2.game;

import cs2.util.Vec2;
import javafx.scene.image.Image;

//sprite existing on grid
public class GameSprite extends Sprite {

    public GameSprite(Image i, Vec2 p){
        super(i, new Vec2(p.getX(), p.getY()));
        //super(i, new Vec2(p.getX()*gridCellSize, p.getY()*gridCellSize));
    }
}
