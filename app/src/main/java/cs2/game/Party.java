package cs2.game;

import javafx.scene.canvas.GraphicsContext;

public class Party implements Screen{

    private GraphicsContext g;

    public Party(GraphicsContext g){
        this.g = g;
    }

    private void draw(){
    }

    public boolean isButtonClicked(){
        return false; 
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
