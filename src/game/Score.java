package game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Score implements Serializable {
    private String name;
    private int highscore;

    /**
     * Beállítja az attribútumokat a kívánt értékekre.
     * @param s
     * @param i
     */
    public Score(String s, int i){
        name = s;
        highscore = i;
    }

    public int getHighscore(){
        return highscore;
    }

    /**
     * Szöveges megjelítést segíti
     * @return
     */
    public String toString(){
        return name + ", "+ highscore;
    }
}
