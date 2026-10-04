package cs2.game;

public class Heist extends PlayState implements Screen {


    public Heist(Player py, int x, int y) {
        super(py, x, y);
        //TODO Auto-generated constructor stub
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
