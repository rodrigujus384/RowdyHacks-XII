package cs2.game;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

//sprite existing on grid
public class GameSprite extends Sprite {
    Vec2 gridPos;

    public GameSprite(Image i, Vec2 p){
        super(i, new Vec2(p.getX()*MainApp.gridCellSize, p.getY()*MainApp.gridCellSize));
        gridPos = p;
    }

    public void displayWithTranslation(GraphicsContext g, Vec2 delta){
        g.drawImage(this.img, this.pos.getX() - delta.getX(), this.pos.getY() - delta.getY());
    }

    public void moveAlongGrid(int x, int y){
        this.gridPos.addThis(new Vec2(x, y)); 
    }
}
