package cs2.game;

import java.util.ArrayList;

import cs2.util.Vec2;

public class GameState {
    // Fields
    Vec2 PlayerPos;
    EnemySwarm EnemyState;
    ArrayList<Bullet> BulletState;
    int PLives;
    int PScore;
    int HS;
    boolean HSR;
    boolean BuffHere;
    int PowerUpCount;
    int PowerUpDown;
    boolean PowerUp;
    Vec2 BuffPos;
    
    // Constructor
    public GameState(Vec2 a, EnemySwarm b, ArrayList<Bullet> c, int d, int e, int f, boolean g, boolean h, int i, int j, boolean k, Vec2 l) {
        PlayerPos = a.clone();
        EnemyState = b.clone();
        BulletState = new ArrayList<Bullet>();
        if (!c.isEmpty()) {    
            for (Bullet B : c) {
                BulletState.add(B.clone());
            }
        }
        PLives = d;
        PScore = e;
        HS = f;
        HSR = g;
        BuffHere = h;
        PowerUpCount = i;
        PowerUpDown = j;
        PowerUp = k;
        BuffPos = l;
    }
}
